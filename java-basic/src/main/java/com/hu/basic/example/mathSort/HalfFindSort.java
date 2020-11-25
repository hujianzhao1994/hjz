package com.hu.basic.mathSort;

/**
 * 
 * 功能描述：二分法查找   查找对应的数值所在的索引值，不存在的数值，返回-1
 * 
 * @Author hjz（创建） 创建日期：2017年3月18日 下午12:28:28
 */

public class HalfFindSort {

	public static void main(String[] args) {
		int[] arr = { 1, 4, 6, 8, 12, 24 };
		int numValue = 18;
		int index = find(arr, numValue);
		System.out.println(index);
	}

	public static int find(int[] arr, int numValue) {
		int min = 0;
		int max = arr.length - 1;
		int index = -1;
		while (min <= max) {  //通过while循环比较索引大小
			int mid = (min + max) / 2;
			if (arr[mid] == numValue) {   //通过比对该索引位置上的值 ，决定索引的变化
				index = mid;
				break;
			} else if (arr[mid] > numValue) {  //通过比对该索引位置上的值 ，决定索引的变化
				max = mid - 1;
			} else if (arr[mid] < numValue) {   //通过比对该索引位置上的值 ，决定索引的变化
				min = mid + 1;
			}
		}
		return index;
	}
}
