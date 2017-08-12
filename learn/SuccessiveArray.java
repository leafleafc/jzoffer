package learn;

/*һ���������У�Ԫ��ȡֵ������0~65535�е�����һ��������ͬ��ֵ�����ظ����֣�0�����⣬���Է������֡�
�����һ���㷨������Ӹ�����������ѡȡ5����ֵ���ж���5����ֵ�Ƿ���������
ע�⣺
5����ֵ����������ġ����磺 8 7 5 0 6
0����ͨ��������ֵ�����磺8 7 5 0 6 �е�0����ͨ���9����4
0���Զ�γ��֡�
���Ӷ������O(n2)�򲻵÷֡�

����˼·��
1.ȡ5�����з�0�����������С����֮�����4������������������ 
2.Ҫ�������������� 1��ȫ0 ��������2��ֻ��һ����0������
*/

public class SuccessiveArray {
	public static void main(String[] args){
		//int[] array = {0,0,0,0,0};
		//int[] array = {0,0,0,0,100};
		//int[] array = {1,5,4,3,2};
		int[] array = {0,0, 1,2,5};
		System.out.println(judgeSuccessive(array));
	}
	
	public static boolean judgeSuccessive(int[] array){
		if(array==null||array.length!=5)
			return false;
		
		int min = array[0], max = array[0];
		int zeroCount = 0;  
		for(int i = 0; i<=array.length-1; i++){
			if(array[i] == 0)
				zeroCount++;
			if((array[i]<min&&array[i]!=0)||min==0&&array[i]>0)
				min = array[i];
			if(array[i]>max)
				max = array[i];
		}
		if(zeroCount>=4){
			return true;
		}
		else{
			if(max-min<=4)
				return true;
			else
				return false;
		}
	}

}
