package com.hu.basic.staticAndConstructor;

public class StaticT2 {
	public static void main(String[] args) {
		Parent p = new Child();
		Child c = new Child();
		System.out.println(Parent.a);
		System.out.println(Child.a);
		System.out.println(p.a);  //这个为什么？？父类的引用对象指向子类对象  正规调用方法： 父类类名.静态常量
		System.out.println(c.a); 
	}
	
}

class Parent {

	static int a = 1;
	static{
		a = 10;
		System.out.println("Parent static code");
	}
	public Parent(){
		System.out.println("Parent constructor code");
	}
	
}
class Child extends Parent{
	static int a = 2;
	static{
		 a= 20;
		System.out.println("Child static code");
	}
	
	public Child(){
		System.out.println("Child constructor code");
	}
}
