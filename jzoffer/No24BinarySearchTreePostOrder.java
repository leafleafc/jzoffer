package JZoffer;

public class No24BinarySearchTreePostOrder {
	public static void main(String[] args){
		//int[] array = {5,7,6,9,11,10,8};//完全二叉树
		//int[] array = {7,4,5,6};//不是二叉搜索树的后序遍历序列
		//int[] array = {6,9,11,10,8};//不完全二叉树，某支左子树为空
		//int[] array = {4,7,6,10,8};//不完全二叉树，某支右子树为空
		//int[] array = {4,5,6,7};//只有左子树
		int[] array = {7,6,5,4};//只有右子树
		//int[] array = {1};//只有一个结点的二叉树
		//int[] array = null;//空指针
		if(array!=null)
			System.out.println(verifySequenceofBTS(array, 0, array.length-1));
		else
			System.out.println("false");
	}
	public static boolean verifySequenceofBTS(int[] array, int start, int end){
		if(array==null||array.length==0)
			return false;
		if(end-start==1)
			return true;
		if(start<0||start>array.length-1||end<0||end>array.length-1||start>end)
			throw new RuntimeException("Wrong parameters");  
		
		int root = array[end];
		int i=start;
		while(i<=end-1&&array[i]<=root){
			i++;
		}
		int j=i;//i记录了第一个大于root的值的下标
		while(j<=end-1){
			if(array[j]<root)
				return false;
			j++;
		}
		boolean left = true;
		if(i>start)//有比根结点小的结点
			left = verifySequenceofBTS(array, start, i-1);
		
		boolean right = true;
		if(i<end)//有比根结点大的结点
			 right = verifySequenceofBTS(array, i, end-1);
		
		return left&&right;
	}

}
