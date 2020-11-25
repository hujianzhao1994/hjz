package com.hu.basic.staticAndConstructor;

/**
 *	功能描述：看类中的静态变量和静态块的执行顺序
 *
 * @author 胡剑钊(hujz)
 *      <p>
 *      创建日期：2016年5月20日  时间：上午9:01:05
 *		</p>
 *
 *
 * 		<p>
 *      修改历史：(修改人，修改时间，修改原因/内容)
 *      </p>
 *      
 *      执行结果： 先执行静态常量中的，而后执行静态块中的，静态常量可用于静态块的使用
 */
public class StaticT1 {

	private static Integer s = 3;
	private static String  staticProperties = "a";
	static{
		s=2;
	}
	
	

	public static void main(String[] args) {
		int a  = StaticT1.s;  //该行代码先执行静态常量，而后执行静态块，返回的是执行完静态块之后的值
		System.out.println(a);  
		System.out.println(StaticT1.staticProperties);
		System.out.println(new StaticT1().staticProperties);
		System.out.println(StaticT1.s);
	}
	
}

class TestMain{
	
}