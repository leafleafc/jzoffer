package JZoffer;

public class No10BitOperation {
	
	public static void main(String[] args){
		//������1  0x7FFFFFFF
		//������0x800000000    0XFFFFFFFF
		//0
		int number1=-16;
		System.out.println("����"+number1+"�Ķ�������1�ĸ���Ϊ:"+oneInNumber(number1));
		System.out.println("����"+number1+"�Ķ�������1�ĸ���Ϊ:"+oneInNumberTwo(number1));
		byte[] arr = new byte[32];
		System.out.println("����"+number1+"�Ķ����Ʊ�ʾΪ:");
		arr=intToByte32(number1);
		for(int i= 0; i<=31;i++){
			System.out.print(arr[i]);
		}
		System.out.println("");
		//Java�е�int����������4�ֽ�32λ���
		int number2=-11;
		System.out.println("����-11�Ķ�������1�ĸ���Ϊ:"+oneInNumber(number2));
		System.out.println("����-11�Ķ����Ʊ�ʾΪ:");
		arr=intToByte32(number2);
		for(int i= 0; i<=31;i++){
			System.out.print(arr[i]);
		}
		System.out.println("");
	}
	
	public static int oneInNumber(int number){//n=n&(n-1) ���n�Ķ����Ʊ�ʾ�У����ұ�һ��1��Ϊ0
		int count = 0;
		while(number!=0){
			count++;
			number = number & (number-1);
		}
		return count;
	}
	
	public static int oneInNumberTwo(int number){//ѭ��32��
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
	
	public static byte[] intToByte32(int num){//intת������
		byte[] arr = new byte[32];
		for(int i =31;i>=0;i--){
			arr[i] = (byte) (num&1);
			num = num >> 1;
		}
		return arr;
	}

}
