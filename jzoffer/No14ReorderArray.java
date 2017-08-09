package JZoffer;

public class No14ReorderArray {
	public static void main(String[] args){
		int[] array={1,2,3,4,5};
		reoderByOddEven(array);
		for(int i=0;i<=array.length-1;i++)
			System.out.print(array[i]+",");
		
	}
	
	public static void reoderByOddEven(int[] array){
		if(array.length<=0||array==null)
			throw new RuntimeException("Invalid array");
		int i=0, j=array.length-1;
		while(i<j){
			while(i<j&&!isEven(array[i])){
				i++;
			}
			while(i<j&&isEven(array[j])){
				j--;
			}
			if(i<j){
				int temp = array[i];
				array[i] = array[j];
				array[j] = temp;
			}
		}
	}
	
	public static boolean isEven(int n){
		if((n&1)==0) return true;
		else return false;
	}

}
