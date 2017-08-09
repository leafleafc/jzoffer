package JZoffer;

public class No20PrintMatrixInCW {
	public static void main(String[] args){
//		int[][] numbers= {
//				{1,2,3,4},
//				{5,6,7,8},
//				{9,10,11,12},
//				{13,14,15,16}
//		};//1 2 3 4 8 12 16 15 14 13 9 5 6 7 11 10 
		
//		int[][] numbers= {//打印需要四步
//				{1,2,3,4},
//				{5,6,7,8},
//				{9,10,11,12}
//		};//1 2 3 4 8 12 11 10 5 6 7 
		int[][] numbers= {//打印需要三步
				{1,2,3},
				{4,5,6}
		};//1 2 3 6 5 4 
		
//		int[][] numbers= {
//				{1,2,3},
//				{4,5,6},
//			    {7,8,9},
//			    {10,11,12}
//	    };//1 2 3 6 9 12 11 10 7 4 5 8
		
//		int[][] numbers= {//打印需要一步
//				{1,2,3,4}
//		};//1 2 3 4
		
//		int[][] numbers= {//打印需要两步
//				{1},
//				{2},
//				{3},
//				{4}
//		};//1 2 3 4 
		
//		int[][] numbers ={{1}};//1
		
		printMatrixCW(numbers);
		
	}
	
	public static void printMatrixCW(int[][] numbers){
		if(numbers==null||numbers.length<=0||numbers[0].length<=0)
			return;
		
		int start =0;
		
		while(numbers[0].length>start*2 && numbers.length>start*2){
			printMatrixInCircle(numbers, start);
			//System.out.println("start"+start);
			start++;
		}
	}
	
	public static void printMatrixInCircle(int[][] numbers, int start){
		int endX = numbers[0].length-1-start;//列数
		int endY = numbers.length-1-start;//行数
		
		//从左到右打印一行
		//System.out.println("从左到右打印一行");
		for(int i=start;i<=endX;i++){
			System.out.print(numbers[start][i]+" ");
		}
		//从上到下打印右边一列
		//System.out.println("从上到下打印右边一列");
		for(int i=start+1;i<=endY;i++){//if(start<endY)终止行号大于起始行号，至少两行，才需要打印右边一列
			System.out.print(numbers[i][endX]+" ");
		}
		//从右到左打印下面一行
		//System.out.println("从右到左打印下面一行");
		if(start+1<=endY){//至少有两行
			for(int i=endX-1;i>=start;i--){//至少有两列
				System.out.print(numbers[endY][i]+" ");
			}
		}
		//从下到上打印左边一列
		//System.out.println("从下到上打印左边一列");
		if(start+1<=endX){//至少有两列
			for(int i=endY-1;i>=start+1;i--){//至少三行
				System.out.print(numbers[i][start]+" ");
			}
		}
	}
}


