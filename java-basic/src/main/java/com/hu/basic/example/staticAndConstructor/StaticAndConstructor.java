package com.hu.basic.staticAndConstructor;

//继承环境，静态块逐级加载，然后构造块，接着就是构造方法  ，静态块就加载一次，构造块和构造方法根据实例对象个数加载
public class StaticAndConstructor {

	public static void main(String[] args) {
		new A();
		new B();
		// A static //继承环境，静态块逐级加载，、
		// B static //构造块，与构造方法一致，但是先于构造方法执行
		// A it's A class //静态块加载一次，构造块和构造方法根据实例对象个数加载
		// A constrator //
		// B its B class //
		// B constrator
		// A it's A class
		// A constrator
		// B its B class //
		// B constrator //
	}

}

class A {
	private String name = "A";

	public A() {
		System.out.println("A constructor:" + name);
	}

	{
		System.out.println("it's A class");
	}
	static {
		System.out.println("A static");
	}
}

class B extends A {
	private String name = "B";

	public B() {
		System.out.println("B constructor" + name);
	}

	{
		System.out.println("it's B class");
	}

	static {
		System.out.println("B static");
	}
}