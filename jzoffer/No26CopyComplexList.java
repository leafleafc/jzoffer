package JZoffer;

import java.util.HashMap;
import java.util.Map;

class ComListNode{
	public int value;
	public ComListNode next;
	public ComListNode sibling;
	public ComListNode(int value){
		this.value = value;
		this.next = null;
		this.sibling = null;
	}
}
public class No26CopyComplexList {
	public static void main(String[] args) {

        ComListNode head = new ComListNode(1);
        ComListNode node2 = new ComListNode(2);
        ComListNode node3 = new ComListNode(3);
        ComListNode node4 = new ComListNode(4);
        ComListNode node5 = new ComListNode(5);
        //head = null; 链表头结点为空
        
//        head.next=null;//链表只有一个结点
//        head.sibling =head;
/*        
        node.value:1
        node.sibling.value:1
*/  
        
/*      head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
      
        head.sibling = head;//结点的sibling指向结点自身
        node2.sibling = node2;
        node4.sibling = node4;
/*      //结果
        node.value:1
        node.sibling.value:1
        node.value:2
        node.sibling.value:2
        node.value:3
        node.sibling:null
        node.value:4
        node.sibling.value:4
        node.value:5
        node.sibling:null
*/

/*        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
      
        head.sibling = node3;//两个结点的sibling形成环状结构
        node3.sibling = head;
        node2.sibling = node4;
        node4.sibling = node2;
        
/*        //结果
        node.value:1
        node.sibling.value:3
        node.value:2
        node.sibling.value:4
        node.value:3
        node.sibling.value:1
        node.value:4
        node.sibling.value:2
        node.value:5
        node.sibling:null
*/
        
        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        
        head.sibling = node3;//普通连接
        node2.sibling = node5;
        node4.sibling = node2;
        
        //结果
/*        node.value:1
        node.sibling.value:3
        node.value:2
        node.sibling.value:5
        node.value:3
        node.sibling:null
        node.value:4
        node.sibling.value:2
        node.value:5
        node.sibling:null
*/
        //ComListNode copyHead = copyComplexListByHashMap(head);
        ComListNode copyHead = copyComplexListByThree(head);
        ComListNode node = copyHead;
        while(node != null){
            System.out.println("node.value:"+node.value);
            if(node.sibling !=null)
            	System.out.println("node.sibling.value:"+node.sibling.value);
            else
            	System.out.println("node.sibling:"+node.sibling);
            node = node.next;
        }
	}
    public static ComListNode copyComplexListByHashMap(ComListNode head){
    	if(head==null)
    		return null;
    	
    	Map<ComListNode,ComListNode> nodeMap = new HashMap<ComListNode,ComListNode>();
    	ComListNode newHead = copyNodePlusMap(head, nodeMap);
    	ComListNode finalHead = copySiblingByMap(head,newHead,nodeMap);
    	return finalHead;
    }
    public static ComListNode copyNodePlusMap(ComListNode head, Map<ComListNode,ComListNode> nodeMap){
    	ComListNode node = head;
    	ComListNode newHead = null, tailNode = null;
    	while(node!=null){
    		ComListNode newNode = new ComListNode(node.value);
    		nodeMap.put(node, newNode);
    		if(newHead==null){
    			newHead = newNode;
    			tailNode = newHead;
    		}
    		else{
    			tailNode.next = node;
    			tailNode = node;
    		}
    		node = node.next;
    	}
    	return newHead;
    	
    }
    public static ComListNode copySiblingByMap(ComListNode head, ComListNode newHead, Map<ComListNode,ComListNode> nodeMap){
    	ComListNode node = head;
    	ComListNode node2 = newHead;
    	ComListNode curSibling = null;
    	while(node!=null){//建立N和N'的对应关系，也就是找到S和S'
    		curSibling = nodeMap.get(node.sibling);
    		node2.sibling = curSibling;
    		node = node.next;
    		node2 = node2.next;
    	}
    	return newHead;
    }
    
    public static ComListNode copyComplexListByThree(ComListNode head){
    	if(head==null)
    		return null;
    	cloneNodes(head);
    	connectSiblingNodes(head);
    	ComListNode newHead = reConnectNodes(head);
    	return newHead;
    }
    public static void cloneNodes(ComListNode head){
    	ComListNode node = head;
    	while(node!=null){
    		ComListNode newNode = new ComListNode(node.value);
    		newNode.next = node.next;
    		node.next = newNode;
    		node = node.next.next;
    	}
    }
    public static void connectSiblingNodes(ComListNode head){
    	ComListNode node = head, node2 = node.sibling;
    	while(node!=null){
    		node2 = node.sibling;
    		node = node.next;
    		if(node2!=null)
    			node.sibling = node2.next;
    		node = node.next;
    	}
    }
    
    public static ComListNode reConnectNodes(ComListNode head){
    	ComListNode node1 = head, newHead = null, node2 = null;
    	
        if(node1!=null){
        	newHead = node1.next;
        	node2 = node1.next;
        	node1.next = node2.next;
        	node1 = node1.next;
        }
    	while(node1!=null){
    		node2.next = node1.next;
    		node2 = node2.next;
    		node1.next = node2.next;
    		node1 = node1.next;
    	}
    	return newHead;
    }
    

}
