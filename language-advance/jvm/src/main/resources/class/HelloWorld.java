import org.laidu.learn.jvm.classloader.HelloService;

public class HelloWorld implements HelloService {

    @Override
    public void sayHello(){
        System.out.println("hello world");
    }

    public static void main(String[] args) {
        new HelloWorld().sayHello();
    }
}