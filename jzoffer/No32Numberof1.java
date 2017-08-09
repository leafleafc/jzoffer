package JZoffer;

public class No32Numberof1 {
	public static void main(String[] args){
		int n = 21235;
		System.out.println(n+"��1���ֵĴ���Ϊ��"+countNumberof1From1toN(n));
		System.out.println(n+"��1���ֵĴ���Ϊ��"+calculateNumberof1From1toN(n));		
	}
	public static int countNumberof1From1toN(int n){//ö���ۼ�
		int number = 0;
		for(int i = 1; i<=n; i++){
			number += numberof1(i); 
		}
		return number;
	}
	public static int numberof1(int n){//�ж�n��ÿһλ�Ƿ�Ϊ1
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
	
	public static int numberof1ByRec(StringBuilder str){//ÿ��ȥ�����λ���ݹ�
		if(str==null||str.length() ==0 || str.charAt(0)<'0'||str.charAt(0)>'9')
			return 0;
		
		int first = str.charAt(0)-'0';
		int length = str.length();
		
//		if(length == 1 && first == 0)
//			return 0;
//		if(length == 1 && first == 1)
//			return 1;
		if(length == 1){//ֻ��һλ��Ϊ0�������㣬���෵��1
			if(first == 0)
				return 0;
			else 
				return 1;
		}
		
		//�ж���λ1�ĸ���
		int numberFirstDigit = 0;
		if(first>1)//��λ����1������λһ�ĸ���Ϊ10������-1���η�
			numberFirstDigit = powerBase(10, length-1);
		else if(first == 1)//��λΪ1
			numberFirstDigit = Integer.parseInt(str.substring(1))+1;
		
		//���λ��0������λ��1�ĸ���
		int numOtherDigits = 0;
		numOtherDigits = first * (length-1) * powerBase(10, length-2);
		//ȥ�����λ��ʣ�µ�λ��1�ĸ���
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
