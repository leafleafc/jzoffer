package learn;

/*一个整数数列，元素取值可能是0~65535中的任意一个数，相同数值不会重复出现；0是例外，可以反复出现。
请设计一个算法，当你从该数列中随意选取5个数值，判断这5个数值是否连续相邻
注意：
5个数值允许是乱序的。比如： 8 7 5 0 6
0可以通配任意数值。比如：8 7 5 0 6 中的0可以通配成9或者4
0可以多次出现。
复杂度如果是O(n2)则不得分。

解题思路：
1.取5个数中非0的最大数和最小数，之差不大于4则连续，否则不连续。 
2.要增加两个特例： 1）全0 算连续，2）只有一个非0算连续
*/

public class SuccessiveArray {
	public static void main(String[] args){
		//int[] array = {0,0,0,0,0};
		//int[] array = {0,0,0,0,100};
		//int[] array = {1,5,4,3,2};
		int[] array = {0,0, 1,2,5};
		System.out.println(judgeSuccessive(array));
	}
	
	public static boolean judgeSuccessive(int[] array){
		if(array==null||array.length!=5)
			return false;
		
		int min = array[0], max = array[0];
		int zeroCount = 0;  
		for(int i = 0; i<=array.length-1; i++){
			if(array[i] == 0)
				zeroCount++;
			if((array[i]<min&&array[i]!=0)||min==0&&array[i]>0)
				min = array[i];
			if(array[i]>max)
				max = array[i];
		}
		if(zeroCount>=4){
			return true;
		}
		else{
			if(max-min<=4)
				return true;
			else
				return false;
		}
	}

}
