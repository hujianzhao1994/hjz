package com.hu.basic.extend;

/*
 	考察构造函数的调用
 */
public class Extends2 {
	public static void main(String[] args) {
		new Son1("as");
	}

}

class Father1{
	private String name;
	
	public Father1(){
		System.out.println(1);
	}
	
	public Father1(String name){
		System.out.println(2);
		this.name = name;
	}
}

class Son1 extends Father1{
	
	public Son1(){
		System.out.println(3);
	}
	
	public Son1(String name){
		super(name);
		System.out.println(4);
	}
}
