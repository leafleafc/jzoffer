package JZoffer;

public class No10DifferInTwoInt {
	public static void main(String[] args){
		int m=1;
		int n=2;
		System.out.println("需要改变M中的"+differForTwoInt(m,n)+"位才能得到N");
		
		byte[] arr = new byte[32];
		
		System.out.println("整数"+m+"的二进制表示为:");
		arr=No10BitOperation.intToByte32(m);
		for(int i= 0; i<=31;i++){
			System.out.print(arr[i]);
		}
		System.out.println("");
		
		System.out.println("整数"+n+"的二进制表示为:");
		arr=No10BitOperation.intToByte32(n);
		for(int i= 0; i<=31;i++){
			System.out.print(arr[i]);
		}
		System.out.println("");
	}
	
	public static int differForTwoInt(int m, int n){
		int count = 0;
		int number = m^n;//先求异或
		while(number!=0){//计算异或结果中1的个数
			count++;
			number = number & (number-1);
		}
		return count;
	}

}
