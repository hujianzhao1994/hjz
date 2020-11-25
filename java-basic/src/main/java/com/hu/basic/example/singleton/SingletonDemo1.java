package com.hu.basic.singleton;


/**
 * 		简单的方式，在并发情况下存在多个实例
 *
 */
public class SingletonDemo1 {

	private static SingletonDemo1 INSTANCE;
	
	private SingletonDemo1(){}
	
	public static SingletonDemo1 getInstance(){
		if(INSTANCE == null){
			INSTANCE = new SingletonDemo1();
		}
		return INSTANCE;
	}
}
