package JZoffer;

/**
 * ��ָoffer������13:��O(1)ʱ��ɾ������ڵ�
 * ��Ŀ���������������ͷָ���һ���ڵ�ָ�룬����һ��������O(1)ʱ��ɾ���ýڵ㡣
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
    	// ������
    	if (head == null || node == null) {
    	    return null;
        }
        if(node.next==null){//ɾ��β�ڵ㣬����˳������ҵ�β����ǰһ���
            if(head==node){//Ҫɾ���Ľ�����ͷ��㣬����β���
                head=null;
                return null;
            }
            else{//ֻ��ɾ��β���
            	ListNode nHead = head;
        	    System.out.println("ɾ��β���");
                while(nHead.next!=node){
                    nHead=nHead.next;
                }
                nHead.next=null;
           }
        }
        else{//Ҫɾ���Ľ�����м���ͨ��������ͷ����һ��������������
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