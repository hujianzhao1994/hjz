package com.hu.basic.string;

public class String2 {

	
	public static void main(String[] args) {
		String a = "Programming";
		String b = new String("Programming");
		String c = "Program" +"ming";
		
		System.out.println(a==b);  //false
		System.out.println(a==c);   //true         ==   比较的是地址和内容
		System.out.println(a.equals(b));  //true    
		System.out.println(a.equals(c));   //true   equals()   比较的是内容，
		System.out.println(a.intern() == b.intern());  //true       当且仅当 s.equals(t) 为 true 时，s.intern() == t.intern() 才为 true
	}
}
