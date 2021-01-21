package designpattern.factory;

import designpattern.common.Bus;
import designpattern.common.Car;
import designpattern.common.Plane;
import designpattern.common.Transport;

/**
 * @author jasongaoj
 * @version 1.0.0
 * @Description 简单工厂（SimpleFactory）：是简单工厂模式的核心，负责实现创建所有实例的内部逻辑。
 * 工厂类的创建产品类的方法可以被外界直接调用，创建所需的产品对象
 * @createTime 2021年01月21日 11:20:00
 */
public class SimpleFactory {


    public Transport getTransport(int type){
        switch (type){
            case 1:
                return new Bus();
            case 2:
                return new Car();
            case 3:
                return new Plane();
            default:
                return null;
        }
    }

}
