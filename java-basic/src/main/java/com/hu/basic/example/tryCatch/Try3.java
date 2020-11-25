package com.hu.basic.tryCatch;

/**
 *	功能描述：
 *
 * @author 胡剑钊(hujz)
 *      <p>
 *      创建日期：2016年5月20日  时间：上午10:32:26
 *		</p>
 *
 *
 * 		<p>
 *      修改历史：(修改人，修改时间，修改原因/内容)
 *      </p>
 */
public class Try3 {
	
	
	public static void main(String[] args) {
		System.out.println(returnWhat());
	}
	
	public static int returnWhat(){
		try{
			return 1;
		}finally{
			return 2;
		}
	}

}


