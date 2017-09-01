# ThreadLocal 学习


> java.lang.ThreadLocal 类提供线程局部变量。
这些变量与其正常的对应方式不同，因为访问一个的线程（通过其get或set方法）具有自己的独立初始化的变量副本。 
ThreadLocal实例通常是希望将状态与线程（例如，用户ID或事务ID）相关联的类中的私有静态字段。

## 1 创建ThreadLocal

> 创建示例(MyThreadLocal为ThreadLocal子类)：
    
    private static MyThreadLocal threadLocal = new MyThreadLocal();
    
> 可以看到，程序实例化了一个新的ThreadLocal对象。
这只需要每个线程完成一次。即使不同的线程执行访问ThreadLococal的相同代码，
每个线程都将只看到它自己的ThreadLocal实例。
即使两个不同的线程在同一个ThreadLocal对象上设置不同的值，它们也看不到对方的值。

> 只要线程存活并且ThreadLocal实例可访问，每个线程都保存对其线程局部变量副本的隐式引用;
线程消失后，线程本地实例的所有副本都将被垃圾收集（除非存在对这些副本的其他引用）。

## 2 访问ThreadLocal实例

> ThreadLocal 提供 get/set方法用来访问当前线程中的局部变量:

### 2.1 public void set(T value)方法

> 源码：

    public void set(T value) {
            Thread t = Thread.currentThread();
            ThreadLocalMap map = getMap(t);
            if (map != null)
                map.set(this, value);
            else
                createMap(t, value);
    }

> 将当前线程的此线程局部变量的副本设置为指定的值。
大多数子类将无需重写此方法，仅依靠initialValue（）方法设置线程本地值的值。

> ThreadLocalMap是ThreadLocal的静态内部类，是一个适用于维护线程本地值的自定义哈希映射。 
没有任何操作会导出到ThreadLocal类之外。 该类是私有的，只允许在Thread类中声明字段。 
使用WeakReferences的键，帮助处理非常大和长期使用的散列表条目。 
但是，由于不使用引用队列，因此只有在表空间不足时，才会删除已保留的条目。详情参考java.lang.ThreadLocal.ThreadLocalMap。

### 2.2 protected T initialValue()方法

> 源码： 

    protected T initialValue() {
        return null;
    }

> 返回此线程局部变量的当前线程的“初始值”。
线程首次使用get()方法访问变量时，将调用此方法；
除非该线程先前调用了set(T)方法，将不会为该线程调用initialValue方法。
通常，每个线程最多调用此方法一次，但是在调用remove()后再次调用get()的情况下，可以再次调用此方法。

> 这个实现只是返回null;
如果程序员希望线程局部变量具有除null之外的初始值，则ThreadLocal必须被子类化，并且覆盖该方法。
通常，使用匿名内部类。

### 2.3 public T get()方法

> 源码：

    public T get() {
        Thread t = Thread.currentThread();
        ThreadLocalMap map = getMap(t);
        if (map != null) {
            ThreadLocalMap.Entry e = map.getEntry(this);
            if (e != null) {
                @SuppressWarnings("unchecked")
                T result = (T)e.value;
                return result;
            }
        }
        return setInitialValue();
    }
    
    private T setInitialValue() {
        T value = initialValue();  //初始化 value
        Thread t = Thread.currentThread();
        ThreadLocalMap map = getMap(t);
        if (map != null)
            map.set(this, value);
        else
            createMap(t, value);
        return value;
    }
    
> 返回当前线程的此线程局部变量的副本中的值。如果变量没有当前线程的值，则首先将其初始化为调用setInitialValue()方法,
并在setInitialValue()中调用initialValue()返回的值。


## 3 初始化ThreadLocal值

### 3.1 通过子类化ThreadLocal并覆盖initialValue()方法

> [参考2.2]()

### 3.2 通过 withInitial 方法

> 创建线程局部变量。变量的初始值通过调用Supplier上的get方法来确定。

> 源码：

    public static <S> ThreadLocal<S> withInitial(Supplier<? extends S> supplier) {
        return new SuppliedThreadLocal<>(supplier);
    }
    
    static final class SuppliedThreadLocal<T> extends ThreadLocal<T> {

        private final Supplier<? extends T> supplier;

        SuppliedThreadLocal(Supplier<? extends T> supplier) {
            this.supplier = Objects.requireNonNull(supplier);
        }

        @Override
        protected T initialValue() {
            return supplier.get();
        }
    }

## 4 ThreadLocal完整示例

    @Slf4j
    public class ThreadA implements Runnable {
    
        // Atomic integer containing the next thread ID to be assigned
        private static final AtomicInteger nextId = new AtomicInteger(0);
    
        // Thread local variable containing each thread's ID
        private static final ThreadLocal<Integer> threadId = ThreadLocal.withInitial(() -> nextId.getAndIncrement());
    
        // Returns the current thread's unique ID, assigning it if necessary
        public static int get() {
            return threadId.get();
        }
    
        @Override
        public void run() {
            log.info("-*--*--*--*- threadId : {}-*--*--*--*--",get());
        }
    
        public static void main(String[] args) {
    
            ExecutorService executorService = Executors.newFixedThreadPool(4);
    
            for (int ignored : IntStream.range(0,100).toArray()){
                executorService.submit(new ThreadA());
            }
        }
    }


## 5 InheritableThreadLocal

> 该类扩展了 ThreadLocal，为子线程提供从父线程那里继承的值：
在创建子线程时，子线程会接收所有可继承的线程局部变量的初始值，以获得父线程所具有的值。
通常，子线程的值与父线程的值是一致的；
但是，通过重写这个类中的 childValue 方法，子线程的值可以作为父线程值的一个任意函数。

> 当必须将变量（如用户 ID 和 事务 ID）中维护的每线程属性（per-thread-attribute）自动传送给创建的所有子线程时，
应尽可能地采用可继承的线程局部变量，而不是采用普通的线程局部变量。

