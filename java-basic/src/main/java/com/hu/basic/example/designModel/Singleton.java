package com.hu.basic.designModel;

/**
 *	功能描述：
 *
 * @author 胡剑钊(hujz)
 *      <p>
 *      创建日期：2016年5月20日  时间：下午2:19:53
 *		</p>
 *
 *
 * 		<p>
 *      修改历史：(修改人，修改时间，修改原因/内容)
 *      </p>
 */
public class Singleton {
	
	private static Singleton instance = null;
	
	private Singleton(){}
	
	public static Singleton getInstance(){
		if(instance == null){
			instance = new Singleton();
			return instance;
		}
		return null;
	}
	

}
