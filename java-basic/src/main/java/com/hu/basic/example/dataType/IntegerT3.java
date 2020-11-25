package com.hu.basic.dataType;

/**
 *	功能描述：
 *
 * @author 胡剑钊(hujz)
 *      <p>
 *      创建日期：2016年5月20日  时间：下午1:55:43
 *		</p>
 *
 *
 * 		<p>
 *      修改历史：(修改人，修改时间，修改原因/内容)
 *      </p>
 */
public class IntegerT3 {

		
		public static void main(String[] args) {
			Integer f1 = 100, f2 = 100, f3 = 150, f4 = 150;
			
			
			System.out.println(f1==f2);    //true  
			System.out.println(f3>=f4);    //false  
			
			
			//字面量的值在-128到127之间，那么不会new新的Integer对象，而是直接引用常量池中的Integer对象，所以上面的面试题中f1==f2的结果是true，而f3==f4的结果是false。
		}


}
