package JZoffer;

import java.util.Stack;
/*
* �������������������������У���һ�����б�ʾջ��ѹ��˳�����жϵڶ��������Ƿ�Ϊ��ջ�ĵ������С�����ѹ��ջ���������־�����ȡ�
* ��������1/2/3/4/5��ĳջ��ѹջ���У�����4/5/3/2/1�Ǹ�ѹջ���ж�Ӧ��һ���������У���4/3/5/1/2�Ͳ������Ǹ�ѹջ���еĵ�������
*/

public class No22StackPopOrder {
	public static void main(String[] args){
		int[] push_array = {1,2,3,4,5};
		int[] pop_array = {4,5,3,2,1};
		//int[] pop_array = {4,3,5,1,2};
		//int[] pop_array = {3,2,1,4,5};
		//System.out.println(isPopOrder(push_array, pop_array));
		System.out.println(isPopOrderS(push_array, pop_array));
		
		int[] a = new int[0];
		int[] b = new int[0];
		System.out.println(a.length);
		//System.out.print(a[0]);//Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: 0
							   //at JZoffer.No22StackPopOrder.main(No22StackPopOrder.java:20)
		System.out.println(isPopOrderS(a, b));
		
		int[] c = {1};
		int[] d = {1};
		System.out.println(isPopOrderS(c, d));
		System.out.println(isPopOrderS(null, null));
	}
	
	public static boolean isPopOrderS(int[] push_array, int[] pop_array){
		if(push_array == null|| pop_array == null||push_array.length<=0|| pop_array.length<=0||push_array.length != pop_array.length)
			return false;
		boolean ret = false;
		Stack<Integer> stackData = new Stack<Integer>();
		
		int i=0,j=0;
		while(i<=pop_array.length-1){
			if(!stackData.isEmpty()&&stackData.peek()==pop_array[i]){
				stackData.pop();
				i++;
			}
			else{
				if(j==push_array.length)
					break;
				do{
					stackData.push(push_array[j]);
					j++;
				}while(!stackData.isEmpty()&&stackData.peek()!=pop_array[i]);
				if(stackData.peek()==pop_array[i]){
					stackData.pop();
					i++;
				}
				else
					break;
			}
		}
		if(i==j&&i==pop_array.length)
			ret=true;
		return ret;
	}
	public static boolean isPopOrder(int[] push_array, int[] pop_array){
		if(push_array == null|| pop_array == null||push_array.length<=0|| pop_array.length<=0||push_array.length != pop_array.length)
			return false;
		boolean ret = false;
		
		Stack<Integer> stackData = new Stack<Integer>();
		int i=0,j=0;
		while(i<=pop_array.length-1){
			if(!stackData.isEmpty()&&stackData.peek()==pop_array[i]){//ջ�����������
				stackData.pop();
				i++;
			}
			else if(!stackData.isEmpty()&&stackData.peek()!=pop_array[i]){//�����ղ����
				while(j<=push_array.length-1&&stackData.peek()!=pop_array[i]){//ѹջֱ��ջ�����ڵ�ǰ��ջԪ��
					stackData.push(push_array[j]);
					j++;
				}
				if(stackData.peek()==pop_array[i]){//��ȵ�
					stackData.pop();
					i++;
				}
				else//��ջ���ж�ѹ�껹��û����ȵ�
					break;
			}
			else if(j<=push_array.length-1){//ջ������ѹջ����δ����
				stackData.push(push_array[j]);
				j++;
			}
			else//ѹջ���н���
		    	break;
		}
		if(i==j&&i==push_array.length)
			ret = true;
		return ret;
	}

}
