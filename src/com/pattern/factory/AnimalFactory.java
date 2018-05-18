package com.pattern.factory;

import com.pattern.Cat;
import com.pattern.Dog;

public class AnimalFactory {
	private AnimalFactory(){	
	}
	
	public static Dog createDog(){
		return new Dog();
	}
	
	public static Cat createCat(){
		return new Cat();
	}
	
}
