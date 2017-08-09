package JZoffer;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


/**
 * ��ָoffer������5����β��ͷ��ӡ����
 * ����һ�������ͷ��㣬��β��ͷ��ӡ��ÿ������ֵ
 * �������һ�����ȱ�������Ľڵ���ӡ�����͵ġ�����ȳ���������ʹ��ջ��ʵ������˳��
 * �����������ջ�ı��ʾ��ǵݹ飬ֱ��ʹ�õݹ�ķ�ʽ����ӡһ���ڵ��ʱ���ȴ�ӡ������Ľڵ㣬�ٴ�ӡ�ýڵ�����ʵ�ַ����ӡ
 * ��������������������������е�Ԫ�ظ��Ƶ�ArrayList�У�Ȼ�������ӡArrayList�е�Ԫ��
 * ��������ģ�ǰ���ֽ���������������ڴ�ӡ�����ʱ���޸�������ṹ��
 * �������޸�����ṹ������¿��԰������еĽڵ�ָ�뷴ת�������ı�������Ȼ�����±�����ӡ�ı䷽��������
 *
 */

class ListNode{
	int value;
	ListNode next;
	
	ListNode(){};
	ListNode(int value){
		this.value = value;
		this.next = null;
	}
}

public class No5PrintListFromTailtoHead {
	
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(7);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        
        ListNode node8 = new ListNode();
//        //ʹ��ջʵ�������ӡ����
//        printByStack(node1);
//        System.out.println();
//        //ʹ�õݹ�ʵ�������ӡ����
//        printByRec(node1);
//        System.out.println();
//        //ʹ��ArrayList�����ӡ����
//        printByArrayList(node1);
//        System.out.println();
        //ʹ�õݹ鷴תʵ�������ӡ
        //printByReverse(node1);   
        
        printByReverseRec(node1);
    }
    
	//ջ ʵ�������ӡ����
	public static void printByStack(ListNode headNode){
		Stack<Integer> myStack = new Stack<Integer>();
		while(headNode!=null){
			myStack.push(headNode.value);
			headNode = headNode.next;
		}
		while(!myStack.isEmpty()){
			System.out.print(myStack.pop());
		}
	}
	
	//ʹ�õݹ�ʵ�������ӡ����
	public static void printByRec(ListNode headNode){
		if(headNode != null){
			printByRec(headNode.next);
			System.out.print(headNode.value);
		}
		else 
			return;
	}
	
	//���Ƶ�ArrayList�ٵ����ӡArrayList
	public static void printByArrayList(ListNode headNode){
		List<ListNode> lList = new ArrayList<ListNode>();
		while(headNode != null){
			lList.add(headNode);
			headNode = headNode.next;
		}
		for(int i=lList.size()-1;i>=0 ;i--){
			System.out.print(lList.get(i).value);
		}
	}
	
	public static void printByReverse(ListNode headNode){
		ListNode preNode = null;
		ListNode nextNode = null;
		ListNode curNode = headNode;
		while(curNode!=null){
			//���浱ǰ�ڵ����һ���ڵ�
			nextNode = curNode.next;
			//���µ�ǰ�ڵ���¸��ڵ�
			curNode.next = preNode;
			//�ƶ�ָ�룬ǰһ�ڵ�͵�ǰ�ڵ㶼����һλ
			preNode = curNode;
			curNode = nextNode;
		}
		headNode = preNode;
		while(headNode!=null){
			System.out.print(headNode.value);
			headNode = headNode.next;
		}
		
	}
	
	public static void printByReverseRec(ListNode headNode){
		headNode = reverseByRec(headNode);
		while(headNode!=null){
			System.out.print(headNode.value);
			headNode = headNode.next;
		}
	}
	

	public static ListNode reverseByRec(ListNode headNode){
		//����Ϊ�ջ���ֻ��һ���ڵ�
		if(headNode == null||headNode.next == null)
			return headNode;
		//���浱ǰ�ڵ���¸��ڵ�
		ListNode nextNode = headNode.next;
		//��ǰ�ڵ����һ���ڵ��ÿ�
	    headNode.next = null;
	    //��ת��ǰ�ڵ�֮�������
		ListNode revHeadNode = reverseByRec(nextNode);
		//���ӷ�ת�������͵�ǰ�ڵ�
		nextNode.next = headNode;
		return revHeadNode;
	}
	
}






