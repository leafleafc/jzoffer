package JZoffer;

public class No9Fibonacci {
	public static void main(String[] args){
		System.out.println(fibonacciRec(10));
		System.out.println(fibonacci(500));
	}
	
	public static int fibonacciRec(int n){
		if(n==0)
			return 0;
		if(n==1)
			return 1;
		return fibonacciRec(n-1)+fibonacciRec(n-2);
	}
	
	public static int fibonacci(int n){
		if(n==0)
			return 0;
		if(n==1)
			return 1;
		int fibNMinusOne=1;
		int fibNMinusTwo=0;
		int fibN=0;
		for(int i=2;i<=n;i++){//´Ó2¿ªÊ¼
			fibN=fibNMinusOne+fibNMinusTwo;
			fibNMinusTwo = fibNMinusOne;
			fibNMinusOne = fibN;
		}
		return fibN;
	}

}
