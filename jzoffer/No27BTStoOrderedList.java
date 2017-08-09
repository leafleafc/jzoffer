package JZoffer;

//http://www.cnblogs.com/keedor/p/4467040.html
//�ݹ�������

public class No27BTStoOrderedList {
	
	public static void main(String[] args) {
		//��ȫ������
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
      
/*        BinaryNode root1 = new BinaryNode(10);//ֻ��������
        BinaryNode node1 = new BinaryNode(6);
        BinaryNode node2 = new BinaryNode(4);
        BinaryNode node3 = new BinaryNode(2);
        root1.left = node1;
        node1.left = node2;
        node2.left = node3;
        No19BinaryTreeMirror.preOrderRec(root1);
        System.out.println();
/*		���
 * 		10 6 4 2 
		2 4 6 10 
		10 6 4 2 
 * */
/*      BinaryNode root1 = new BinaryNode(10);//ֻ��������
        BinaryNode node1 = new BinaryNode(14);
        BinaryNode node2 = new BinaryNode(16);
        BinaryNode node3 = new BinaryNode(18);
        root1.right = node1;
        node1.right = node2;
        node2.right = node3;
        No19BinaryTreeMirror.preOrderRec(root1);
        System.out.println();
/*		���
 * 		10 14 16 18 
		10 14 16 18 
		18 16 14 10  
 * */        
/*		BinaryNode root1 = new BinaryNode(10);//ֻ��һ�����Ķ�����
/*���	10 
		10 
*/
//		BinaryNode root1 = null;//��ָ��
/*���	�������� 
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
		
		//����������������������ν������������������������������õ������˫������
		//��������Ϊ�գ��ݹ����convert�������õ�������ת�����Ӧ��˫�������LastNode
		if(currentNode.left!=null)
			newLastNodeInList = convertBTStoList(currentNode.left, newLastNodeInList);

		//����ǰ���ڵ���ת����������β�����������
		currentNode.left= newLastNodeInList;
		if(newLastNodeInList!=null)//���β��㲻Ϊ�գ�β����right=��ǰ���
			newLastNodeInList.right = currentNode;
		newLastNodeInList = currentNode;//β�������һλ
		
		//��������Ϊ�գ��ݹ����convert�������õ�������ת�����Ӧ��˫�������LastNode�������һ�����
		if(currentNode.right!=null)
			newLastNodeInList = convertBTStoList(currentNode.right, newLastNodeInList);
		
		return newLastNodeInList;
	} 
	
	public static BinaryNode convertBTStoListDetail(BinaryNode root, BinaryNode lastNodeInList){
		if(root == null)
			return null;
		
		BinaryNode currentNode = root;
		BinaryNode newLastNodeInList = lastNodeInList;
		
		//����������������������ν������������������������������õ������˫������
		//��������Ϊ�գ��ݹ����convert�������õ�������ת�����Ӧ��˫�������LastNode
		if(currentNode.left!=null)
			newLastNodeInList = convertBTStoList(currentNode.left, newLastNodeInList);
		
		if(newLastNodeInList!=null)
			System.out.println("��ǰ���:"+currentNode.data+" "+"������ת����"+newLastNodeInList.data);
		else
			System.out.println("��ǰ���:"+currentNode.data+" "+"������ת����null");
		
		//����ǰ���ڵ���ת����������β�����������
		currentNode.left= newLastNodeInList;
		if(newLastNodeInList!=null)//���β��㲻Ϊ�գ�β����right=��ǰ���
			newLastNodeInList.right = currentNode;
		newLastNodeInList = currentNode;//β�������һλ
		
		if(newLastNodeInList!=null)
			System.out.println("��ǰ���:"+currentNode.data+" "+"���Ӹ��ڵ��"+newLastNodeInList.data);
		
		//��������Ϊ�գ��ݹ����convert�������õ�������ת�����Ӧ��˫�������LastNode�������һ�����
		if(currentNode.right!=null)
			newLastNodeInList = convertBTStoList(currentNode.right, newLastNodeInList);
		
		if(newLastNodeInList!=null)
			System.out.println("��ǰ���:"+currentNode.data+" "+"������ת����"+newLastNodeInList.data);
		else
			System.out.println("��ǰ���:"+currentNode.data+" "+"������ת����null");
		
		System.out.println();
		return newLastNodeInList;
	} 

}
