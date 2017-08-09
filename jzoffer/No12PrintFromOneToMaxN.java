package JZoffer;

public class No12PrintFromOneToMaxN {
	
	public static void main(String[] args){
		int[] number = new int[4];//javaĬ�ϳ�ʼ��Ϊ0
//		for(int i=0;i<=3;i++)
//			System.out.print(number[i]+",");
		while(!increment(number)){
			printN(number);
		}
	}
	
	public static void printN(int[] number){
		boolean isBeginningZero = true;
		for(int i=0;i<=number.length-1;i++){
			if(isBeginningZero&&number[i]!=0){//�ҵ���һ������λ��
				isBeginningZero = false;
			}
			if(!isBeginningZero)//���������Ԫ�ؿ�ʼ���δ�ӡ
				System.out.print(number[i]);
		}
		System.out.println();
	} 
	
	public static boolean increment(int[] number){
		boolean isOverFlow=false;//���λ�Ƿ��н�λ
		int carry=0;//�����Ƿ��н�λ
		if(number.length<=0)
			throw new RuntimeException("Invalid array");
		for(int i=number.length-1; i>=0; i--){
			int sum=number[i]+carry;//���μӷ�֮ǰ�ȼӽ�λ
			if(i==number.length-1)//���һλ��һ
				sum++;
			
			if(sum==10){//������λ
				if(i==0)//���λ������λ
					isOverFlow=true;
				else{//����λ������λ
					carry=1;
					sum=0;
					number[i]=sum;
				}
			}
			else{//û�н�λ������forѭ��
				number[i]=sum;
				break;
			}
				
		}
		return isOverFlow;
	}
}
