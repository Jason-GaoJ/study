package designpattern.singleton;

/**
 * @author jasongaoj
 * @version 1.0.0
 * @Description 懒汉式单例
 * @createTime 2021年01月21日 10:31:00
 */
public class Singleton2 {

    private Singleton2() {
    }

    //volatile保持线程间的可见性，防止指令重排序
    //加上volatile是为了禁止指令重排序，因为new 不是一个原子性的操作，
    // 1.分配对象内存，2.调用构造器方法，执行初始化，3.将对象引用赋值给变量
    //虚拟机运行时，1 这个指令都需要先执行，因为 2,3 指令需要依托 1 指令执行结果
    //所以2，3可能会发生指令重排序，当多线程并发时可能会导致某些线程拿到不完整的对象
    private static volatile Singleton2 singleton;

    private static Object object = new Object();

    public static Singleton2 instance() {
        if (singleton == null) {
            synchronized (object) {
                if (singleton == null) {
                    singleton = new Singleton2();
                }
            }
        }
        return singleton;
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            int i = 0;
            while (i < 100) {
                Singleton2 s = Singleton2.instance();
                System.out.println(s.toString());
                i++;
            }
        });

        Thread t2 = new Thread(() -> {
            int i = 0;
            while (i < 100) {
                Singleton2 s = Singleton2.instance();
                System.out.println(s.toString());
                i++;
            }
        });

        t1.start();
        t2.start();
    }
}
