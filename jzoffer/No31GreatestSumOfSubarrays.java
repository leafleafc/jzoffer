package JZoffer;

public class No31GreatestSumOfSubarrays {
	
	public static void main(String[] args){
		//int[] array = {1,-2,3,10,-4,7,2,-5};//有正有负 18
		//int[] array = {1,2,3,10,4,7,2,5};//全是正数 34
		int[] array = {-1,-2,-3,-10,-4,-7,-2,-5};//全是负数 -1
		//array = null;//数组的指针为空
		Integer result = getMaxSumofSubarrays(array);
		if(result!=null)
			System.out.print("该数组的连续子数组的最大字数和为："+result);
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
