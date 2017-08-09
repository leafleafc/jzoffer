package JZoffer;

//http://www.cnblogs.com/keedor/p/4467040.html
//递归过程详解

public class No27BTStoOrderedList {
	
	public static void main(String[] args) {
		//完全二叉树
        BinaryNode root1 = new BinaryNode(10);
        BinaryNode node1 = new BinaryNode(6);
        BinaryNode node2 = new BinaryNode(14);
        BinaryNode node3 = new BinaryNode(4);
        BinaryNode node4 = new BinaryNode(8);
        BinaryNode node5 = new BinaryNode(12);
        BinaryNode node6 = new BinaryNode(16);
        root1.left = node1;
        root1.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;
        node2.right = node6;
        No19BinaryTreeMirror.preOrderRec(root1);
        System.out.println();
      
/*        BinaryNode root1 = new BinaryNode(10);//只有左子树
        BinaryNode node1 = new BinaryNode(6);
        BinaryNode node2 = new BinaryNode(4);
        BinaryNode node3 = new BinaryNode(2);
        root1.left = node1;
        node1.left = node2;
        node2.left = node3;
        No19BinaryTreeMirror.preOrderRec(root1);
        System.out.println();
/*		结果
 * 		10 6 4 2 
		2 4 6 10 
		10 6 4 2 
 * */
/*      BinaryNode root1 = new BinaryNode(10);//只有右子树
        BinaryNode node1 = new BinaryNode(14);
        BinaryNode node2 = new BinaryNode(16);
        BinaryNode node3 = new BinaryNode(18);
        root1.right = node1;
        node1.right = node2;
        node2.right = node3;
        No19BinaryTreeMirror.preOrderRec(root1);
        System.out.println();
/*		结果
 * 		10 14 16 18 
		10 14 16 18 
		18 16 14 10  
 * */        
/*		BinaryNode root1 = new BinaryNode(10);//只有一个结点的二叉树
/*结果	10 
		10 
*/
//		BinaryNode root1 = null;//空指针
/*结果	两个空行 
*/		
        BinaryNode headOfList = convert(root1);
        BinaryNode lastOfList = headOfList;
        while(headOfList!=null){
        	System.out.print(headOfList.data+" ");
        	headOfList = headOfList.right;
        	if(headOfList!=null && headOfList.right == null)
        		lastOfList = headOfList;
        }
        System.out.println();
        
        while(lastOfList!=null){
        	System.out.print(lastOfList.data+" ");
        	lastOfList = lastOfList.left;
        }
        System.out.println();
       
    }
	
	public static BinaryNode convert(BinaryNode root){
		BinaryNode newLastNodeInList = null;
		newLastNodeInList = convertBTStoList(root, newLastNodeInList);
		
		BinaryNode headOfList = newLastNodeInList;
		while(headOfList!=null && headOfList.left!=null){
			headOfList = headOfList.left;	
		}
		return headOfList;
	}
	
	public static BinaryNode convertBTStoList(BinaryNode root, BinaryNode lastNodeInList){
		if(root == null)
			return null;
		
		BinaryNode currentNode = root;
		BinaryNode newLastNodeInList = lastNodeInList;
		
		//中序遍历二叉排序树，依次将左子树、根、右子树连接起来，得到有序的双向链表
		//左子树不为空，递归调用convert函数，得到左子树转换后对应的双线链表的LastNode
		if(currentNode.left!=null)
			newLastNodeInList = convertBTStoList(currentNode.left, newLastNodeInList);

		//将当前根节点与转换后的链表的尾结点连接起来
		currentNode.left= newLastNodeInList;
		if(newLastNodeInList!=null)//如果尾结点不为空，尾结点的right=当前结点
			newLastNodeInList.right = currentNode;
		newLastNodeInList = currentNode;//尾结点右移一位
		
		//右子树不为空，递归调用convert函数，得到右子树转换后对应的双线链表的LastNode，即最后一个结点
		if(currentNode.right!=null)
			newLastNodeInList = convertBTStoList(currentNode.right, newLastNodeInList);
		
		return newLastNodeInList;
	} 
	
	public static BinaryNode convertBTStoListDetail(BinaryNode root, BinaryNode lastNodeInList){
		if(root == null)
			return null;
		
		BinaryNode currentNode = root;
		BinaryNode newLastNodeInList = lastNodeInList;
		
		//中序遍历二叉排序树，依次将左子树、根、右子树连接起来，得到有序的双向链表
		//左子树不为空，递归调用convert函数，得到左子树转换后对应的双线链表的LastNode
		if(currentNode.left!=null)
			newLastNodeInList = convertBTStoList(currentNode.left, newLastNodeInList);
		
		if(newLastNodeInList!=null)
			System.out.println("当前结点:"+currentNode.data+" "+"左子树转换后："+newLastNodeInList.data);
		else
			System.out.println("当前结点:"+currentNode.data+" "+"左子树转换后：null");
		
		//将当前根节点与转换后的链表的尾结点连接起来
		currentNode.left= newLastNodeInList;
		if(newLastNodeInList!=null)//如果尾结点不为空，尾结点的right=当前结点
			newLastNodeInList.right = currentNode;
		newLastNodeInList = currentNode;//尾结点右移一位
		
		if(newLastNodeInList!=null)
			System.out.println("当前结点:"+currentNode.data+" "+"连接根节点后："+newLastNodeInList.data);
		
		//右子树不为空，递归调用convert函数，得到右子树转换后对应的双线链表的LastNode，即最后一个结点
		if(currentNode.right!=null)
			newLastNodeInList = convertBTStoList(currentNode.right, newLastNodeInList);
		
		if(newLastNodeInList!=null)
			System.out.println("当前结点:"+currentNode.data+" "+"右子树转换后："+newLastNodeInList.data);
		else
			System.out.println("当前结点:"+currentNode.data+" "+"右子树转换后：null");
		
		System.out.println();
		return newLastNodeInList;
	} 

}
