package learn;


public class TestThis {
	public static void main(String[] args){
		//new TestThis().method1();
		int x=4;
		x*= x+1;
		System.out.println(x);
	}
	
//	public void method1(){
//		method2();                          
//		this.method2();
//	}
//
//    public void method2(){
//		System.out.println("I'm method2");
//		TestClass2.method3();
//	}
}

class TestClass2{
	public static void method3(){
		System.out.println("I'm method3");
	}
}




 