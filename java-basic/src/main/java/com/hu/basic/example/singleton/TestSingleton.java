package com.hu.basic.singleton;

public class TestSingleton {
	
	public static void main(String[] args){
		System.out.println("SingletonDemo1"+SingletonDemo1.getInstance());
		System.out.println("SingletonDemo1"+SingletonDemo1.getInstance());
		System.out.println("----------------------------");
		System.out.println("SingletonDemo2"+SingletonDemo2.INSTANCE);
		System.out.println("SingletonDemo2"+SingletonDemo2.INSTANCE);
		System.out.println("----------------------------");
		
		System.out.println("SingletonDemo3"+SingletonDemo3.getInstance());
		System.out.println("SingletonDemo3"+SingletonDemo3.getInstance());
		System.out.println("----------------------------");
		
		System.out.println("SingletonDemo4"+SingletonDemo4.INSTANCE);
		System.out.println("SingletonDemo4"+SingletonDemo4.INSTANCE);
		SingletonDemo4.say("胡剑钊");
		System.out.println("----------------------------");
	}

}
