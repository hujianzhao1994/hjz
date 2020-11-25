package com.hu.basic.tryCatch;

/**
 *	功能描述：  finally 块是在try块中的return语句前还是后
 *
 *结果： finally 块在try块中的return 块前
 */
public class Try1 {
	public static void main(String[] args) {   
		System.out.println(test());   
	}   

	public static int test() {   
		int b = 0;   
		try {   
			b = 4 + 2;
			return b ; // #1   
		} finally {   
			System.out.println(b); // #2   
		}   
	}   
}
