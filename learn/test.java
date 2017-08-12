package learn;



class Test2{
	public void method2(){
		System.out.println("HelloWorld2");
	}
}

public class test{
	public void method0(){
		System.out.println("HelloWorld0");
	}
	public static void method1(){
		System.out.println("HelloWorld1");
	}
	
	public static void main(String args[]){			
		new test().method0(); 
		//method0();
		//Cannot make a static reference to the non-static method method0() from the type test
		method1(); 
		new Test2().method2(); 
	}	
}
