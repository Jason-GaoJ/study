package designpattern.singleton;

/**
 * @author jasongaoj
 * @version 1.0.0
 * @Description 饿汉式单例
 * @createTime 2021年01月21日 10:27:00
 */
public class Singleton1 {
    //JVM保证线程安全
    private static Singleton1 singleton=new Singleton1();

    private Singleton1(){};

    public Singleton1 instance(){
        return singleton;
    }
}
