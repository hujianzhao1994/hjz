package com.hu.basic.exception;

public class ExceptionT4 {
		
	
	public static void main(String[] args) {

		try{
			throw new ExceptionB("b");
		}catch(ExceptionA e1){
			System.out.println("ExceptionA");  
		}catch(Exception e){
			System.out.println("Exception");  
		}finally{
			
		}
	}
}


	class ExceptionA extends Exception{
		
	}
	
	class ExceptionB extends ExceptionA{
		private String a ;
		public ExceptionB(String a){
			this.a = a;
		}
		public String getA() {
			return a;
		}
		public void setA(String a) {
			this.a = a;
		}
	}
	
