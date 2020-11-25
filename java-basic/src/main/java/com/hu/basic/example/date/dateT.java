package com.hu.basic.date;

import java.util.Calendar;

/**
 *	功能描述：
 *
 * @author 胡剑钊(hujz)
 *      <p>
 *      创建日期：2016年5月20日  时间：下午2:12:42
 *		</p>
 *
 *
 * 		<p>
 *      修改历史：(修改人，修改时间，修改原因/内容)
 *      </p>
 */
public class dateT {

	
	public static void main(String[] args) {

		Calendar c = Calendar.getInstance();
		c.add(Calendar.DATE, -1);
		System.out.println(c.getTime());
	}
}
