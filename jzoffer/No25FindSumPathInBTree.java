package JZoffer;

import java.util.Iterator;
import java.util.Stack;


public class No25FindSumPathInBTree {
	
	public static void main(String[] args) {
        BinaryNode root1 = new BinaryNode(8);
        BinaryNode node1 = new BinaryNode(8);
        BinaryNode node2 = new BinaryNode(7);
        BinaryNode node3 = new BinaryNode(9);
        BinaryNode node4 = new BinaryNode(2);
        BinaryNode node5 = new BinaryNode(4);
        BinaryNode node6 = new BinaryNode(7);
        root1.left = node1;
        root1.right = node2;
        node1.left = node3;
        node1.right = node4;
        node4.left = node5;
        node4.right = node6;
        findPathForSuminBTree(root1, 15);//一条
        
        BinaryNode root2 = new BinaryNode(10);
        BinaryNode a = new BinaryNode(5);
        BinaryNode b = new BinaryNode(12);
        BinaryNode c = new BinaryNode(4);
        BinaryNode d = new BinaryNode(7);
        root2.left = a;
        root2.right = b;
        a.left = c;
        a.right = d;
        findPathForSuminBTree(root2, 22);//2条
    }
	
	
	public static void findPathForSuminBTree(BinaryNode root, int expectedSum){
		if(root==null)
			return;
		
		Stack<Integer> path = new Stack<Integer>();
		int currentSum=0;
		findPathForSuminBTree(root, expectedSum, path, currentSum);
		//findPathForSuminBTreeDetail(root, expectedSum, path, currentSum);
	}
	
	public static void findPathForSuminBTree(BinaryNode root, int expectedSum, Stack<Integer> path, int currentSum){
		//当前结点值入栈
		currentSum+=root.data;
		path.add(root.data);
		
		boolean isLeaf = (root.left==null)&&(root.right==null);
		if((currentSum==expectedSum)&&isLeaf){//是叶子结点且值满足
			System.out.println("找到一条路径：");
			for(int i:path){
				 System.out.print(i+" ");  
			}
			System.out.println();
		}
		else{//不是叶子结点或者值不满足
			if(root.left!=null){
				findPathForSuminBTree(root.left, expectedSum, path, currentSum);
			}
			if(root.right!=null){
				findPathForSuminBTree(root.right, expectedSum, path, currentSum);
			}
		}
		path.pop();
		
	}
	public static void findPathForSuminBTreeDetail(BinaryNode root, int expectedSum, Stack<Integer> path, int currentSum){
		//当前结点值入栈
		currentSum+=root.data;
		path.add(root.data);
		
		boolean isLeaf = (root.left==null)&&(root.right==null);
		if((currentSum==expectedSum)&&isLeaf){//是叶子结点且值满足
			System.out.println("找到一条路径：");
			for(int i:path){
				 System.out.print(i+" ");  
			}
			System.out.println();
		}
		else{//不是叶子结点或者值不满足
			System.out.println("当前路径：");
			for(int i:path){
				 System.out.print(i+" ");  
			}
			System.out.println();
			
			if(root.left!=null){
				System.out.println("遍历左子树：");
				findPathForSuminBTreeDetail(root.left, expectedSum, path, currentSum);
				System.out.println("遍历完左子树");
			}
			else
				System.out.println("左子树为空，遍历完左子树");
				
			if(root.right!=null){
				System.out.println("遍历右子树：");
				findPathForSuminBTreeDetail(root.right, expectedSum, path, currentSum);
				System.out.println("遍历完右子树");
			}
			else
				System.out.println("右子树为空，遍历完右子树");
		}
		System.out.println("弹出栈顶元素："+path.pop());
		
	}
}
