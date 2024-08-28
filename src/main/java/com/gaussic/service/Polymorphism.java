package com.gaussic.service;

/**
 * @ClassName Polymorphism
 * @Description 多态解决案例中的问题，替换掉AnimalKeeper即可
 * 好处：降低了代码之间的耦合程度，代码冗余性，程序变得容易扩展，符合面向对象的开闭原则
 * @Author huangpengbing
 * @Date 2024/8/28 20:19
 * @Version 1.0
 **/


public class Polymorphism {

    /**
     * Animal animal做形参，编译阶段，animal引用绑定的是Animal类中的eat()方法，这是静态绑定；
     * 运行阶段，由于堆中的对象实际是cat类型，cat重写了父类的方法，所以animal绑定的是Cat中的eat()方法，这是动态绑定
     * @param animal
     */
    public void feed(Animal animal) {
        animal.eat();
    }


}
