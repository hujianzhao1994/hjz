package com.hu.basic.star;

/**
 *	功能描述：以1 开始，标准版本
 *
 * @author 胡剑钊(hujz)
 *      <p>
 *      创建日期：2016年6月22日  时间：上午11:00:36
 *		</p>
 *
 *
 * 		<p>
 *      修改历史：(修改人，修改时间，修改原因/内容)
 *      </p>
 */
public class Star1 {

	public static void main(String[] args) {
		getStar2(5);
		getStar2(7);
		getStar2(9);
	}
	
	public static void getStar2(int n){
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j<=n-i ; j++) {
				System.out.print(" ");
			}
			for (int k = 1; k <= 2*i-1; k++) {
				System.out.print("*");
			}
			
			System.out.println();
		}
		for (int i = n-1; i >0; i--) {
			for (int j = 1; j <= n-i; j++) {
				System.out.print(" ");
			}
			for (int k = 1; k <= 2*i-1; k++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
