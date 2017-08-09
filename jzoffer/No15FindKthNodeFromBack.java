package JZoffer;

public class No15FindKthNodeFromBack {
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
        
        ListNode ret= findKthNodeFromBack(node1, 7);
        if(ret!=null)
        	System.out.println(ret.value);
        else
        	System.out.println("Wrong parameters");
        
	}
	
	public static ListNode findKthNodeFromBack(ListNode headNode, int kValue){
		if(headNode==null||kValue==0)
			return null;
		
		ListNode first = headNode;
		ListNode second = null;
		
		for(int i=1;i<=kValue-1;i++){// 第一个指针先走k-1
			if(first.next!=null)
				first = first.next;
			else
				return null;
		}
		second = headNode;
		while(first.next!=null){
			first=first.next;
			second=second.next;
		}
		return second;
	}

}
