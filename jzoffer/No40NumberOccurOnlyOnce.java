package JZoffer;

public class No40NumberOccurOnlyOnce {
	public static void main(String[] args){
		//int[] array = {2,4,3,6,3,2,5,5};
		int[] array = {1,2,4,4};
		No40NumberOccurOnlyOnce nooo = new No40NumberOccurOnlyOnce();
		nooo.findTwoNumbersOccurOnlyOnce(array);
	}
	public void findTwoNumbersOccurOnlyOnce(int[] array){
		if(array == null| array.length<2)
			return;
		
		int resultExclusiveOR = 0;
		for(int i=0; i<=array.length-1; i++){
			resultExclusiveOR ^= array[i];
		}
		int indexof1 = findFirstBitIs1(resultExclusiveOR);
		int number1 =0, number2 =0;
		for(int j=0; j<= array.length-1; j++){
			if(isBit1(array[j], indexof1))
				number1 ^= array[j];
			else
				number2 ^= array[j];
		}
		System.out.println("只出现一次的两个数字为："+number1+","+number2);
	}
	public int findFirstBitIs1(int num){
		int indexBit = 0;
		while((num&1)==0){
			num = num >>1;
		    indexBit++;
		}
		return indexBit;
	}
	public boolean isBit1(int num, int indexBit){
		num = num >> indexBit;
		return ((num&1)==0);
	}

}
