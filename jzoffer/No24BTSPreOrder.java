package JZoffer;

public class No24BTSPreOrder {
	public static void main(String[] args){
		//int[] array = {8,6,5,7,10,9,11};//完全二叉树
		//int[] array = {8,6,10,9,11};//不完全二叉树，某支没有左子树
		//int[] array = {8,6,4,7,10};//不完全二叉树，某支没有右子树
		//int[] array = {8,6,5,4};//只有左子树
		//int[] array = {4,5,6,7};//只有右子树
		//int[] array = {1};//只有一个结点的二叉树
		//int[] array = null;//空树
		int[] array = {8,10,6,5,7};//不是二叉搜索树的前序遍历序列
		if(array!=null)
			System.out.println(verifyBTSPreOrder(array, 0, array.length-1));
		else
			System.out.println("false");
	}
	
	public static boolean verifyBTSPreOrder(int[] array, int start, int end){
		if(array==null||array.length==0)
			return false;
		if(end-start==1)
			return true;
		if(start<0||start>array.length-1||end<0||end>array.length-1||start>end)
			throw new RuntimeException("Wrong parameters");  
		
		int root = array[start];
		
		int i=start+1;
		while(i<=end&&array[i]<=root){
			i++;
		}
		int j=i;
		while(j<=end){
			if(array[j]<root)
				return false;
			j++;
		}
		
		boolean left = true;
		if(i>start+1)
			left = verifyBTSPreOrder(array,start+1,i-1);
		
		boolean right = true;
		if(i<=end)
			right = verifyBTSPreOrder(array, i, end);
		
		return left&&right;
	}

}
