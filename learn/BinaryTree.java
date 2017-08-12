package learn;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

/**
 * 
 * @author kerryfish
 * JAVAʵ�ֶ��������������򡢺��򡢲������
 * �ݹ�ͷǵݹ�汾
 *
 */

class Node{
	public int value;
	public Node left;
	public Node right;
	public Node(int v){
		this.value=v;
		this.left=null;
		this.right=null;
	}
	
}


public class BinaryTree {
	    public Node root;  
	    public BinaryTree(int[]array)
	    {
	    	root = createBinaryTreeByArray(array, 0);
	    }
	  
		private Node createBinaryTreeByArray(int []array,int index)
		{
		    Node tn = null;
			if (index<array.length) {
				    int value = array[index];
					tn = new Node(value);
					tn.left = createBinaryTreeByArray(array, 2*index+1);
					tn.right = createBinaryTreeByArray(array, 2*index+2);
					return tn;
				}		
			return tn;
		}
		 public static void main(String args[]){
			 int []array = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16};
			 BinaryTree myTree = new BinaryTree(array);
			 //BinaryTreeTraversal.preOrderRec(myTree.root);
			 BinaryTreeTraversal.inOrderStack(myTree.root);
		 } 
}


class BinaryTreeTraversal {
	/**
	 * @param root �����ڵ�
	 * �ݹ��������
	 */
	public static void preOrderRec(Node root){//��һ����Ҫstatic
		if(root!=null){
			System.out.println(root.value);
			preOrderRec(root.left);
			preOrderRec(root.right);
		}
	}
	/**
	 * @param root �����ڵ�
	 * �ݹ��������
	 */
	public static void inOrderRec(Node root){
		if(root!=null){
			inOrderRec(root.left);
			System.out.println(root.value);
			inOrderRec(root.right);
		}
	}
	/**
	 * @param root �����ڵ�
	 * �ݹ�������
	 */
	public static void postOrderRec(Node root){
		if(root!=null){
			postOrderRec(root.left);
			postOrderRec(root.right);
			System.out.println(root.value);
		}
	}
	/**
	 * 
	 * @param root �����ڵ�
	 * ����ջʵ��ѭ���������������
	 * ����ʵ��������ͼ��������ȱ�����DFS��
	 * ά��һ��ջ�������ڵ���ջ��Ȼ��ֻҪջ��Ϊ�գ���ջ�����ʣ��������ν����ʽڵ���ҽڵ㡢��ڵ���ջ��
	 * ���ַ�ʽӦ���Ƕ����������һ������ʵ�֣�����ȥ�����ˣ������ǲ��߱��ܺõ���չ�ԣ�������ͺ���ʽ�в�����
	 */
	public static void preOrderStack_1(Node root){
		if(root==null)return;
		Stack<Node> s=new Stack<Node>();
		s.push(root);
		while(!s.isEmpty()){
			Node temp=s.pop();
			System.out.println(temp.value);
			if(temp.right!=null) s.push(temp.right);
			if(temp.left!=null) s.push(temp.left);
		}
	}
	/**
	 * 
	 * @param root ���ĸ��ڵ�
	 * ����ջģ��ݹ����ʵ��ѭ���������������
	 * ���ַ�ʽ�߱���չ�ԣ���ģ��ݹ�Ĺ��̣����������㲻�ϵ�ѹ��ջ��ֱ��null��Ȼ����ջ���ڵ��������
	 */
	public static void preOrderStack_2(Node root){
		if(root==null)return;
		Stack<Node> s=new Stack<Node>();
		while(root!=null||!s.isEmpty()){
			while(root!=null){
				System.out.println(root.value);
				s.push(root);//�ȷ�������ջ
				root=root.left;
			}
			root=s.pop();
			root=root.right;//�����null����ջ������������
		}
	}
	/**
	 * 
	 * @param root �����ڵ�
	 * ����ջģ��ݹ����ʵ��ѭ���������������
	 * ˼��������preOrderStack_2��ͬ��ֻ�Ƿ��ʵ�ʱ��������������������ֱ��null��ʱ���ջ�����ʡ�
	 */
	public static void inOrderStack(Node root){
		if(root==null)return;
		Stack<Node> s=new Stack<Node>();
		while(root!=null||!s.isEmpty()){
			while(root!=null){
				s.push(root);//�ȷ�������ջ
				root=root.left;
			}
			root=s.pop();
			System.out.println(root.value);
			root=root.right;//�����null����ջ������������
		}
	}
	/**
	 * 
	 * @param root �����ڵ�
	 * ���������ͬ���������������Ҫ�ȴ���������������Ȼ���ٴ����(����)��������Ҫһ����¼��Щ�ڵ��Ѿ������ʵĽṹ(���������ṹ�����һ�����)�����������mapʵ��
	 */
	public static void postOrderStack(Node root){
		if(root==null)return;
		Stack<Node> s=new Stack<Node>();
		Map<Node,Boolean> map=new HashMap<Node,Boolean>(); 
		s.push(root);
		while(!s.isEmpty()){
			Node temp=s.peek();
			if(temp.left!=null&&!map.containsKey(temp.left)){
				temp=temp.left;
				while(temp!=null){
                    if(map.containsKey(temp))break;
                    else s.push(temp);
                    temp=temp.left;
                }
				continue;
			}
			if(temp.right!=null&&!map.containsKey(temp.right)){
                s.push(temp.right);
                continue;
            }
			Node t=s.pop();
			map.put(t,true);
			System.out.println(t.value);
		}
	}
	/**
	 * 
	 * @param root �����ڵ�
	 * ����������������ö���ʵ�֣��Ƚ����ڵ�����У�ֻҪ���в�Ϊ�գ�Ȼ������У������ʣ����Ž����ʽڵ�������������������
	 */
	public static void levelTravel(Node root){
		if(root==null)return;
		Queue<Node> q=new LinkedList<Node>();
		q.add(root);
		while(!q.isEmpty()){
			Node temp =  q.poll();
			System.out.println(temp.value);
			if(temp.left!=null)q.add(temp.left);
			if(temp.right!=null)q.add(temp.right);
		}
	}
}