package JZoffer;


public class No36InversePairInArray {
	public int inversePairs(int[] array){
		if(array == null||array.length<=1)
			return 0;
		
		int[] copy = new int[array.length];
		for(int i =0;i<=copy.length-1;i++){
			copy[i] = 0;
		}
		int count = inversePairsCore(array, copy, 0, array.length-1);
		return count;
	}
	
	public int inversePairsCore(int[] array, int[] copy, int start, int end){
		if(start==end){
			copy[start] = array[start];
			return 0;
		}
		int length = (end-start)/2;
		int left = inversePairsCore(array, copy, start, start+length);
		int right = inversePairsCore(array, copy, start+length+1, end);
		int i = start + length;
		int j = end;
		int copyIndex = end;
		int count =0;
		
		while(i>=start&&j>=start+length+1){
			if(array[i]>array[j]){
				copy[copyIndex]=array[i];
				copyIndex--;
				i--;
				count = count+j-(start+length);
			}
			else{
				copy[copyIndex]=array[j];
				copyIndex--;
				j--;
			}
		}
		while(i>=start){
			copy[copyIndex]=array[i];
			copyIndex--;
			i--;
		}
		while(j>=start+length+1){
			copy[copyIndex]=array[j];
			copyIndex--;
			j--;
		}
		for(i =start; i<=end; i++){
			array[i] = copy[i];
		}
		return count+left+right;
	}
	public static void main(String[] args){
		//int[] array = {7,5,6,4};
		//int[] array = {2,3,4,5,6};
		//int[] array = {1,10,3,8,6,5,4,7,2,9};
		int[] array = {1,4,1,3,6,3,5,2,7};
		No36InversePairInArray inPair = new No36InversePairInArray();
		System.out.println("数组中逆序对的个数为："+inPair.inversePairs(array));
	}

}
