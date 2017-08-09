package JZoffer;

public class No24BinarySearchTreePostOrder {
	public static void main(String[] args){
		//int[] array = {5,7,6,9,11,10,8};//��ȫ������
		//int[] array = {7,4,5,6};//���Ƕ����������ĺ����������
		//int[] array = {6,9,11,10,8};//����ȫ��������ĳ֧������Ϊ��
		//int[] array = {4,7,6,10,8};//����ȫ��������ĳ֧������Ϊ��
		//int[] array = {4,5,6,7};//ֻ��������
		int[] array = {7,6,5,4};//ֻ��������
		//int[] array = {1};//ֻ��һ�����Ķ�����
		//int[] array = null;//��ָ��
		if(array!=null)
			System.out.println(verifySequenceofBTS(array, 0, array.length-1));
		else
			System.out.println("false");
	}
	public static boolean verifySequenceofBTS(int[] array, int start, int end){
		if(array==null||array.length==0)
			return false;
		if(end-start==1)
			return true;
		if(start<0||start>array.length-1||end<0||end>array.length-1||start>end)
			throw new RuntimeException("Wrong parameters");  
		
		int root = array[end];
		int i=start;
		while(i<=end-1&&array[i]<=root){
			i++;
		}
		int j=i;//i��¼�˵�һ������root��ֵ���±�
		while(j<=end-1){
			if(array[j]<root)
				return false;
			j++;
		}
		boolean left = true;
		if(i>start)//�бȸ����С�Ľ��
			left = verifySequenceofBTS(array, start, i-1);
		
		boolean right = true;
		if(i<end)//�бȸ�����Ľ��
			 right = verifySequenceofBTS(array, i, end-1);
		
		return left&&right;
	}

}
