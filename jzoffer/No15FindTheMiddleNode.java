package JZoffer;

public class No15FindTheMiddleNode {
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
        
        ListNode ret= findTheMiddleNode(node3);
        if(ret!=null)
        	System.out.println(ret.value);
        else
        	System.out.println("Wrong parameters");
        
	}
	public static ListNode findTheMiddleNode(ListNode headNode){
		if(headNode==null)//Á´±íÎª¿Õ
			return null;
		
		ListNode first = headNode, second = headNode;
		while(second.next!=null&&second.next.next!=null){
			second=second.next.next;
			first=first.next;
		}
		return first;
	}


}
