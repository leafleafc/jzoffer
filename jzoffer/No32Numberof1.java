package JZoffer;

public class No32Numberof1 {
	public static void main(String[] args){
		int n = 21235;
		System.out.println(n+"中1出现的次数为："+countNumberof1From1toN(n));
		System.out.println(n+"中1出现的次数为："+calculateNumberof1From1toN(n));		
	}
	public static int countNumberof1From1toN(int n){//枚举累加
		int number = 0;
		for(int i = 1; i<=n; i++){
			number += numberof1(i); 
		}
		return number;
	}
	public static int numberof1(int n){//判断n的每一位是否为1
		int number = 0;
		while(n!=0){
			if(n%10 == 1)
				number++;
			n= n/10;
		}
		return number;
	}
	
	public static int calculateNumberof1From1toN(Integer n){//
		if(n<=0)
			return 0;
		
		StringBuilder str = new StringBuilder(n.toString());
		return numberof1ByRec(str);
	}
	
	public static int numberof1ByRec(StringBuilder str){//每次去掉最高位做递归
		if(str==null||str.length() ==0 || str.charAt(0)<'0'||str.charAt(0)>'9')
			return 0;
		
		int first = str.charAt(0)-'0';
		int length = str.length();
		
//		if(length == 1 && first == 0)
//			return 0;
//		if(length == 1 && first == 1)
//			return 1;
		if(length == 1){//只有一位，为0，返回零，其余返回1
			if(first == 0)
				return 0;
			else 
				return 1;
		}
		
		//判断首位1的个数
		int numberFirstDigit = 0;
		if(first>1)//首位大于1，则首位一的个数为10（长度-1）次方
			numberFirstDigit = powerBase(10, length-1);
		else if(first == 1)//首位为1
			numberFirstDigit = Integer.parseInt(str.substring(1))+1;
		
		//最高位非0，其他位上1的个数
		int numOtherDigits = 0;
		numOtherDigits = first * (length-1) * powerBase(10, length-2);
		//去掉最高位，剩下的位上1的个数
		int numRecursive = numberof1ByRec(str.deleteCharAt(0));
		
		return numberFirstDigit+numOtherDigits+numRecursive;
	}
	
	public static int powerBase(int base, int n){
		int result = 1;
		for(int i=0;i<=n-1;i++){
			result*=base;
		}
		return result;
	}
}
