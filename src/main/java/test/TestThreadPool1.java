package test;

import java.util.Scanner;
import java.util.concurrent.*;

/**
 * @author Jason
 * @date 2020/6/24 17:15
 * @description
 */
public class TestThreadPool1 {

    private static LinkedBlockingQueue<String> queue=TestThreadPool.getQueue();

    private static ExecutorService executorService= new ThreadPoolExecutor(1,1,0L,TimeUnit.MILLISECONDS,new LinkedBlockingDeque<Runnable>());

    public static void main(String[] args) {
        while (true){
            testScanner();
        }

    }

    public static void testScanner(){
        Scanner scanner=new Scanner(System.in);
        String str=scanner.next();
        queue.offer(str);
    }

}
