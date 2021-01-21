package designpattern.factory;

import designpattern.common.Bus;
import designpattern.common.Car;
import designpattern.common.Plane;
import designpattern.common.Transport;

/**
 * @author jasongaoj
 * @version 1.0.0
 * @description 工厂方法模式
 * @createTime 2021年01月21日 14:19:00
 */
public class MethodFactory {
    public static void main(String[] args) {
        Factory factory1=new BusFactory();
        factory1.newTransport().drive();
        Factory factory2=new CarFactory();
        factory2.newTransport().drive();
        Factory factory3=new PlaneFactory();
        factory3.newTransport().drive();
    }
}

class BusFactory implements Factory{

    @Override
    public Transport newTransport() {
        return new Bus();
    }
}
class CarFactory implements Factory{

    @Override
    public Transport newTransport() {
        return new Car();
    }
}
class PlaneFactory implements Factory{

    @Override
    public Transport newTransport() {
        return new Plane();
    }
}
