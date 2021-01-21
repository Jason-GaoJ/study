package test;

import java.util.Scanner;
import java.util.concurrent.*;

/**
 * @author Jason
 * @date 2020/6/24 17:15
 * @description
 */
public class TestThreadPool {

    private static LinkedBlockingQueue<String> queue=new LinkedBlockingQueue<>();

    private static ExecutorService executorService= Executors.newFixedThreadPool(3);

    public static void main(String[] args) {
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                while (true){
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    String s = queue.poll();
                    while (s != null) {
                        System.out.println(Thread.currentThread().getName()+"  输入数据：" + s);
                        s = queue.poll();
                    }
                }
            }
        });

        while (true){
            testScanner();
        }
    }

    public static void testScanner(){
        Scanner scanner=new Scanner(System.in);
        String str=scanner.nextLine();
        queue.offer(str);
    }

    public static LinkedBlockingQueue<String> getQueue() {
        return queue;
    }

    public static void setQueue(LinkedBlockingQueue<String> queue) {
        TestThreadPool.queue = queue;
    }

    public static ExecutorService getExecutorService() {
        return executorService;
    }

    public static void setExecutorService(ExecutorService executorService) {
        TestThreadPool.executorService = executorService;
    }
}
