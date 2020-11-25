package com.hu.basic.thread;

public class ThreadT2 {
	
	public static void main(String[] args) {
		ThreadClass t1 = new ThreadClass();
		Thread t2 = new Thread(t1);
		t2.start();
		t2.run();
	}
	
	

}

class ThreadClass implements Runnable{

	@Override
	public void run() {
		System.out.println("ping");
	}
	
}
