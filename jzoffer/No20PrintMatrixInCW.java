package JZoffer;

public class No20PrintMatrixInCW {
	public static void main(String[] args){
//		int[][] numbers= {
//				{1,2,3,4},
//				{5,6,7,8},
//				{9,10,11,12},
//				{13,14,15,16}
//		};//1 2 3 4 8 12 16 15 14 13 9 5 6 7 11 10 
		
//		int[][] numbers= {//��ӡ��Ҫ�Ĳ�
//				{1,2,3,4},
//				{5,6,7,8},
//				{9,10,11,12}
//		};//1 2 3 4 8 12 11 10 5 6 7 
		int[][] numbers= {//��ӡ��Ҫ����
				{1,2,3},
				{4,5,6}
		};//1 2 3 6 5 4 
		
//		int[][] numbers= {
//				{1,2,3},
//				{4,5,6},
//			    {7,8,9},
//			    {10,11,12}
//	    };//1 2 3 6 9 12 11 10 7 4 5 8
		
//		int[][] numbers= {//��ӡ��Ҫһ��
//				{1,2,3,4}
//		};//1 2 3 4
		
//		int[][] numbers= {//��ӡ��Ҫ����
//				{1},
//				{2},
//				{3},
//				{4}
//		};//1 2 3 4 
		
//		int[][] numbers ={{1}};//1
		
		printMatrixCW(numbers);
		
	}
	
	public static void printMatrixCW(int[][] numbers){
		if(numbers==null||numbers.length<=0||numbers[0].length<=0)
			return;
		
		int start =0;
		
		while(numbers[0].length>start*2 && numbers.length>start*2){
			printMatrixInCircle(numbers, start);
			//System.out.println("start"+start);
			start++;
		}
	}
	
	public static void printMatrixInCircle(int[][] numbers, int start){
		int endX = numbers[0].length-1-start;//����
		int endY = numbers.length-1-start;//����
		
		//�����Ҵ�ӡһ��
		//System.out.println("�����Ҵ�ӡһ��");
		for(int i=start;i<=endX;i++){
			System.out.print(numbers[start][i]+" ");
		}
		//���ϵ��´�ӡ�ұ�һ��
		//System.out.println("���ϵ��´�ӡ�ұ�һ��");
		for(int i=start+1;i<=endY;i++){//if(start<endY)��ֹ�кŴ�����ʼ�кţ��������У�����Ҫ��ӡ�ұ�һ��
			System.out.print(numbers[i][endX]+" ");
		}
		//���ҵ����ӡ����һ��
		//System.out.println("���ҵ����ӡ����һ��");
		if(start+1<=endY){//����������
			for(int i=endX-1;i>=start;i--){//����������
				System.out.print(numbers[endY][i]+" ");
			}
		}
		//���µ��ϴ�ӡ���һ��
		//System.out.println("���µ��ϴ�ӡ���һ��");
		if(start+1<=endX){//����������
			for(int i=endY-1;i>=start+1;i--){//��������
				System.out.print(numbers[i][start]+" ");
			}
		}
	}
}


