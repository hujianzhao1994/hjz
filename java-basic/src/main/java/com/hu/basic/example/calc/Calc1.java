package com.hu.basic.calc;

/**
 *	功能描述：逻辑运算符=
 *
 * @author 胡剑钊(hujz)
 *      <p>
 *      创建日期：2016年5月19日  时间：下午12:01:19
 *		</p>
 *
 *
 * 		<p>
 *      修改历史：(修改人，修改时间，修改原因/内容)
 *      </p>
 */
public class Calc1 {

	
	public static void main(String[] args) {
		System.out.println(3<<2);  //3左移2位  3*2^2
		System.out.println(3>>2);  
		System.out.println(3<<3);   //3左移3位 3*2^3
		System.out.println(2<<3); //2左移 3位   2*2^3
		System.out.println(1&0);
		int s = 11;
		String ret = null;
		if(s/10==1 && s%2==1){
			ret = "true";
		}else{
			ret = "false";
		}
		System.out.println(ret);
		System.out.println(Math.round(-11.5));
		System.out.println(Math.round(11.4));
	}
}
