package com.hu.basic.extend;

public class Extend1{
	public static void main(String[] args) {
		new Child();
	}
}

class Child extends Base{

	private String name = "child";
	
	public Child(){
		tellName();
		printName();
	}

	public void printName() {
		System.out.println("print name:"+name);
	}

	public void tellName() {
		System.out.println("tell name:"+name);
	}
	
	

}
class Base{
	private String name = "base";
	public Base(){
		tellName();
		printName();
	}
	public void printName() {
		System.out.println("print name:"+name);
	}

	public void tellName() {
		System.out.println("tell name:"+name);
	}
}