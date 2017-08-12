package learn;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class BinaryNode{
	public int data;
	public BinaryNode left;
	public BinaryNode right;
	public BinaryNode(int data){
		this.data=data;
		this.left=null;
		this.right=null;
	}
	
}
public class BinarySearchTree {
	public BinaryNode root; 
	public BinarySearchTree()
    {
    	root = null;
    }
    public BinarySearchTree(int k)
    {
    	root = createFullBinarySearchTree(1,(int)(Math.pow(2,k)-1));
    }
    private BinaryNode createFullBinarySearchTree(int start, int end)
	{
	    BinaryNode tn = null;
	    int mid = (start+end)/2;
		if (mid>=start && mid <=end) {
			    int value = mid;
				tn = new BinaryNode(value);
				tn.left = createFullBinarySearchTree(start, mid-1);
				tn.right = createFullBinarySearchTree(mid+1, end);
				return tn;
			}		
		return tn;
	}
    
    public BinarySearchTree(int[] array)
    {
    	for(int i=0;i<=array.length-1;i++){
    		//root = insertBinarySearchTreeRec(root,array[i]);
    		root = insertBinarySearchTree(root,array[i]);
    	}
    }
    private BinaryNode insertBinarySearchTreeRec(BinaryNode childRoot, int value){
    	if(childRoot == null){
    		BinaryNode tn = new BinaryNode(value);
    		childRoot = tn;
    	}
    	else if (value < childRoot.data){
    		childRoot.left = insertBinarySearchTreeRec(childRoot.left,value);
    	}
    	else 
    		childRoot.right = insertBinarySearchTreeRec(childRoot.right,value);	
    	return childRoot;
    }
    
    private BinaryNode insertBinarySearchTree(BinaryNode treeRoot, int value){
    	if(treeRoot == null){
    		BinaryNode tn = new BinaryNode(value);
    		treeRoot = tn;
    		return treeRoot;
    	}
    	BinaryNode tn = treeRoot;
    	while (tn!= null){
    		if(value< tn.data && tn.left == null){
    			tn.left = new BinaryNode(value);
    	    	return treeRoot;
    		}
    		else if(value> tn.data && tn.right == null){
    			tn.right = new BinaryNode(value);
    	    	return treeRoot;
    		}
    		else if(value< tn.data && tn.left != null){
    			tn = tn.left;
    		}
    		else if(value> tn.data && tn.right != null){
    			tn = tn.right;
    		}
    	}
    	return treeRoot;
    }
    public static void main(String args[]){
		 int k=4;
//		 BinarySearchTree myFullTree = new BinarySearchTree(k);
//		 //BinaryTreeTraversal.preOrderRec(myTree.root);
//		 BinarySearchTreeTraversal.inOrderRec(myFullTree.root);
//		 System.out.println();
//		 BinarySearchTreeTraversal.levelTravel(myFullTree.root);
//		 System.out.println();
//		 System.out.println(OtherOperation.binarySearch(10, 15, 13, 1, (2<<k)-1));
		 int[] a = {10,6,14,12,4,8,16};
		 BinarySearchTree myTree = new BinarySearchTree(a);
		 BinarySearchTreeTraversal.inOrderRec(myTree.root);
		 System.out.println();
		 BinarySearchTreeTraversal.levelTravel(myTree.root);
	 } 
  

}

class BinarySearchTreeTraversal {
	/**
	 * @param root 树根节点
	 * 递归先序遍历
	 */
	public static void preOrderRec(BinaryNode root){
		if(root!=null){
			System.out.print(root.data+" ");
			preOrderRec(root.left);
			preOrderRec(root.right);
		}
	}
	/**
	 * @param root 树根节点
	 * 递归中序遍历
	 */
	public static void inOrderRec(BinaryNode root){
		if(root!=null){
			inOrderRec(root.left);
			System.out.print(root.data+" ");
			inOrderRec(root.right);
		}
	}
	public static void levelTravel(BinaryNode root){
		if(root==null)return;
		Queue<BinaryNode> q=new LinkedList<BinaryNode>();
		q.add(root);
		while(!q.isEmpty()){
			BinaryNode temp =  q.poll();
			System.out.print(temp.data+" ");
			if(temp.left!=null)q.add(temp.left);
			if(temp.right!=null)q.add(temp.right);
		}
	}
}

class OtherOperation{
	    public static int binarySearch(int a,int b,int c, int left, int right) {
	        int m = left + (right - left) / 2;

	        if((a - m) * (b - m) <= 0 || (a - m) * (c - m) <= 0 || (c - m) * (b - m) <= 0) {
	            return m;
	        } else if(a > m) {
	            return binarySearch(a, b, c, m + 1, right);
	        } else {
	            return binarySearch(a, b, c, left, m - 1);
	        }
	    }

//	    public static void main(String[] args) {
//	        Scanner sc = new Scanner(System.in);
//	        int k = sc.nextInt();
//	        int a = sc.nextInt();
//	        int b = sc.nextInt();
//	        int c = sc.nextInt();
//	        System.out.println(binarySearch(a, b, c, 1, (2 << k) - 1));
//	    }
}
