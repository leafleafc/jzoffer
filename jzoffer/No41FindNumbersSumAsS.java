package JZoffer;

public class No41FindNumbersSumAsS {
	public static void main(String[] args){
		int[] array ={1,2,4,7,11,15};
		int sum =20;
		int[] numbers = new int[2];
		No41FindNumbersSumAsS fns = new No41FindNumbersSumAsS();
		if(fns.findNumbersSumAsS(array, sum, numbers)==true)
			System.out.println("��Ϊ"+sum+"����������Ϊ��"+numbers[0]+","+numbers[1]);
		else
			System.out.println("�����ں�Ϊ"+sum+"����������");
	}
	public boolean findNumbersSumAsS(int[] data, int sum, int[] numbers){
		int head = 0;
		int tail = data.length-1;
		 while(head<tail){
			 int curSum = data[head]+data[tail];
			 if(curSum==sum){
				 numbers[0] = data[head];
				 numbers[1] = data[tail];
				 return true;
			 }else if(curSum>sum)
				 tail--;
			 else
				 head++;
		 }
		 return false;
	}

}
