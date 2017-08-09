package JZoffer;

public class No33PrintMinNumber {
	public static void main(String[] args){
		//int[] array = {3,32,321};
		//int[] array = null;
		//int[] array = {};
		int[] array = {9,32,0,41,5,14,13};
		printMinNumber(array);
	}
	public static void printMinNumber(int[] array){
		if(array == null||array.length <=1)
			return;
		qSort(array, 0, array.length-1);
		
		for(int i = 0; i<=array.length-1; i++){
			System.out.print(array[i]);
		}
		System.out.println();
	}
	public static void qSort(int[] array, int start, int end){
		int index = start;
		index = partition(array, start, end);
		
		if(index>start)
			qSort(array, start, index-1);
		if(index<end)
			qSort(array, index+1, end);
	}
	
	public static int partition(int[] array, int start, int end){
		int key = array[start];
		int i = start, j= end;
		while(i<j){
			while(isSmall(String.valueOf(key), String.valueOf(array[j])) && i<j)
				j--;
			array[i]=array[j];
			while(!isSmall(String.valueOf(key), String.valueOf(array[i])) && i<j)
				i++;
			array[j]=array[i];
		}
		array[i]=key;
		return i;
	}
	public static boolean isSmall(String m, String n){
		String left = m+n;
		String right = n+m;

		for(int i=0; i<=left.length()-1; i++){
			if(left.charAt(i)<right.charAt(i))
				return true;
			else if(left.charAt(i)>right.charAt(i))
					return false;	
		}
		return false;
	}

}
