import org.laidu.learn.jvm.classloader.HelloService;

public class HelloHeiHei implements HelloService {

    @Override
    public void sayHello(){
        System.out.println("hello heihei");
    }

    public static void main(String[] args) {
        new HelloWorld().sayHello();
    }

    public static class HelloHaHa implements HelloService {

        @Override
        public void sayHello(){
            System.out.println("hello haha");
        }

        public static void main(String[] args) {
            new HelloWorld().sayHello();
        }
    }

    public static class HelloGaGa implements HelloService {

        @Override
        public void sayHello(){
            System.out.println("hello gaga");
        }

        public static void main(String[] args) {
            new HelloWorld().sayHello();
        }
    }
}

