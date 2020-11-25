package com.hu.basic.thread;

/**
 *	功能描述：
 *
 * @author 胡剑钊(hujz)
 *      <p>
 *      创建日期：2016年5月18日  时间：下午4:52:46
 *		</p>
 *
 *
 * 		<p>
 *      修改历史：(修改人，修改时间，修改原因/内容)
 *      </p>
 */
//	在发生Exception情况下，捕获异常后，继续运行finally块之后的事情                          
//  在还没有运行到System.exit(0)的情况下，finally块都会执行,否则finally块和finally块之后都不执行
public class T2 {

	public static void main(String[] args) {
		
		try {
			System.out.println("hello");
			System.exit(1);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			System.out.println("finally");
		}
		System.out.println("end");
	}
}
