package com.hu.basic.thread2;


/**
 ···试题：编写一个程序，能够体现多线程的例子？假设t1,t2两个程序，如何保证t2线程必须在t1执行之后再执行？
   		答案：两个线程在交替的执行，这就是多线程的体现	
			如果需要在一个线程执行完后，再继续执行后续的线程，即串行执行，使用join();
 *
 */
public class ThreadDemo1 implements Runnable{

	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			System.out.println("线程-->"+Thread.currentThread().getName()+"-"+i);
		}
	}

	
	public static void main(String[] args) throws InterruptedException {
		Thread thread1 = new Thread(new Thread(new ThreadDemo1()));
		thread1.start();
		thread1.join(); //在上述线程执行完后再执行后续线程的内容
		new Thread(new ThreadDemo1()).start();
	}
}
