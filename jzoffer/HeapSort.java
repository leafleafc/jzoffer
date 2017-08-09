package JZoffer;

public class HeapSort {
	public static void main(String[] args) {  
        //int[] array = { 9, 8, 7, 6, 5, 4, 3, 2, 1, 0, -1, -2, -3 };  
        //int[] array = {87,45,78,32,17,65,53,9,122};
        int[] array={49,38,65,97,76,13,27,49,78,34,12,64,5,4,62,99,98,54,56,17,18,23,34,15,35,25,53,51};  

        System.out.println("Before heap:");  
        ArrayUtils.printArray(array);  

        heapSort(array);  

        System.out.println("After heap sort:");  
        ArrayUtils.printArray(array);  
    }
	
	public static void heapSort(int[] array){
		if(array==null||array.length<=1)
			return;
		
		buildMaxHeap(array);
		for(int i =array.length-1; i>=1; i--){
			ArrayUtils.exchangeElements(array, 0, i);//交换堆顶和array[i]
			adjustMaxHeap(array,i,0);//从上到下调整0~i-1构成的大根堆
		}
	}
	
	public static void buildMaxHeap(int[] array) {//构建大根堆
		int half = array.length/2-1;
		for(int i =half; i>=0; i--){//从第一个非叶子结点开始，一直到根节点，依次从上到下调整成大根堆
			adjustMaxHeap(array,array.length,i);
		}
	}
	
	public static void adjustMaxHeap(int[] array, int heapSize, int index) {//从上到下调整大根堆
//		int left = index*2+1;
//		int right = index*2+2;
//		int largest = index;
//		if(left<heapSize&&array[left]>array[index])
//			largest = left;
//		if(right<heapSize&&array[right]>array[largest])
//			largest = right;
//		
//		if(index!=largest){//沿着交换了元素的那一条线继续调整
//			 ArrayUtils.exchangeElements(array, index, largest);
//			 adjustMaxHeap(array, heapSize, largest);  
//		}
		
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
	

}
