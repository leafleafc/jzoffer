package JZoffer;

/**
 * 剑指offer面试题13:在O(1)时间删除链表节点
 * 题目：给定单向链表的头指针和一个节点指针，定义一个函数在O(1)时间删除该节点。
 * @author GL
 *
 */
public class No13DeleteNodeInList {

    public static class ListNode{
        public int data;
        public ListNode next;
        public ListNode(int data,ListNode next){
            this.data=data;
            this.next=next;
        }
    }

    public static ListNode deleteNode(ListNode head,ListNode node){
    	// 空链表
    	if (head == null || node == null) {
    	    return null;
        }
        if(node.next==null){//删除尾节点，采用顺序查找找到尾结点的前一结点
            if(head==node){//要删除的结点既是头结点，又是尾结点
                head=null;
                return null;
            }
            else{//只是删除尾结点
            	ListNode nHead = head;
        	    System.out.println("删除尾结点");
                while(nHead.next!=node){
                    nHead=nHead.next;
                }
                nHead.next=null;
           }
        }
        else{//要删除的结点是中间普通结点或者是头结点且还有其他后续结点
            node.data=node.next.data;
            node.next=node.next.next;
        }
        return head;
    }
    public static void main(String[] args) {
        ListNode tail=new ListNode(1,null);
        ListNode c=new ListNode(2,tail);
        ListNode b=new ListNode(3,c);
        ListNode head=new ListNode(4,b);
        ListNode curP = head;
        while(curP!=null){
            System.out.println(curP.data);
            curP=curP.next;
        }
        head=deleteNode(head,tail);
        while(head!=null){
            System.out.println(head.data);
            head=head.next;
        }

    }
}