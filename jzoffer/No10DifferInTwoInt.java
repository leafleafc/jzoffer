package JZoffer;

public class No10DifferInTwoInt {
	public static void main(String[] args){
		int m=1;
		int n=2;
		System.out.println("��Ҫ�ı�M�е�"+differForTwoInt(m,n)+"λ���ܵõ�N");
		
		byte[] arr = new byte[32];
		
		System.out.println("����"+m+"�Ķ����Ʊ�ʾΪ:");
		arr=No10BitOperation.intToByte32(m);
		for(int i= 0; i<=31;i++){
			System.out.print(arr[i]);
		}
		System.out.println("");
		
		System.out.println("����"+n+"�Ķ����Ʊ�ʾΪ:");
		arr=No10BitOperation.intToByte32(n);
		for(int i= 0; i<=31;i++){
			System.out.print(arr[i]);
		}
		System.out.println("");
	}
	
	public static int differForTwoInt(int m, int n){
		int count = 0;
		int number = m^n;//�������
		while(number!=0){//�����������1�ĸ���
			count++;
			number = number & (number-1);
		}
		return count;
	}

}
