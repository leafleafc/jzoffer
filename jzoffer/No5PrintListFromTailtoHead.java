package JZoffer;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


/**
 * 剑指offer面试题5：从尾到头打印链表
 * 输入一个链表的头结点，从尾到头打印出每个结点的值
 * 解决方案一：首先遍历链表的节点后打印，典型的“后进先出”，可以使用栈来实现这种顺序。
 * 解决方案二：栈的本质就是递归，直接使用递归的方式，打印一个节点的时候先打印它后面的节点，再打印该节点自身，实现反向打印
 * 解决方案三：遍历链表，把链表中的元素复制到ArrayList中，然后逆序打印ArrayList中的元素
 * 解决方案四：前三种解决方案本身属于在打印链表的时候不修改链表本身结构，
 * 在允许修改链表结构的情况下可以把链表中的节点指针反转过来，改变链表方向，然后重新遍历打印改变方向后的链表
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
//        //使用栈实现逆序打印链表
//        printByStack(node1);
//        System.out.println();
//        //使用递归实现逆序打印链表
//        printByRec(node1);
//        System.out.println();
//        //使用ArrayList逆序打印链表
//        printByArrayList(node1);
//        System.out.println();
        //使用递归反转实现逆序打印
        //printByReverse(node1);   
        
        printByReverseRec(node1);
    }
    
	//栈 实现逆向打印链表
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
	
	//使用递归实现逆序打印链表
	public static void printByRec(ListNode headNode){
		if(headNode != null){
			printByRec(headNode.next);
			System.out.print(headNode.value);
		}
		else 
			return;
	}
	
	//复制到ArrayList再倒序打印ArrayList
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
			//保存当前节点的下一个节点
			nextNode = curNode.next;
			//更新当前节点的下个节点
			curNode.next = preNode;
			//移动指针，前一节点和当前节点都后移一位
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
		//链表为空或者只有一个节点
		if(headNode == null||headNode.next == null)
			return headNode;
		//保存当前节点的下个节点
		ListNode nextNode = headNode.next;
		//当前节点的下一个节点置空
	    headNode.next = null;
	    //翻转当前节点之后的链表
		ListNode revHeadNode = reverseByRec(nextNode);
		//连接反转后的链表和当前节点
		nextNode.next = headNode;
		return revHeadNode;
	}
	
}






