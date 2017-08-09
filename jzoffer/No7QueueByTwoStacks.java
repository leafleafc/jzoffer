package JZoffer;

import java.util.Stack;

public class No7QueueByTwoStacks {
	private static Stack<Object> stack1 = new Stack<Object>();
	private static Stack<Object> stack2 = new Stack<Object>();
	
	//����Ԫ�أ����뵽ջ1��
	public static void appendTail(Object item){
		stack1.push(item);
		System.out.println("����е�Ԫ�أ�"+item);
	}
	//ɾ��Ԫ�أ�ջ2�Ƿ�Ϊ�գ���Ϊ�գ��򵯳�ջ��Ԫ�أ�
	//Ϊ�գ�զ��ջ1 ��Ԫ�ض�ѹ��ջ2��Ȼ���ٵ���ջ��Ԫ��.
	public static void deleteHead(){
		if(!stack2.isEmpty()){
			System.out.println("�����е�Ԫ�أ�"+stack2.pop());
		}
		else{
			if(stack1.isEmpty())
				throw new RuntimeException("����Ϊ��");
			while(!stack1.isEmpty()){
				stack2.push(stack1.pop());
			}
			System.out.println("�����е�Ԫ�أ�"+stack2.pop());
		}
	}
	
	public static void main(String[] args){
		//����
		//��յĶ��������Ԫ��
        appendTail(1);
        //��ǿյĶ��������Ԫ��
        appendTail(2);
        appendTail(3);
        //�ӷǿյĶ�����ɾ��Ԫ��
        deleteHead();
        deleteHead();
        appendTail(4);
        deleteHead();
        appendTail(5);
        deleteHead();
        deleteHead();
        //deleteHead();
	}

}
