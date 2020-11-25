package com.hu.basic.mathSort;
/**
 * 
 * 功能描述：选择排序		每一次从待排序的数据元素中选出最小（或最大）的一个元素，存放在序列的起始位置，直到全部待排序的数据元素排完。
 * 			和每个元素进行对比，每次把最小的数字选到最前面
 *     
 * @Author   hjz（创建）
 *      创建日期：2017年3月18日 下午3:27:11
 */
public class ChoiceSort {

	public static void main(String[] args) {
		int [] arr = {22,1,3,11,5,2,4};
		choiceSorted(arr);
	}
	public static int[] choiceSorted(int [] arr) {
		//比较的元素，从0开始，arr.length结束
		for (int i = 0; i < arr.length; i++) {
			//根据i能够获得最前面的索引，依次进行比较
			for (int j = i; j < arr.length; j++) {
				int temp = 0;
				if(arr[i]>arr[j]){
					temp = arr[j];
					arr[j] = arr[i];
					arr[i] = temp ; 
				}
			}
		}
		for (int i : arr) {
			System.out.print(i+" ");
		}
		return arr;
	}
}
