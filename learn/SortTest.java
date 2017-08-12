package learn;
import java.util.*;

public class SortTest {
	public static void bubbleSort(int[] source){//小的值放到最前面
		for (int i=0;i<=source.length-1;i++){
			for(int j=source.length-1;j>=i+1;j--){
				if(source[j]<source[j-1]){
					int temp =0;
					temp = source[j-1];
					source[j-1] = source[j];
					source[j] = temp;
				}
			}
			for(int l=0;l<10;l++){
				System.out.print(source[l]+",");
			}
			System.out.println();
		}
	}
	public static void bubbleSort2(int[] source){//大的值放到最后面
		for(int i=source.length-1;i>=0;i--){//定义每次遍历的边界
			for(int j=0;j<=i-1;j++){
				if(source[j]>source[j+1])
					testswap(source, j, j+1);
			}
		}
		
	}
	
	public static void selectSort(int[] source){
		for(int i=0;i<=source.length-1;i++){
			int min=i;
			for(int j=i+1;j<=source.length-1;j++){
				if(source[j]<source[min]){
					min=j;
				}
				
			}
			if (min!=i){
				testswap(source, i, min);
			}
		}
	}
	
	public static void InsertSort(int[] source){
		for(int i=0; i<source.length-1;i++){
			if(source[i+1]<source[i]){
				int temp = source[i+1];
				int j=0;
				for(j=i;j>=0&& source[j]>temp;j--){
					source[j+1]=source[j];				
				}
				source[j+1]=temp;
			}
		}
		
	}
	
	public static void InsertSort2(int[] source){
		for(int i=0; i<=source.length-1;i++){
			int temp = source[i];
			int j=0;
			for(j=i-1;j>=0&& temp<source[j];j--){
					source[j+1]=source[j];	
			}
			source[j+1]=temp;
		}
		
	}
	public static void HalfInsertSort(int[] source){
		int i=0,j=0;
		int temp=0;
		int low=0,high=0,mid=0;
		for(i=0; i<=source.length-1;i++){
			temp = source[i];
			low =0;
			high=i-1;
			while(low<=high){
				mid= (low+high)/2;
				if(temp<source[mid]){
					high=mid-1;
				}
				else
					low=mid+1;
			}
			for(j=i-1;j>high;j--){
				source[j+1]=source[j];
			}
			//source[high+1]=temp;
			source[j+1]=temp;
		}
	} 
	public static void testswap(int[] a,int x, int y){
		int temp;
		temp =a[x];
		a[x]=a[y];
		a[y]=temp;
	}
	public static void testswap2(Integer x, Integer y){
		int temp;
		temp=x;
		x=y; 
		y=temp;
	}

	public static void main(String[] args){
		int[] a = {4,2,1,6,3,6,0,-5,1,1};
		int i;
		//bubbleSort(a);
		//selectSort(a);
		//InsertSort(a);
		HalfInsertSort(a);
		//InsertSort2(a);
//		Integer m =0;
//		Integer n =100;
//		testswap(a,0,1);
//		testswap2(m,n);
//		System.out.println(m);
//		System.out.println(n);
		
		for(i=0;i<10;i++){
			System.out.println(a[i]);
		}
		
	}
}
