package JZoffer;

public class No38NumberOfKInArray {
	public static void main(String[] args){
		int[] array ={1,2,3,3,3,3,4,5};
		int k=3;
		No38NumberOfKInArray na = new No38NumberOfKInArray();
		int times = na.getTimes(array, k);
		if(times ==-1){
			System.out.println("数组为空");
		}
		else 
			System.out.println(k+"在数组中出现了"+times+"次");
	}
	
	public int getFirstK(int[] array, int k, int start, int end){
		if(start<0||end>array.length||start>end)
			return -1;
		
		int middle = (start+end)/2;
		int middleValue = array[middle];
		
		if(k==middleValue){
			if((middle>0&&array[middle-1]!=k)||middle == 0)
				return middle;
			else
				end = middle-1;
		}
		else if(k<middleValue)
			end = middle-1;
		else
			start = middle+1;
		
		return getFirstK(array, k, start, end);
	}
	
	public int getLastK(int[] array, int k, int start, int end){
		if(start<0||end>array.length||start>end)
			return -1;
		
		int middle = (start+end)/2;
		int middleValue = array[middle];
		
		if(k==middleValue){
			if((middle<array.length-1&&array[middle+1]!=k)||middle == array.length)
				return middle;
			else
				start = middle+1;;
		}
		else if(k<middleValue)
			end = middle-1;
		else
			start = middle+1;
		
		return getLastK(array, k, start, end);
	}
	public int getTimes(int[] array, int k){
		if(array == null)
			return -1;
		
		int start = getFirstK(array, k, 0, array.length-1);
		int end = getLastK(array, k, 0, array.length-1);
		System.out.println(start);
		System.out.println(end);
		int times = 0;
		if(start>-1&&end>-1)
			times = end-start +1;
		return times;
	}

}
