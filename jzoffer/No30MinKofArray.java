package JZoffer;

public class No30MinKofArray {
	public static void main(String[] args){
		//int[] array = {4,5,1,6,2,7,3,8};//无重复数字
		//int[] array = {4,5,1,6,2,7,5,3,7,8};//有重复数字
		int[] array = {4,5,1,6};//k=4, 输入的k=数组长度
		getLeastNumbers(array,2);
		System.out.println();
		getLeastNumbersByHeap(array,2);
	}
	public static void getLeastNumbersByHeap(int[] input, int k){
		if(input == null||input.length == 0)//输入的数组非法的情况
			return;
		
		if(k<1||k>input.length)//要处理k非法输入的情况
			return;
		
		int[] kHeap = new int[k];
		for(int i = 0 ; i<=input.length-1;i++){
			if(i<k)
				kHeap[i] = input[i];
			if(i==k-1){
				buildMaxHeap(kHeap);
			}
			
			if(i>=k){
				if(input[i]<kHeap[0]){
					kHeap[0] = input[i];
					adjustMaxHeap(kHeap, k, 0);
				}
			}
		}
		for(int i=0;i<=k-1;i++){
			System.out.print(kHeap[i]+" ");
		}
	}
	
	public static void buildMaxHeap(int[] array) {//构建大根堆
		int half = array.length/2-1;
		for(int i =half; i>=0; i--){//从第一个非叶子结点开始，一直到根节点，依次从上到下调整成大根堆
			adjustMaxHeap(array,array.length,i);
		}
	}
	
	public static void adjustMaxHeap(int[] array, int heapSize, int index) {//从上到下调整大根堆	
		int left = index*2+1;
		int right = index*2+2;
		int largest = index;
		while(left<heapSize){
			if(left<heapSize&&array[left]>array[index])
				largest = left;
			if(right<heapSize&&array[right]>array[largest])
				largest = right;
		
			if(index!=largest){//沿着交换了元素的那一条线继续调整
				ArrayUtils.exchangeElements(array, index, largest);
				index = largest;
				left = index*2+1;
				right = index*2+2;
			}
			else
				break;
		}
	}
	
	public static void getLeastNumbers(int[] input, int k){
		if(input == null||input.length == 0)
			return;
		
		if(k<1||k>input.length)
			return;
		
		int start = 0, end = input.length-1;
		int index = partition(input, start, end);
		while(index!=k-1){
			if(index<k-1){
				start = index+1;
				index = partition(input, start,end);
			}
			else{
				end = index-1;
				index = partition(input, start, end);
			}
		}
		for(int i=0;i<=k-1;i++){
			System.out.print(input[i]+" ");
		}
//		System.out.println();
//		for(int i=0;i<=input.length-1;i++){
//			System.out.print(input[i]+" ");
//		}
	}
	
	public static int partition(int[] input, int start, int end){
		if(start>end||start>input.length-1||end<0){
			throw new RuntimeException("Wrong Parameters!");
		}
		int index = start;
		int i=start, j=end;
		int key = input[start];
		while(i<j){
			while(input[j]>key&&i<j)
				j--;
			input[i] = input[j];
			while(input[i]<=key&&i<j)
				i++;
			input[j] = input[i];
		}
		input[i] = key;
		return i;
	} 

}
