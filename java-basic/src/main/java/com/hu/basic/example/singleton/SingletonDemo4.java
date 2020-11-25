package com.hu.basic.singleton;
/**
   枚举类方式：最佳实践，推荐 
 *
 */
public enum SingletonDemo4 {
	INSTANCE;
	
	
	public static void say(String str){
		System.out.println("HELLO "+str+"I am enum Singleton");
	}
}

