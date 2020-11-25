package com.hu.basic.exception;

/**
 *	功能描述：
 *
 * @author 胡剑钊(hujz)
 *      <p>
 *      创建日期：2016年5月20日  时间：上午10:03:52
 *		</p>
 *
 *
 * 		<p>
 *      修改历史：(修改人，修改时间，修改原因/内容)
 *      </p>
 */
public class ExceptionT3 {
	/**
	 * 	
	 * 	在发生Exception情况下，捕获异常后，继续运行finally块之后的事情
	 * ` 在还没有运行到System.exit(0)的情况下，finally块都会执行,否则finally块和finally块之后都不执行
	 */
	public static void main(String[] args) {
		
		try {
			int a = 9;
			int b = a/0;
			System.out.println("执行system.exit(0) 之后，finally块以及finally 块之后都不执行");
			System.exit(0);
		}catch (ArithmeticException e) {
			System.out.println("execute ArithmeticExceptio1");
		}catch (NullPointerException e) {
			System.out.println("execute NullPointerException2");
		}finally{
			System.out.println("finally 块，无论怎样都执行");
		}
		
		System.out.println("after finally");
	}
}    
	