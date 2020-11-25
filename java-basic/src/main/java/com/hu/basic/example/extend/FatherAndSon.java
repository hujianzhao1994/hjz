package com.hu.basic.extend;

/**
 *	功能描述：
 *
 * @author 胡剑钊(hujz)
 *      <p>
 *      创建日期：2016年5月10日  时间：下午7:40:16
 *		</p>
 *
 *
 * 		<p>
 *      修改历史：(修改人，修改时间，修改原因/内容)
 *      </p>
 */
public class FatherAndSon {

	public static void main(String[] args) {
		Father f = new Father();
		Son s = new Son();
		System.out.println(s.a);
		System.out.println(s.getA());
		f.minner();
		System.out.println(s.a);
		System.out.println(s.getA());
		
	}
	
}

class Father{
	int a = 100;
	public int minner(){
		return a--;
	}
}

class Son extends Father{
	int a = 0;
	public int getA(){
		return super.a;
	}
}
