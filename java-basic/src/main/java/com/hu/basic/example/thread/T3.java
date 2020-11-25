package com.hu.basic.thread;

/**
 * 功能描述：
 * 
 * @author 胡剑钊(hujz)
 *         <p>
 *         创建日期：2016年5月18日 时间：下午5:05:35
 *         </p>
 * 
 * 
 *         <p>
 *         修改历史：(修改人，修改时间，修改原因/内容)
 *         </p>
 */
public class T3 {
	public static Object object = new Object();

	public static void main(String[] args) {
		Thread1 thread1 = new Thread1();
		Thread2 thread2 = new Thread2();

		thread1.start();

		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		thread2.start();
	}

	static class Thread1 extends Thread {
		@Override
		public void run() {
			synchronized (object) {
				try {
					object.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("线程" + Thread.currentThread().getName()
						+ "获取到了锁");
			}
		}
	}

	static class Thread2 extends Thread {
		@Override
		public void run() {
			synchronized (object) {
				object.notify();
				System.out.println("线程" + Thread.currentThread().getName()
						+ "调用了object.notify()");
			}
			System.out.println("线程" + Thread.currentThread().getName() + "释放了锁");
		}
	}
}
