package JZoffer;

public class No37FirstCommonNodesInList {
	public static void main(String[] args){
		ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(7);
        ListNode node8 = new ListNode(8);
        node1.next = node3;
        node2.next = node4;
        node3.next = node5;
        node4.next = node6;
        node5.next = node7;
        node6.next = node7;
        node2 = node1;
        No37FirstCommonNodesInList fc = new No37FirstCommonNodesInList();
        ListNode retHead = fc.findFirstCommonNode(node1,node2);
        if(retHead == null)
        	System.out.println("没有公共子结点");
        
        System.out.println("链表1：");
        while(node1!=null){
        	System.out.print(node1.value+" ");
        	node1 = node1.next;
        }
        System.out.println();
        System.out.println("链表2：");
        while(node2!=null){
        	System.out.print(node2.value+" ");
        	node2 = node2.next;
        }
        System.out.println();
        
        while(retHead!=null){
        	System.out.print(retHead.value+" ");
        	retHead = retHead.next;
        }
	}
	public ListNode findFirstCommonNode(ListNode aHead, ListNode bHead){
		if(aHead == null||bHead == null)
			return null;
		int aLength = getLengthOfList(aHead);
		int bLength = getLengthOfList(bHead);
		int diffLength = aLength - bLength;
		
		ListNode longHead = aHead;
		ListNode shortHead = bHead;
		if(diffLength<0){
			longHead = bHead;
			shortHead = aHead;
			diffLength = -diffLength;
		}
		for(int i = 0;i<= diffLength-1; i++)
			longHead = longHead.next;
		
		while((longHead!=null)&&(shortHead!=null)&&(longHead!=shortHead)){
			longHead = longHead.next;
			shortHead = shortHead.next;
		}
		return longHead;
		
	}
	public int getLengthOfList(ListNode head){
		if(head == null)
			return 0;
		int length = 0;
		while(head!=null){
			length++;
			head = head.next;
		}
		return length;
	}
}
