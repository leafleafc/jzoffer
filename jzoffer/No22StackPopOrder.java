package JZoffer;

import java.util.Stack;
/*
* 问题描述：输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出序列。假设压入栈的所有数字均不相等。
* 例如序列1/2/3/4/5是某栈的压栈序列，序列4/5/3/2/1是该压栈序列对应的一个弹出序列，但4/3/5/1/2就不可能是该压栈序列的弹出序列
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
			if(!stackData.isEmpty()&&stackData.peek()==pop_array[i]){//栈顶不空且相等
				stackData.pop();
				i++;
			}
			else if(!stackData.isEmpty()&&stackData.peek()!=pop_array[i]){//枕顶部空不相等
				while(j<=push_array.length-1&&stackData.peek()!=pop_array[i]){//压栈直到栈顶等于当前弹栈元素
					stackData.push(push_array[j]);
					j++;
				}
				if(stackData.peek()==pop_array[i]){//相等的
					stackData.pop();
					i++;
				}
				else//入栈序列都压完还是没有相等的
					break;
			}
			else if(j<=push_array.length-1){//栈顶空且压栈序列未结束
				stackData.push(push_array[j]);
				j++;
			}
			else//压栈序列结束
		    	break;
		}
		if(i==j&&i==push_array.length)
			ret = true;
		return ret;
	}

}
