package thread;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jasongaoj
 * @version 1.0.0
 * @description TODO
 * @createTime 2021年01月22日 10:02:00
 */
public class VolatileTest {

    private static volatile int i=0;

    public static void main(String[] args) {
        for (int j = 0; j < 10000; j++) {
            Thread t=new Thread(()->{
                    i++;
            },"t"+j);

            t.start();
        }
        System.out.println(i);
    }
}
