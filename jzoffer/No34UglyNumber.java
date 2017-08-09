package JZoffer;

public class No34UglyNumber {
	public static void main(String[] args){
		int index = 0;
		//System.out.println("第"+index+"个丑数为："+getUglyNumber(index));
		System.out.println("第"+index+"个丑数为："+getUglyNumberSolution2(index));
	}
	public static boolean isUgly(int number){
		while(number%2==0)
			number/=2;
		while(number%3==0)
			number/=3;
		while(number%5==0)
			number/=5;
		if(number == 1)
			return true;
		else
			return false;
	}
	
	public static int getUglyNumber(int index){
		if(index<=0)
			return 0;
		
		int number = 0;
		int uglyFound = 0;
		while(uglyFound < index){
			number++;
			if(isUgly(number))
				uglyFound++;
		}
		return number;
	}
	
	public static int getUglyNumberSolution2(int index){
		if(index<=0)
			return 0;
		int[] uglyNumbers = new int[index];
		uglyNumbers[0] = 1;
		int index_2 = 0, index_3 = 0, index_5 = 0;
		int nextUglyNumber = 1, min = 1;
		
		while(nextUglyNumber<index){
			if(uglyNumbers[index_2]*2<uglyNumbers[index_3]*3)
				min = uglyNumbers[index_2]*2;
			else
				min = uglyNumbers[index_3]*3;
			if(uglyNumbers[index_5]*5<min)
				min = uglyNumbers[index_5]*5;
			
			uglyNumbers[nextUglyNumber] = min;
			
			while(uglyNumbers[index_2]*2<=uglyNumbers[nextUglyNumber])
				index_2++;
			while(uglyNumbers[index_3]*3<=uglyNumbers[nextUglyNumber])
				index_3++;
			while(uglyNumbers[index_5]*5<=uglyNumbers[nextUglyNumber])
				index_5++;
			
			nextUglyNumber++;
		}
		int ugly =  uglyNumbers[nextUglyNumber-1];
		return ugly;
	}

}
