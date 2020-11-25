package com.hu.basic.singleton;

/**
 *
 * 公共域方式：简单	
 *
 */
public class SingletonDemo2 {

	public static final SingletonDemo2 INSTANCE = new SingletonDemo2();
	
	private SingletonDemo2(){}
}
