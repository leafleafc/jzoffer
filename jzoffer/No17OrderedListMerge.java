package JZoffer;

public class No17OrderedListMerge {
	public static void main(String[] args){
		ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(1);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(7);
        ListNode node8 = new ListNode(8);
        node1.next = node3;
        node2.next = node4;
        node3.next = node5;
        node4.next = node6;
        node5.next = node7;
        node6.next = node8;
        
        //ListNode ret= mergeListByRec(node1, node2);
        ListNode ret= mergeList(node1, node2);
        if(ret!=null)
        	while(ret!=null){
        		System.out.print(ret.value+" ");
        		ret=ret.next;
        	}
        else
        	System.out.println("Wrong parameters");
	}
	
	public static ListNode mergeListByRec(ListNode headNode1, ListNode headNode2){
		if(headNode1==null)
			return headNode2;
		else if(headNode2==null)
			return headNode1;
		
		ListNode mergedHead = null;
		if(headNode1.value<=headNode2.value){
			mergedHead = headNode1;
			mergedHead.next = mergeListByRec(headNode1.next, headNode2);
		}
		else{
			mergedHead = headNode2;
			mergedHead.next = mergeListByRec(headNode1, headNode2.next);
		}
		return mergedHead;
	}
	
	public static ListNode mergeList(ListNode headNode1, ListNode headNode2){
		if(headNode1==null)
			return headNode2;
		else if(headNode2==null)
			return headNode1;
		
		ListNode mergedHead = null, curTailNode = null;
		while(headNode1!=null&&headNode2!=null){
			if(headNode1.value<=headNode2.value){
				if(mergedHead==null){
					mergedHead = headNode1;
					curTailNode = mergedHead;
				}
				else{
					curTailNode.next = headNode1;
					curTailNode = curTailNode.next;
				}
				headNode1 = headNode1.next;
				//curTailNode.next = null;
			}
			else{
				if(mergedHead==null){
					mergedHead = headNode2;
					curTailNode = mergedHead;
				}
				else{
					curTailNode.next = headNode2;
					curTailNode = curTailNode.next;
				}
				headNode2 = headNode2.next;
				//curTailNode.next = null;
			}
		}
		
		if(headNode1!=null){
			curTailNode.next = headNode1;
		}
		else{
			curTailNode.next = headNode2;
		}
		return mergedHead;
	}

}
