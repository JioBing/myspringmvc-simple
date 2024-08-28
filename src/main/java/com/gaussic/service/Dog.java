package com.gaussic.service;

/**
 * @ClassName Dog
 * @Description 小动物狗
 * @Author huangpengbing
 * @Date 2024/8/28 20:21
 * @Version 1.0
 **/


public class Dog extends Animal{
    @Override
    public void eat() {
        System.out.println("够啃骨头");
    }
}
