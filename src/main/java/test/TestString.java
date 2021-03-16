package test;

import java.util.ArrayList;
import java.util.concurrent.*;

/**
 * @author jasongaoj
 * @version 1.0.0
 * @description TODO
 * @createTime 2021年02月22日 18:35:00
 */
public class TestString {

    public static void main(String[] args) {
        String b=new String("a");
        String a="a";
        String c=a+b;
        String d=b+"a";
        System.out.println((a==b)+"----"+(a.equals(b)));
        System.out.println((c==d)+"----"+(c.equals(d)));
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        TimeUnit unit;
        BlockingQueue workQueue=new LinkedBlockingDeque();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 1, TimeUnit.DAYS, workQueue);

    }
}
