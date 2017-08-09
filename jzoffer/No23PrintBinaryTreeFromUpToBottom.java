package JZoffer;

import java.util.LinkedList;
import java.util.Queue;

public class No23PrintBinaryTreeFromUpToBottom {
	public static void main(String[] args) {
		//功能测试
		//普通二叉树
/*		BinaryNode root1 = new BinaryNode(1);
        BinaryNode node1 = new BinaryNode(2);
        BinaryNode node2 = new BinaryNode(3);
        BinaryNode node3 = new BinaryNode(4);
        BinaryNode node4 = new BinaryNode(5);
        BinaryNode node5 = new BinaryNode(6);
        BinaryNode node6 = new BinaryNode(7);
        root1.left = node1;
        root1.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;
        node2.right = node6;
        printFromTopToBottom(root1);//1 2 3 4 5 6 7
*/
		//二叉树所有节点都没有左子树
/*		BinaryNode root1 = new BinaryNode(1);
		BinaryNode node1 = new BinaryNode(2);
		BinaryNode node2 = new BinaryNode(3);
		BinaryNode node3 = new BinaryNode(4);
		root1.right = node1;
		node1.right = node2;
		node2.right = node3;
		printFromTopToBottom(root1);//1 2 3 4
*/
		//二叉树所有节点都没有右子树
/*		BinaryNode root1 = new BinaryNode(1);
		BinaryNode node1 = new BinaryNode(2);
		BinaryNode node2 = new BinaryNode(3);
		BinaryNode node3 = new BinaryNode(4);
		root1.left = node1;
		node1.left = node2;
		node2.left = node3;
		printFromTopToBottom(root1);//1 2 3 4
*/
		//只有一个结点的二叉树
/*		BinaryNode root1 = new BinaryNode(1);
		printFromTopToBottom(root1);//1
*/
		
		//较复杂的二叉树
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
        printFromTopToBottom(root1);//8 8 7 9 2 4 7

	}
	
	public static void printFromTopToBottom(BinaryNode root){
		if(root==null)
			return;
		Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
		queue.add(root);
		while(queue.size()!=0){
			BinaryNode head = queue.poll();
			System.out.print(head.data+" ");
			if(head.left!=null)
				queue.add(head.left);
			if(head.right!=null)
				queue.add(head.right);
		}
	}
}
