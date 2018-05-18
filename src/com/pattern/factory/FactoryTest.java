package com.pattern.factory;
/*
 * �򵥹���ģʽ
 * �ɹ����ഴ������
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
