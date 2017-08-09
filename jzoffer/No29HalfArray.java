package JZoffer;

public class No29HalfArray {
	public static void numOcurrOverHalf(int[] array){
		if(array==null||array.length==0){
			System.out.println("Wrong Parameters");
			return;
		}
		int num = numOverHalf(array);
		if(!moreThanHalf(array,num))
			System.out.println("没有出现次数超过半数的数字是：");
		else
			System.out.println("出现次数超过半数的数字是："+num);
	}
	public static int numOverHalf(int[] array){
		int num = array[0];
		int times = 1;
		
		for(int i=1; i<array.length; i++){
			if(times == 0){
				num = array[i];
				times = 1;
			}
			//else if(array[i]!=array[i-1])//这里因为一旦times=0，就重新开始计数,设置当前元素为num，然后就进入下一次循环，所以说当前元素和前一元素比较与当前元素与num比较是一样的
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
