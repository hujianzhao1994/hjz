package com.hu.basic.string;

/**
 *	功能描述：
 *
 * @author 胡剑钊(hujz)
 *      <p>
 *      创建日期：2016年5月19日  时间：上午11:27:27
 *		</p>
 *
 *
 * 		<p>
 *      修改历史：(修改人，修改时间，修改原因/内容)
 *      </p>
 */
public class String1 {

	public static void main(String[] args) {
		String s1 = new String("abc");
		String s2 = new String("abc");
		String s3 = "ab"+"c";
		String s4 = "a"+"b"+"c";
		String s5 = "abc";
		System.out.println(s1==s2);
		System.out.println(s1==s3);
		System.out.println(s1==s4);
		System.out.println(s3==s4);
		System.out.println(s3==s5);
		System.out.println(s3.hashCode());  //三个hashCode 一样
		System.out.println(s4.hashCode());
		System.out.println(s5.hashCode());
	}
}
