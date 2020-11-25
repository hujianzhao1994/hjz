package com.hu.basic.dataType;

/**
 *	功能描述：String 和char 的关系
 *
 * @author 胡剑钊(hujz)
 *      <p>
 *      创建日期：2016年5月18日  时间：下午4:45:37
 *		</p>
 *
 *
 * 		<p>
 *      修改历史：(修改人，修改时间，修改原因/内容)
 *      </p>
 */
public class CharT {

public static void main(String[] args) {
		
		String str = "sadas";
		char[] a = {'a','b','c'};
		change(str,a);
	}
	
	public static void change(String str,char[]a){
		str = "test ok";
		a[0] = 'g';
		System.out.println(str);
		System.out.println(a);
	}

	
}
