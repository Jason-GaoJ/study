package thread;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * @author jasongaoj
 * @version 1.0.0
 * @Description 固定容量同步容器
 * @createTime 2021年01月04日 15:59:00
 */
public class SyncContainer {

    static Vector<Object> list=new Vector<>();

    public static void put(Object o){
        list.add(o);
    }

    public static Object get(int i){
        return list.get(i);
    }

    public static Integer getCount(){
        return list.size();
    }

    public static void main(String[] args) {
        Thread p1=new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("p1 start...");
                for (int i = 0; i < 5; i++) {
                    put(new Object());
                }
                System.out.println("p1 end...");
            }
        }, "p1");
        Thread p2=new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("p2 start...");
                for (int i = 0; i < 5; i++) {
                    put(new Object());
                }
                System.out.println("p2 end...");
            }
        }, "p2");

        p1.start();
    }
}
