package JZoffer;

public class No39DepthOfBinaryTree {
	public static void main(String[] args){
		No39DepthOfBinaryTree dbt = new No39DepthOfBinaryTree();
		//���ܲ���
		//��ͨ������
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

		//���������нڵ㶼û��������
/*		BinaryNode root1 = new BinaryNode(1);
		BinaryNode node1 = new BinaryNode(2);
		BinaryNode node2 = new BinaryNode(3);
		BinaryNode node3 = new BinaryNode(4);
		root1.right = node1;
		node1.right = node2;
		node2.right = node3;
*/		

		//���������нڵ㶼û��������
/*		BinaryNode root1 = new BinaryNode(1);
		BinaryNode node1 = new BinaryNode(2);
		BinaryNode node2 = new BinaryNode(3);
		BinaryNode node3 = new BinaryNode(4);
		root1.left = node1;
		node1.left = node2;
		node2.left = node3;
*/
		//ֻ��һ�����Ķ�����
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
        System.out.println("�����������Ϊ��"+dbt.depthOfBinaryTree(root1));
	}

	public int depthOfBinaryTree(BinaryNode root){
		if(root == null)
			return 0;
		int nLeft = depthOfBinaryTree(root.left);
		int nRight = depthOfBinaryTree(root.right);
		
		return (nLeft > nRight)? (nLeft+1):(nRight+1);
	}
}
