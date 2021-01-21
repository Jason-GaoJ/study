package thread;

/**
 * @author jasongaoj
 * @version 1.0.0
 * @Description TODO
 * @createTime 2020年12月24日 19:00:00
 */
public class ThreadLocalTest {

    private static ThreadLocal<String> threadLocal=new ThreadLocal<>();

    public static void main(String[] args) {
        threadLocal.set("");
        Integer s;
    }
}
