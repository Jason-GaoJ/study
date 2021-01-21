package designpattern.prototype;

import java.time.Duration;
import java.time.LocalDateTime;

/**
 * @author jasongaoj
 * @version 1.0.0
 * @Description 原型模式
 * @createTime 2021年01月21日 10:55:00
 */
public class Prototype implements Cloneable {

    private String name="ssss";
    private int age=100;

    @Override
    protected Prototype clone() throws CloneNotSupportedException {
        return (Prototype) super.clone();
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        int i=0;
        LocalDateTime localDateTime=LocalDateTime.now();
        int num=Integer.MAX_VALUE;
        while (i<num){
            i++;
            Prototype prototype=new Prototype();
        }
        System.out.println("new ："+ Duration.between(localDateTime, LocalDateTime.now()).getNano());

        System.gc();

        int j=0;
        LocalDateTime l=LocalDateTime.now();
        Prototype prototype=new Prototype();
        while (j<num){
            j++;
            Prototype o=prototype.clone();
        }
        System.out.println("clone ："+ Duration.between(l, LocalDateTime.now()).getNano());
    }
}
