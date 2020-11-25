package com.hu.basic.singleton;

/**
 *
 * 工厂化 方式：可以在实例化过程中添加逻辑
 *
 */
public class SingletonDemo3 {

	public static final SingletonDemo3 INSTANCE = new SingletonDemo3();
	
	private SingletonDemo3(){}
	
	public static SingletonDemo3 getInstance(){
		//此处可以写逻辑
		return INSTANCE;
	}
}
