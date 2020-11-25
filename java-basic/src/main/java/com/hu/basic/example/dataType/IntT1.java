package com.hu.basic.dataType;

/**
 *	功能描述：
 *
 * @author 胡剑钊(hujz)
 *      <p>
 *      创建日期：2016年5月20日  时间：下午1:52:48
 *		</p>
 *
 *
 * 		<p>
 *      修改历史：(修改人，修改时间，修改原因/内容)
 *      </p>
 */
public class IntT1 {



	public static void main(String[] args) {
		Integer a = new Integer(3);
		Integer b = 3;   // 将3自动装箱成Integer类型 
		int c = 3;
		System.out.println(a==b);   //false 两个引用没有引用同一个对象
		System.out.println(a==c);  //true   a自动拆箱成int类型再和c比较
		
	}

}
