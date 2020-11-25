package com.hu.basic.thread;

/**
 *	功能描述：
 *
 * @author 胡剑钊(hujz)
 *      <p>
 *      创建日期：2016年5月18日  时间：下午4:51:04
 *		</p>
 *
 *
 * 		<p>
 *      修改历史：(修改人，修改时间，修改原因/内容)
 *      </p>
 */
public class T1 {

	public static void main(String[] args){
		Thread1 t = new Thread1();
		Thread thread = new Thread(t); //new　Thread(String name)  分配新的Thread对象
		thread.start();
		thread.run();


	}

}

class Thread1 implements Runnable{

	public void run(){
		System.out.println("pong");
	}
}
