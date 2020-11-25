package com.hu.basic.thread;

public class ThreadT3 {

	public static void main(String[] args) {
		Thread t = new Thread(){
			public  void run(){
				pong();
				System.out.println("ping");
			}
		};
		t.run();
	}
	
	public static void pong(){
		System.out.println("pong");
	}
}
