package com.hu.basic.continues;

/**
 * 功能描述：
 * 
 * @author 胡剑钊(hujz)
 *         <p>
 *         创建日期：2016年5月20日 时间：上午10:02:46
 *         </p>
 * 
 * 
 *         <p>
 *         修改历史：(修改人，修改时间，修改原因/内容)
 *         </p>
 */
/*
 * continue 结束当前数的循环，进入下一个数的循环
 */
public class ContinueT {

	public static void main(String[] args) {
		getAnswer();
	}

	public static void getAnswer() {
		for (int i = 0; i <= 5; i++) {
			if (i == 3)
				continue;
			System.out.print(i + "\t");
		}
	}
}
