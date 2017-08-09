package JZoffer;

public class No39IsBalancedTree {
	public static void main(String[] args){
		No39IsBalancedTree ibt = new No39IsBalancedTree();
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
 */      

		//二叉树所有节点都没有左子树
/*		BinaryNode root1 = new BinaryNode(1);
		BinaryNode node1 = new BinaryNode(2);
		BinaryNode node2 = new BinaryNode(3);
		BinaryNode node3 = new BinaryNode(4);
		root1.right = node1;
		node1.right = node2;
		node2.right = node3;
*/		

		//二叉树所有节点都没有右子树
/*		BinaryNode root1 = new BinaryNode(1);
		BinaryNode node1 = new BinaryNode(2);
		BinaryNode node2 = new BinaryNode(3);
		BinaryNode node3 = new BinaryNode(4);
		root1.left = node1;
		node1.left = node2;
		node2.left = node3;
*/
		//只有一个结点的二叉树
//		BinaryNode root1 = new BinaryNode(1);

/*		BinaryNode root1 = new BinaryNode(8);
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
*/
		BinaryNode root1 = null;
        System.out.println("二叉树是否为平衡的："+ibt.isBalanced(root1));
        Depth depth = new Depth();
        System.out.println("二叉树是否为平衡的："+ibt.isBalanced_2(root1,depth));
	}
	public boolean isBalanced(BinaryNode root){
		if(root == null)
			return true;
		
		No39DepthOfBinaryTree dbt = new No39DepthOfBinaryTree();
		int left = dbt.depthOfBinaryTree(root.left), 
				right = dbt.depthOfBinaryTree(root.right);
		if(left-right>1||left-right<-1)
			return false;
		
		return isBalanced(root.left)&&isBalanced(root.right);
	}
	public boolean isBalanced_2(BinaryNode root, Depth depth){
		if(root ==null){
			depth.value = 0;
			return true;
		}
		Depth left = new Depth(), right = new Depth();
		if(isBalanced_2(root.left, left)&&isBalanced_2(root.right, right)){
			int diff = left.value- right.value;
			//System.out.println("左子树层数为："+left.value);
			//System.out.println("右子树层数为："+right.value);
			//System.out.println("当前层数为："+depth.value);
			//System.out.println("当前结点为11："+root.data);
			if(diff<=1&&diff>=-1){
				depth.value = (diff>0)?(left.value+1):(right.value+1);
				return true;
			}
		}
		//System.out.println("当前结点为22："+root.data);
		return false;
	}

}
class Depth{
	public int value;
	Depth(){}
	Depth(int value){
		this.value = value;
	}
}
