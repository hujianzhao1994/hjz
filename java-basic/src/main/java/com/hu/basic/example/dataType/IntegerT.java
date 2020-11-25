package com.hu.basic.dataType;

/**
 *	功能描述：
 *
 * @author 胡剑钊(hujz)
 *      <p>
 *      创建日期：2016年5月20日  时间：上午8:55:47
 *		</p>
 *
 *
 * 		<p>
 *      修改历史：(修改人，修改时间，修改原因/内容)
 *      </p>
 */
public class IntegerT {

	public static void main(String[] args) {
		Integer integer1 = new Integer(10);
		int i = 10;
		Integer integer2 = 10;
		Integer integer3 = Integer.valueOf(integer1);
		System.out.println(integer1==i);
		System.out.println(i==integer2);
		System.out.println(integer1==integer3);
		
		float f = 2f;
		long l = 2l;
		System.out.println(f==l);
	}
}
