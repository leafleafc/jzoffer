package JZoffer;

public class No10BitOperation {
	
	public static void main(String[] args){
		//正数：1  0x7FFFFFFF
		//负数：0x800000000    0XFFFFFFFF
		//0
		int number1=-16;
		System.out.println("整数"+number1+"的二进制中1的个数为:"+oneInNumber(number1));
		System.out.println("整数"+number1+"的二进制中1的个数为:"+oneInNumberTwo(number1));
		byte[] arr = new byte[32];
		System.out.println("整数"+number1+"的二进制表示为:");
		arr=intToByte32(number1);
		for(int i= 0; i<=31;i++){
			System.out.print(arr[i]);
		}
		System.out.println("");
		//Java中的int类型整数由4字节32位组成
		int number2=-11;
		System.out.println("整数-11的二进制中1的个数为:"+oneInNumber(number2));
		System.out.println("整数-11的二进制表示为:");
		arr=intToByte32(number2);
		for(int i= 0; i<=31;i++){
			System.out.print(arr[i]);
		}
		System.out.println("");
	}
	
	public static int oneInNumber(int number){//n=n&(n-1) 会把n的二进制表示中，左右边一个1变为0
		int count = 0;
		while(number!=0){
			count++;
			number = number & (number-1);
		}
		return count;
	}
	
	public static int oneInNumberTwo(int number){//循环32次
		int count = 0;
		int flag = 1;
		while(flag!=0){
			if((number&flag)!=0){
				count++;
			}
			flag = flag<<1;
		}
		return count;
	}
	
	public static byte[] intToByte32(int num){//int转二进制
		byte[] arr = new byte[32];
		for(int i =31;i>=0;i--){
			arr[i] = (byte) (num&1);
			num = num >> 1;
		}
		return arr;
	}

}
