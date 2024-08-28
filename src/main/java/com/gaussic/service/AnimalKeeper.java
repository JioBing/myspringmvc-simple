package com.gaussic.service;

/**
 * @ClassName AnimalKeeper
 * @Description TODO
 * @Author huangpengbing
 * @Date 2024/8/28 20:24
 * @Version 1.0
 **/


public class AnimalKeeper {

    public void feed(Cat cat) {
        cat.eat();
    }

    public void feed(Dog dog) {
        dog.eat();
    }

    public void feed(Bird bird) {
        bird.eat();
    }


    public static void main(String[] args) {
        //创建饲养员对象
        AnimalKeeper animalKeeper = new AnimalKeeper();

        //创建宠物对象
        Cat cat = new Cat();
        animalKeeper.feed(cat);//猫吃鱼！

        Dog dog = new Dog();
        animalKeeper.feed(dog);//狗啃骨头！


        Bird bird = new Bird();
        animalKeeper.feed(bird);
        /**
         * 场景：此时如果需要再来一直鸟，需要实现同样的业务逻。普通做法就是，新建一个鸟类（继承Animal）,此时一切还算正常
         * 接下来，需要修改AnimalKeeper类中的代码
         * public void feed(Bird bird) {
         *         bird.eat();
         *     }
         *     这样做违反了面相对象开发的开闭原则，且代码耦合度高，不易扩展
         *     用多态实现的做法，Polymorphism
         */

    }
}
