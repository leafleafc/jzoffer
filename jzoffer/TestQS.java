package JZoffer;

import java.util.Random;

public class TestQS {
	public static void quickSort(int[] data, int start, int end){
		if(start==end)
			return;
		int index = partitionB(data, start, end);
		if(index>start)
			quickSort(data, start, index-1);
		if(index<end)
			quickSort(data, index+1, end);
	}
	
	public static int partition(int[] data, int start, int end){
		if(data==null||data.length<=0||start<0||end>data.length)
			throw new RuntimeException("Invalid Parameters.");
		
		Random rand = new Random();
		int index = rand.nextInt(end-start+1)+start;
		int tmp = data[index];
		data[index] = data[end];
		data[end] = tmp;
		int small = start-1;
		
		for(index=start; index<end; index++){
			if(data[index]<data[end]){
				small++;
				if(small!=index){
					tmp = data[small];
					data[small] = data[index];
					data[index] = tmp;
				}
			}
		}
		small++;
		tmp = data[small];
		data[small] = data[end];
		data[end] = tmp;
		return small;
	}
	
	public static int partitionB(int[] data, int start, int end){
		if(data==null||data.length<=0||start<0||end>data.length)
			throw new RuntimeException("Invalid Parameters.");
		
		int i=start, j=end;
		int key = data[start];
		
		while(i<j){
			while(data[j]>key&&i<j)
				j--;
			data[i]=data[j];
			while(data[i]<=key&&i<j)
				i++;
			data[j]=data[i];
		}
		data[i]= key;
		return i;
	}
	
	public static void main(String[] args){
		int[] data = {10,12,4,7,5,-1,0,5,7,9,13};
		quickSort(data, 0, data.length-1);
		for(int i=0;i<=data.length-1;i++)
			System.out.print(data[i]+" ");
	}
}
