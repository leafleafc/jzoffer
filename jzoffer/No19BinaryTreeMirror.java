package JZoffer;

public class No19BinaryTreeMirror {
	public static void main(String[] args) {
		//功能测试
		//普通二叉树
/*		BinaryNode root1 = new BinaryNode(1);
        BinaryNode node1 = new BinaryNode(2);
        BinaryNode node2 = new BinaryNode(3);
        BinaryNode node3 = new BinaryNode(4);
        BinaryNode node4 = new BinaryNode(5);
        BinaryNode node5 = new BinaryNode(6);
        BinaryNode node6 = new BinaryNode(7);
        root1.left = node1;
        root1.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;
        node2.right = node6;
        preOrderRec(root1);//1 2 4 5 3 6 7 
        mirrorByRec(root1);
        preOrderRec(root1);//1 3 7 6 2 5 4 
*/
		//二叉树所有节点都没有左子树
/*		BinaryNode root1 = new BinaryNode(1);
		BinaryNode node1 = new BinaryNode(2);
		BinaryNode node2 = new BinaryNode(3);
		BinaryNode node3 = new BinaryNode(4);
		root1.right = node1;
		node1.right = node2;
		node2.right = node3;
		mirrorByRec(root1);
		preOrderRec(root1);
*/
		//二叉树所有节点都没有右子树
/*		BinaryNode root1 = new BinaryNode(1);
		BinaryNode node1 = new BinaryNode(2);
		BinaryNode node2 = new BinaryNode(3);
		BinaryNode node3 = new BinaryNode(4);
		root1.left = node1;
		node1.left = node2;
		node2.left = node3;
		mirrorByRec(root1);
		preOrderRec(root1);
*/
		//只有一个结点的二叉树
/*		BinaryNode root1 = new BinaryNode(1);
		mirrorByRec(root1);
		preOrderRec(root1);
*/		
		//较复杂的二叉树
        BinaryNode root1 = new BinaryNode(8);
        BinaryNode node1 = new BinaryNode(8);
        BinaryNode node2 = new BinaryNode(7);
        BinaryNode node3 = new BinaryNode(9);
        BinaryNode node4 = new BinaryNode(2);
        BinaryNode node5 = new BinaryNode(4);
        BinaryNode node6 = new BinaryNode(7);
        root1.left = node1;
        root1.right = node2;
        node1.left = node3;
        node1.right = node4;
        node4.left = node5;
        node4.right = node6;
        mirrorByRec(root1);
        preOrderRec(root1);//8 7 8 2 7 4 9 
	}
	
	public static void mirrorByRec(BinaryNode root){
		if(root==null)
			return;
		if(root.left==null&&root.right==null)
			return;
		
		BinaryNode temp = root.left;
		root.left = root.right;
		root.right = temp;
		
		if(root.left!=null)
			mirrorByRec(root.left);
		if(root.right!=null)
			mirrorByRec(root.right);
	}
	
	public static void preOrderRec(BinaryNode root){
		if(root!=null){
			System.out.print(root.data+" ");
			preOrderRec(root.left);
			preOrderRec(root.right);
		}
	}
}
