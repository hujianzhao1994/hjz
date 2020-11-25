package com.hu.basic.exception;

/**
 *	功能描述：
 *
 * @author 胡剑钊(hujz)
 *      <p>
 *      创建日期：2016年5月18日  时间：下午5:04:26
 *		</p>
 *
 *
 * 		<p>
 *      修改历史：(修改人，修改时间，修改原因/内容)
 *      </p>
 */
public class E2 {
	  static void pop() throws NegativeArraySizeException {  
	        // 定义方法并抛出NegativeArraySizeException异常  
	        int[] arr = new int[-3]; // 创建数组  
	    }  
	  
	    public static void main(String[] args) { // 主方法  
	        try { // try语句处理异常信息  
	            pop(); // 调用pop()方法  
	        }catch(IndexOutOfBoundsException e){
	        	System.out.println("index out of exception");
//	        }catch (NegativeArraySizeException e) {  
//	            System.out.println("pop()方法抛出的异常");// 输出异常信息  
	        }  finally{
	        	System.out.println("always invoke");
	        }
	    }  

}
