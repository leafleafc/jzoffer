package JZoffer;

import java.util.Random;
//http://blog.csdn.net/VIP_WangSai/article/details/70214053
//快排优化
public class JZQuickSort {
	
	public static void QuickSort(int[] data, int start, int end){
		if(start == end)
			return;
		
		int index = PartitionB(data, start, end);
		
		if(index>start)// index == end 只有比枢轴小的 
			QuickSort(data, start, index-1);
		if(index<end)//index == start 只有比枢轴大的
			QuickSort(data, index+1, end);
	}
	
	public static int Partition(int[] data, int start, int end){
		if(data == null||data.length<=0||start<0||end>=data.length)
			throw new RuntimeException("Invalid Parameters.");
		
		Random rand = new Random();
		int index = rand.nextInt(end-start+1)+start;
		int tmp=0;
		tmp=data[index];
		data[index]=data[end];
		data[end]=tmp;
//		int tmp=0;
//		int index=0;
		int small =start-1;
		
		for(index=start;index<end;index++){
			if(data[index]<data[end]){
				small++;
				if(small!=index){
					tmp=data[index];
					data[index]=data[small];
					data[small]=tmp;
				}
			}
		}
		small++;
		tmp=data[end];
		data[end]=data[small];
		data[small]=tmp;
		
		return small;
	}
	
	public static int PartitionB(int[] data, int start, int end){
		if(data == null||data.length<=0||start<0||end>=data.length)
			throw new RuntimeException("Invalid Parameters.");
		
		int i = start, j = end;
		int key = data[start];
		
		while(i<j){
			while(data[j]>key&&j>i)
				j--;
			data[i] = data[j];
			while(data[i]<=key&&i<j)
				i++;
			data[j] = data[i];
			
		}
		data[i] = key;
		return i;
		
	}
	
	public static void main(String[] args){
		int[] data = {10,12,4,7,5,-1,0,5,7,9,13};
		QuickSort(data, 0, data.length-1);
		for(int i=0; i <=data.length-1;i++){
			System.out.print(data[i]+" ");
		}
	}

}
