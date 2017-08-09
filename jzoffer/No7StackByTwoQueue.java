package JZoffer;

import java.util.LinkedList;
import java.util.Queue;

//因为队列是正序的，所以全部弹出再压入是没有作用的
//插入：加在非空队列之后；删除：取队列的头元素，直到队列的最后一个元素，删除这个元素
public class No7StackByTwoQueue {
	private static Queue<Object> queue1 = new LinkedList<Object>();
	private static Queue<Object> queue2 = new LinkedList<Object>();
	
	public static void push(Object item){
		if(!queue1.isEmpty())
			queue1.offer(item);
		else
			queue2.offer(item);
		System.out.println("入栈元素为："+item);
	}
	
	public static void pop(){
		if(!queue1.isEmpty()||!queue2.isEmpty()){
			if(queue2.isEmpty()){
				while(queue1.size()>1){
					queue2.offer(queue1.poll());
				}
				System.out.println("出栈元素为："+queue1.poll());
			}
			else{
				while(queue2.size()>1){
					queue1.offer(queue2.poll());
				}
				System.out.println("出栈元素为："+queue2.poll());
			}
		}
		else
			throw new RuntimeException("栈为空，无法执行出栈操作");
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
