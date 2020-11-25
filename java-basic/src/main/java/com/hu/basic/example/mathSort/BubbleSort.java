package com.hu.basic.mathSort;

/**
 *	功能描述： 冒泡算法 
 *  http://www.aspku.com/kaifa/java/99929.html
 * @author 胡剑钊(hujz)
 *      <p>
 *      创建日期：2016年5月17日  时间：上午8:42:01
 *		</p>
 *
 *
 * 		<p>
 *      修改历史：(修改人，修改时间，修改原因/内容)
 *      </p>
 */
public class BubbleSort{
	
	public static void main(String[] args) {
		
		int[] a = { 62, 54, 68, 73, 99, 22, 46, 83, 22, 70 }; 
		sort(a);
	}
	
	public static void sort(int[] a){
		int temp = 0;
		 // 第一层循环表明比较的轮数, 比如 length 个元素,从0 开始，则 到 a.length
		for (int i = 0; i < a.length-1; i++) {
			// 第二层循环，每相邻的两个比较一次，次数随着轮数的增加不断减少，每轮确定一个最大的，不需比较那个最大的
			for (int j = 0; j < a.length-1-i; j++) {
				if(a[j]>a[j+1]){
					temp = a[j];
					a[j] = a[j+1];
					a[j+1] = temp;
				}
			}
		}
		for (int k = 0; k < a.length; k++) {
			System.out.print(a[k]+"\t");
		}
	}
}
