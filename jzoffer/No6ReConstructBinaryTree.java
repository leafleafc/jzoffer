package JZoffer;

import java.util.Scanner;
import java.util.Stack;


class BinaryTreeNode{
	int value;
	BinaryTreeNode left;
	BinaryTreeNode right;
	
	BinaryTreeNode(){};
	BinaryTreeNode(int value){
		this.value = value;
		this.left = null;
		this.right = null;
	}
}

public class No6ReConstructBinaryTree {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		String preOrderStr = in.nextLine();
		String inOrderStr = in.nextLine();
		String[] preOrderArray = preOrderStr.split(",");
		String[] inOrderArray = inOrderStr.split(",");
		
		int[] preOrder = new int[preOrderArray.length];
		int[] inOrder = new int[inOrderArray.length];
		
		for(int i= 0;i<=preOrderArray.length-1;i++){
			preOrder[i] = Integer.valueOf(preOrderArray[i]); 
		}
		for(int i= 0;i<=inOrderArray.length-1;i++){
			inOrder[i] = Integer.valueOf(inOrderArray[i]); 
		}
		
//		for(int i= 0;i<=preOrder.length-1;i++){
//			System.out.print(preOrder[i]+","); 
//		}
//		for(int i= 0;i<=inOrderArray.length-1;i++){
//			System.out.print(inOrder[i]+",");
//		}
		
		BinaryTreeNode root = reConstructBinaryTree(preOrder, inOrder);
		//BinaryTreeTra.preOrderRec(root);
		BinaryTreeTra.preOrder(root);
		System.out.println();
		BinaryTreeTra.inOrder(root);
		
	}
	
	public static BinaryTreeNode reConstructBinaryTree(int[] preOrder, int[] inOrder){
		if(preOrder==null||inOrder==null||preOrder.length!=inOrder.length||preOrder.length<1)
			return null;
	    return reconstruct(preOrder,0,preOrder.length-1,inOrder,0,inOrder.length-1);
	}
	
	public static BinaryTreeNode reconstruct(int[] preOrder, int ps, int pe, int[] inOrder, int is, int ie){
		if(ps>pe)
			return null;
		int curRoot = preOrder[ps];
		int i=0;
		for(i=is; i<=ie && inOrder[i] != curRoot; i++){};
		if(i>ie)
			throw new RuntimeException("invalid input"+i);
		else{
			BinaryTreeNode curRootNode=new BinaryTreeNode();
			curRootNode.value=curRoot;
			//��ǰ�ڵ�����������ĸ���Ϊi-is
			//��������Ӧ��ǰ�������λ����preOrder[ps+1,ps+i-is]
			//��������Ӧ�����������λ����inOrder[is,i-1]
			curRootNode.left=reconstruct(preOrder,ps+1,ps+i-is,inOrder,is,i-1);
			//��ǰ�ڵ���������Ľ�����Ϊie-index
			//��������Ӧ��ǰ�����λ����preOrder[ps+i-is+1,pe]
			//��������Ӧ���������λ����inOrder[i+1,ie]
			curRootNode.right=reconstruct(preOrder,ps+i-is+1,pe,inOrder,i+1,ie);
			return curRootNode;
		}	
	}
}

class BinaryTreeTra{
	public static void preOrderRec(BinaryTreeNode root){
		if(root == null)
			return;
		System.out.print(root.value+" ");
		preOrderRec(root.left);
		preOrderRec(root.right);
	}
	public static void preOrder(BinaryTreeNode root){
		if(root == null)
			return;
		Stack<BinaryTreeNode> bStack = new Stack<BinaryTreeNode>();
		while(root!=null||!bStack.isEmpty()){
			while(root!=null){
				System.out.print(root.value+" ");
				bStack.push(root);
				root = root.left;
			}
			root = bStack.pop();
			root = root.right;
		}
	}
	
	public static void inOrder(BinaryTreeNode root){
		if(root == null)
			return;
		Stack<BinaryTreeNode> bStack = new Stack<BinaryTreeNode>();
		while(root!=null||!bStack.isEmpty()){
			while(root!=null){
				bStack.push(root);
				root = root.left;
			}
			root = bStack.pop();
			System.out.print(root.value+" ");
			root = root.right;
		}
	}
}
/*��������
 * ��ͨ��������
 * ��ȫ��������
1,2,4,5,3,6,7
4,2,5,1,6,3,7
1 2 4 5 3 6 7 
4 2 5 1 6 3 7

 * ����ȫ��������
1,2,4,8,5,3,6,7
8,4,2,5,1,6,3,7
1 2 4 8 5 3 6 7 
8 4 2 5 1 6 3 7 

 * �����������
 * ���нڵ㶼û�����ӽڵ�Ķ�������
1,2,3,4,5,6,7
7,6,5,4,3,2,1
1 2 3 4 5 6 7 
7 6 5 4 3 2 1 

 * ���нڵ㶼û�����ӽڵ�Ķ�������
1,2,3,4,5,6,7
1,2,3,4,5,6,7
1 2 3 4 5 6 7 
1 2 3 4 5 6 7

 *��ֻ��һ���ڵ�Ķ�������
��
��
1 
1
 *������������ԣ�
 *���������ĸ��ڵ�ָ��Ϊ�գ�
 * �����Ҫ�޸�һ������

��*�������ǰ��������к�����������в�ƥ�䣺
1,2,3,4,5,6,7
0,1,2,3,4,5,6
Exception in thread "main" java.lang.RuntimeException: invalid input1
	at JZoffer.No6ReConstructBinaryTree.reconstruct(No6ReConstructBinaryTree.java:66)
	at JZoffer.No6ReConstructBinaryTree.reconstruct(No6ReConstructBinaryTree.java:73)
	at JZoffer.No6ReConstructBinaryTree.reConstructBinaryTree(No6ReConstructBinaryTree.java:56)
	at JZoffer.No6ReConstructBinaryTree.main(No6ReConstructBinaryTree.java:45)
 * */
