package JZoffer;

public class No12PrintFromOneToMaxNRec {
	
	public static void main(String[] args){
		char[] number = new char[4];//javaĬ�ϳ�ʼ��Ϊ'\0'��'\u0000'
		for(int i=0;i<=3;i++)
		    number[i] = '0';
		for(int i=0;i<=9;i++){
			number[0] = (char)(i+'0');
			printFromOneToMaxNRecursively(number, 0);
		}
	}
	
	public static void printFromOneToMaxNRecursively(char[] number, int index){
		if(index==(number.length-1)){
			printN(number);
			return;
		}
		for(int i=0;i<=9;i++){
			number[index+1] = (char)(i+'0');
			printFromOneToMaxNRecursively(number, index+1);
		}
	}
	
	public static void printN(char[] number){
		boolean isBeginningZero = true;
		int i =0;
		for(i=0;i<=number.length-1;i++){
			if(isBeginningZero&&number[i]!='0'){//�ҵ���һ������λ��
				isBeginningZero = false;
			}
			if(!isBeginningZero)//���������Ԫ�ؿ�ʼ���δ�ӡ
				System.out.print(number[i]);
		}
		if(!isBeginningZero)
		    System.out.println();
	} 

}
