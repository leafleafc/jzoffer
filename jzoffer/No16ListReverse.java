package JZoffer;

public class No16ListReverse {
	public static void main(String[] args){
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
        
        //ListNode ret= reverseTheList(node1);
        ListNode ret= reverseListByRec(node1);
        if(ret!=null)
        	while(ret!=null){
        		System.out.print(ret.value+" ");
        		ret=ret.next;
        	}
        else
        	System.out.println("Wrong parameters");
	}
	
	public static ListNode reverseTheList(ListNode headNode){
		if(headNode==null||headNode.next==null)
			return headNode;
		
		ListNode preNode = null, curNode = headNode;
		ListNode nextNode = headNode.next;
		while(curNode!=null){
			nextNode = curNode.next;
			curNode.next = preNode;
			preNode = curNode;
			curNode = nextNode;
		}
		return preNode;
	}
	
	public static ListNode reverseListByRec(ListNode headNode){
		if(headNode == null||headNode.next == null)
			return headNode;
				
		ListNode nextNode = headNode.next;
		headNode.next = null;
		ListNode reversedHead = reverseListByRec(nextNode);
		//连接反转后的链表和当前节点
		nextNode.next = headNode;
		return reversedHead;
	}
}
