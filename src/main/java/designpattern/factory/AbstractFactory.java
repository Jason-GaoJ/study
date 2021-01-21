package designpattern.factory;

import designpattern.common.*;

/**
 * @author jasongaoj
 * @version 1.0.0
 * @description 抽象工厂，生产产品族
 * @createTime 2021年01月21日 14:48:00
 */
public interface AbstractFactory {
    public void newTransport();
    public void newPeople();
}
class Factory1 implements AbstractFactory{

    @Override
    public void newTransport() {
        new Bus().drive();
    }

    @Override
    public void newPeople() {
        new Child().driver();
    }
}
class Factory2 implements AbstractFactory{

    @Override
    public void newTransport() {
        new Car().drive();
    }

    @Override
    public void newPeople() {
        new Adults().driver();
    }
}
class Factory3 implements AbstractFactory{

    @Override
    public void newTransport() {
        new Plane().drive();
    }

    @Override
    public void newPeople() {
        new Elderly().driver();
    }
}
class M{
    public static void main(String[] args) {
        AbstractFactory factory1=new Factory1();
        factory1.newPeople();
        factory1.newTransport();
        AbstractFactory factory2=new Factory2();
        factory2.newPeople();
        factory2.newTransport();
        AbstractFactory factory3=new Factory3();
        factory3.newPeople();
        factory3.newTransport();
    }
}