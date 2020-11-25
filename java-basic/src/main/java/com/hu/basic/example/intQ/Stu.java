package com.hu.basic.intQ;

/**
 * @Description:比较一个对象中的Integer属性 比较大小  
 * @author hujz
 * @date 2018年3月2日 下午3:38:41
 */

public class Stu {

	private Integer age;

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}

	public static void main(String[] args) {
		Stu stu = new Stu();
		stu.setAge(999);
		Stu stu1 = new Stu();
		stu1.setAge(1000);
		
		System.out.println(stu==stu1);
		System.out.println("stu.getAge()==stu1.getAge()-1->"+(stu.getAge()==stu1.getAge()-1));
		System.out.println("stu.getAge().equals(stu1.getAge()-1)->"+stu.getAge().equals(stu1.getAge()-1));
		
		Integer aa = stu1.getAge()-1;
		System.out.println("stu.getAge()==aa->"+(stu.getAge()==aa));
		
		Integer a = 1000;
		Integer b = 1000;
		System.out.println(a==b);
		System.out.println(a.equals(b));
	}
}


