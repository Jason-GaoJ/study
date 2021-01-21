package designpattern.common;

/**
 * @author jasongaoj
 * @version 1.0.0
 * @description TODO
 * @createTime 2021年01月21日 11:33:00
 */
public class Bus implements Transport{
    @Override
    public void drive() {
        System.out.println("我是bus。。。");
    }
}
