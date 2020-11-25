package com.hu.basic.extend;

/**
 *	功能描述：  继承环境当中，子类继承父类，并重写method(),当主线程实例化父类时候，调用的是哪个方法？
 *
 * @author 胡剑钊(hujz)
 *      <p>
 *      创建日期：2016年5月13日  时间：上午11:45:00
 *		</p>
 *
 *
 * 		<p>
 *      修改历史：(修改人，修改时间，修改原因/内容)
 *      </p>
 */
public class FatherAndSonSecond {

	public static void main(String[] args) {
		FatherClass f = new FatherClass();
		FatherClass f2 = new SonClass();
		f.method();
		f2.method();
	}

}

class FatherClass{
	
	public void method(){
		System.out.println("Father");
	}
}
//http://code.taobao.org/svn/seWebPrj/trunk

class SonClass extends FatherClass{
	
	@Override
	public void method(){
		System.out.println("Son");
	}
}
