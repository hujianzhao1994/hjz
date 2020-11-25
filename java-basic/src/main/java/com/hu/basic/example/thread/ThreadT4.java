package com.hu.basic.thread;
/*
 我运行了很多次，结果都是pong ping。
 后来终于发现了关键点所在:
 	线程对象t，调用的不是start()方法，而是run()方法。后来我开断点模式debug，发现调用run()方法，整个程序只有一个线程，而调用start()方法之后，程序就会多出一个线程。
 	这时才有和主线程争cpu，可能出现多种结果的情况，但由于下面输出方法很快就被执行了，所以基本上都是“ping pong”的输出。
所以run()和start()的区别就是：
run()是Runnable接口中定义的一个方法，是为了让客户程序员在这个方法里写自己的功能代码的。直接调用和普通的类调用自己的成员方法是没有任何区别的。
而start()则是线程开始运行的标志，当这个方法被调用后，程序中才会多出一个独立的线程，接着便是执行run()方法。
所以我觉得，自己要写单独的线程，最好还是继承Thread来做，如果是实现接口的话，到主线程里，还是要new Thread(new YourRunnableClass())来调用，感觉很不方便。
 
 */
public class ThreadT4 {

	public static void main(String args[]) {
		
		Thread t = new Thread() {
			public void run() {
				pong();
			}
		}; 
		t.start(); // t.run();
		System.out.println("ping");
	}
	static void pong() {
		System.out.println("pong");
	}
}
