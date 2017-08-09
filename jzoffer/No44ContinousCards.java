package JZoffer;

public class No44ContinousCards {
	public static void main(String[] args){
		//int[] numbers ={10,10,0,13,14};
		//int[] numbers ={10,11,12,13,14};
		//int[] numbers ={0,9,0,7,0};
		//int[] numbers =null;
		//int[] numbers ={7,6,5,9,11};
		int[] numbers ={7,6,5,4,3,2,1};
		No44ContinousCards cc =new No44ContinousCards();
		System.out.println(cc.isContinuous(numbers));
	}
	public boolean isContinuous(int[] numbers){
		if(numbers== null||numbers.length==0)
			return false;
		int zeroCount =0;
		for(int i=numbers.length-1; i>=1; i--){
			for(int j = 0;j<= i-1; j++){
				if(numbers[j]>numbers[j+1]){
					int tmp = numbers[j];
					numbers[j] = numbers[j+1];
					numbers[j+1] = tmp;
				}
			}
		}
		for(int i =0; i<=numbers.length-1; i++){
			if(numbers[i]==0)
				zeroCount++;
		}
		
		int small = zeroCount;
		int big = small+1;
		int numberOfGap =0;
		while(big<=numbers.length-1){
			if(numbers[small]==numbers[big])
				return false;
			numberOfGap += numbers[big]-numbers[small]-1;
			small++;
			big++;
		}
		if(numberOfGap<=zeroCount)
			return true;
		else
			return false;
	}
}
