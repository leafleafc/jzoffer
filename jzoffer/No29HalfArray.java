package JZoffer;

public class No29HalfArray {
	public static void numOcurrOverHalf(int[] array){
		if(array==null||array.length==0){
			System.out.println("Wrong Parameters");
			return;
		}
		int num = numOverHalf(array);
		if(!moreThanHalf(array,num))
			System.out.println("û�г��ִ������������������ǣ�");
		else
			System.out.println("���ִ������������������ǣ�"+num);
	}
	public static int numOverHalf(int[] array){
		int num = array[0];
		int times = 1;
		
		for(int i=1; i<array.length; i++){
			if(times == 0){
				num = array[i];
				times = 1;
			}
			//else if(array[i]!=array[i-1])//������Ϊһ��times=0�������¿�ʼ����,���õ�ǰԪ��Ϊnum��Ȼ��ͽ�����һ��ѭ��������˵��ǰԪ�غ�ǰһԪ�رȽ��뵱ǰԪ����num�Ƚ���һ����
			else if(array[i]!=num)
				times--;
			else
				times++;			
//			System.out.println("num:"+num);
//			System.out.println("times:"+times);
		}
		return num;
	}
	public static boolean moreThanHalf(int[] array, int num){
		if(array==null||array.length==0)
			return false;
		
		int times = 0;
		for(int i= 0;i<=array.length-1; i++){
			if(array[i] == num)
				times++;
		}
		if(times*2>array.length)
			return true;
		else 
			return false;
	}
	
	public static void main(String[] args){
		int[] array = {1,2,3,2,2,2,5,4,2};
		//int[] array = {1,2,1,2,0,4,1,1,1};
		//int[] array = null;
		numOcurrOverHalf(array);
	}

}
