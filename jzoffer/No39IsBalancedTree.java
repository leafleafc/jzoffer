package JZoffer;

public class No39IsBalancedTree {
	public static void main(String[] args){
		No39IsBalancedTree ibt = new No39IsBalancedTree();
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
        System.out.println("�������Ƿ�Ϊƽ��ģ�"+ibt.isBalanced(root1));
        Depth depth = new Depth();
        System.out.println("�������Ƿ�Ϊƽ��ģ�"+ibt.isBalanced_2(root1,depth));
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
			//System.out.println("����������Ϊ��"+left.value);
			//System.out.println("����������Ϊ��"+right.value);
			//System.out.println("��ǰ����Ϊ��"+depth.value);
			//System.out.println("��ǰ���Ϊ11��"+root.data);
			if(diff<=1&&diff>=-1){
				depth.value = (diff>0)?(left.value+1):(right.value+1);
				return true;
			}
		}
		//System.out.println("��ǰ���Ϊ22��"+root.data);
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
