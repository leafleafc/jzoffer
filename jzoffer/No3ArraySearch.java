package JZoffer;

public class No3ArraySearch {
	public static void main(String[] args){
		int[][] array = {{1,2,8,9},
				         {2,4,9,12},
				         {4,7,10,13},
				         {6,8,11,15}};
		System.out.println(findByTheUpperRightCorner(8,array));
		System.out.println(findByTheLowerLeftCorner(7,array));
	}
	
	public static boolean findByTheUpperRightCorner(int target, int[][] array){
		if(array.length>0){
			int rows = array.length;
			int columns = array[0].length;
			int row = 0, column = columns -1;
			while(row<rows&&column>=0){
				if(array[row][column] == target){
					return true;
				}
				else if(array[row][column]>target)
					column--;
				else
					row++;
			}
			return false;
		}
		return false;
	}
	public static boolean findByTheLowerLeftCorner(int target, int[][] array){
		if(array.length>0){
			int rows = array.length;
			int columns = array[0].length;
			int row = rows-1, column = 0;
			while(row>=0 && column<columns){
				if(array[row][column] == target){
					return true;
				}
				else if(array[row][column]>target)
					row--;
				else
					column++;
			}
			return false;
		}
		return false;
	}

}
