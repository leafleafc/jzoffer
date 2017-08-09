package JZoffer;

public class ReverseList {
	public ListNode reverse(ListNode head){
		if(head == null || head.next == null)
			return head;
		ListNode newHead = null, cur = head, next = head.next;
		while(cur!=null){
			next = cur.next;
			cur.next = newHead;
			newHead = cur;
			cur = next;
		}
		return newHead;
	}

}
