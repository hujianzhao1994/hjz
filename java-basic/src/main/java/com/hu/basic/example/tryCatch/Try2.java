package com.hu.basic.tryCatch;

/**
 *	功能描述：
 *
 * @author 胡剑钊(hujz)
 *      <p>
 *      创建日期：2016年5月20日  时间：上午10:16:17
 *		</p>
 *
 *
 * 		<p>
 *      修改历史：(修改人，修改时间，修改原因/内容)
 *      </p>
 */
public class Try2 {

	public static void main(String[] args) {
	    System.out.println(frequenceCheck());
	}
	 
	@SuppressWarnings("finally")
	public static int frequenceCheck() {
	    try{
	        System.out.println("in try block");
	        return 1;
	    }catch(Exception e){
	        System.out.println("in catch block");
	        return 2;
	    }finally{
	        System.out.println("in finally block");
	        return 3;
	    }
	}
}
