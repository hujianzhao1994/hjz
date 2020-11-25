package com.hu.basic.exception;

/**
 *	功能描述：
 *
 * @author 胡剑钊(hujz)
 *      <p>
 *      创建日期：2016年5月18日  时间：下午5:01:24
 *		</p>
 *
 *
 * 		<p>
 *      修改历史：(修改人，修改时间，修改原因/内容)
 *      </p>
 */
		//考察    System.out.println("out last");  是否会输出？
		/*
		 
		 	//只有捕获了才能继续执行下面的代码，没有捕获就抛出异常
		 
		 */
public class E1 {
	

	public static void main(String[] args) {
		
		int a[] = new int[3];
		try {
			a[3] = 3;
			int c = 1/0;
			System.out.println(a);
//		}catch(ArrayIndexOutOfBoundsException e){
//			System.out.println("arrayIndex");
		}catch (NullPointerException e) {
			System.out.println("NullPointer");
//		}catch(Exception e){
//			System.out.println("万精油");
		}finally{
			System.out.println("finally 居然也会执行");
		}
		System.out.println("out last");
	}

}
