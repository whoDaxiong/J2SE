package com.pattern.factory;
/*
 * 简单工厂模式
 * 由工厂类创建对象
 */

import com.pattern.Cat;
import com.pattern.Dog;

public class FactoryTest {
	public static void main(String[] args) {
		Dog d = AnimalFactory.createDog();
		Cat c = AnimalFactory.createCat();
		d.eat();
		c.eat();
	}
}
