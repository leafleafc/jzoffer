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
        findPathForSuminBTree(root1, 15);//һ��
        
        BinaryNode root2 = new BinaryNode(10);
        BinaryNode a = new BinaryNode(5);
        BinaryNode b = new BinaryNode(12);
        BinaryNode c = new BinaryNode(4);
        BinaryNode d = new BinaryNode(7);
        root2.left = a;
        root2.right = b;
        a.left = c;
        a.right = d;
        findPathForSuminBTree(root2, 22);//2��
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
		//��ǰ���ֵ��ջ
		currentSum+=root.data;
		path.add(root.data);
		
		boolean isLeaf = (root.left==null)&&(root.right==null);
		if((currentSum==expectedSum)&&isLeaf){//��Ҷ�ӽ����ֵ����
			System.out.println("�ҵ�һ��·����");
			for(int i:path){
				 System.out.print(i+" ");  
			}
			System.out.println();
		}
		else{//����Ҷ�ӽ�����ֵ������
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
		//��ǰ���ֵ��ջ
		currentSum+=root.data;
		path.add(root.data);
		
		boolean isLeaf = (root.left==null)&&(root.right==null);
		if((currentSum==expectedSum)&&isLeaf){//��Ҷ�ӽ����ֵ����
			System.out.println("�ҵ�һ��·����");
			for(int i:path){
				 System.out.print(i+" ");  
			}
			System.out.println();
		}
		else{//����Ҷ�ӽ�����ֵ������
			System.out.println("��ǰ·����");
			for(int i:path){
				 System.out.print(i+" ");  
			}
			System.out.println();
			
			if(root.left!=null){
				System.out.println("������������");
				findPathForSuminBTreeDetail(root.left, expectedSum, path, currentSum);
				System.out.println("������������");
			}
			else
				System.out.println("������Ϊ�գ�������������");
				
			if(root.right!=null){
				System.out.println("������������");
				findPathForSuminBTreeDetail(root.right, expectedSum, path, currentSum);
				System.out.println("������������");
			}
			else
				System.out.println("������Ϊ�գ�������������");
		}
		System.out.println("����ջ��Ԫ�أ�"+path.pop());
		
	}
}
