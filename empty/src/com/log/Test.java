package com.log;

public class Test {

	public void f(String[] b){
		 String [] a={"a","b","c"};
		 System.out.println(a.hashCode());
		 System.out.println(b.hashCode());
		 
	}
	public static void main(String arg []){
		String[] b={"a","b","c"};
		Test t =new  Test();
		t.f(b);
	}
	
	 
}
