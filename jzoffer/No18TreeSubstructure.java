package JZoffer;

class BinaryNode{
	public int data;
	public BinaryNode left;
	public BinaryNode right;
	public BinaryNode(int data){
		this.data=data;
		this.left=null;
		this.right=null;
	}
	
}

public class No18TreeSubstructure {//这个需要重新写一遍
	public static void main(String[] args) {
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
        
        BinaryNode root2 = new BinaryNode(8);
        BinaryNode a = new BinaryNode(9);
        BinaryNode b = new BinaryNode(2);
        root2.left = a;
        root2.right = b;
        
        System.out.println(hasSubtree(root1, root2));
    }
	
	public static boolean hasSubtree(BinaryNode root1, BinaryNode root2){
		boolean result = false;
		if(root1!=null&&root2!=null){
			if(root1.data==root2.data)
				result = doesTree1HaveTree2(root1,root2);
			if(!result)
				result = hasSubtree(root1.left, root2);
			if(!result)
				result = hasSubtree(root1.right, root2);
		}
		return result;
	}
	
	public static boolean doesTree1HaveTree2(BinaryNode root1, BinaryNode root2){
		if(root2==null)
			return true;
		if(root1==null)
			return false;
		if(root1.data!=root2.data)
			return false;
		
		return doesTree1HaveTree2(root1.left, root2.left) &&
				doesTree1HaveTree2(root1.right, root2.right);
	}
}
