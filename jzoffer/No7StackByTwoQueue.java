package JZoffer;

import java.util.LinkedList;
import java.util.Queue;

//��Ϊ����������ģ�����ȫ��������ѹ����û�����õ�
//���룺���ڷǿն���֮��ɾ����ȡ���е�ͷԪ�أ�ֱ�����е����һ��Ԫ�أ�ɾ�����Ԫ��
public class No7StackByTwoQueue {
	private static Queue<Object> queue1 = new LinkedList<Object>();
	private static Queue<Object> queue2 = new LinkedList<Object>();
	
	public static void push(Object item){
		if(!queue1.isEmpty())
			queue1.offer(item);
		else
			queue2.offer(item);
		System.out.println("��ջԪ��Ϊ��"+item);
	}
	
	public static void pop(){
		if(!queue1.isEmpty()||!queue2.isEmpty()){
			if(queue2.isEmpty()){
				while(queue1.size()>1){
					queue2.offer(queue1.poll());
				}
				System.out.println("��ջԪ��Ϊ��"+queue1.poll());
			}
			else{
				while(queue2.size()>1){
					queue1.offer(queue2.poll());
				}
				System.out.println("��ջԪ��Ϊ��"+queue2.poll());
			}
		}
		else
			throw new RuntimeException("ջΪ�գ��޷�ִ�г�ջ����");
	}
	
	public static void main(String[] args){
		push(1);
		push(2);
		push(3);
		pop();
		push(4);
		pop();
		pop();
		pop();
		//pop();
	}

}
