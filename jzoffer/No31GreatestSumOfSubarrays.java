package JZoffer;

public class No31GreatestSumOfSubarrays {
	
	public static void main(String[] args){
		//int[] array = {1,-2,3,10,-4,7,2,-5};//�����и� 18
		//int[] array = {1,2,3,10,4,7,2,5};//ȫ������ 34
		int[] array = {-1,-2,-3,-10,-4,-7,-2,-5};//ȫ�Ǹ��� -1
		//array = null;//�����ָ��Ϊ��
		Integer result = getMaxSumofSubarrays(array);
		if(result!=null)
			System.out.print("���������������������������Ϊ��"+result);
		else
			System.out.print("Wrong Parameters!");
	}
	public static boolean judgeValidArray(int[] array){
		if(array==null||array.length==0)
			return false;
		else
			return true;
	}
	public static Integer getMaxSumofSubarrays(int[] array){
		if(judgeValidArray(array)==false)
			return null;
		//throw new RuntimeException("Wrong Parameters!");
		
		int cur_Sum = 0;
		int nGreatest_Sum = 0x80000000;
		for(int i=0; i<=array.length-1; i++){
			if(cur_Sum<=0)
				cur_Sum = array[i];
			else
				cur_Sum += array[i];
			
			if(cur_Sum>nGreatest_Sum)
				nGreatest_Sum = cur_Sum;
		}
		return nGreatest_Sum;
	}

}
