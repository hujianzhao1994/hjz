package com.hu.basic.extend;

/**
 *	功能描述：
 *
 * @author 胡剑钊(hujz)
 *      <p>
 *      创建日期：2016年6月28日  时间：上午10:23:13
 *		</p>
 *
 *
 * 		<p>
 *      修改历史：(修改人，修改时间，修改原因/内容)
 *      </p>
 */
public class InnerOutClassTest {
	public static void main(String[] args) {
		OutClass oc = new OutClass();
	}
}

class OutClass{

	private class Inclass{
		public Inclass(){
			System.out.println("InterClass Create");
		}
	}
	
	public OutClass(){
		Inclass ic = new Inclass();
		System.out.println("outClass Create");
	}
}

