package JZoffer;

import java.util.Stack;

public class No7QueueByTwoStacks {
	private static Stack<Object> stack1 = new Stack<Object>();
	private static Stack<Object> stack2 = new Stack<Object>();
	
	//加入元素：加入到栈1中
	public static void appendTail(Object item){
		stack1.push(item);
		System.out.println("入队列的元素："+item);
	}
	//删除元素：栈2是否为空，不为空，则弹出栈顶元素；
	//为空，咋把栈1 的元素都压入栈2，然后再弹出栈顶元素.
	public static void deleteHead(){
		if(!stack2.isEmpty()){
			System.out.println("出队列的元素："+stack2.pop());
		}
		else{
			if(stack1.isEmpty())
				throw new RuntimeException("队列为空");
			while(!stack1.isEmpty()){
				stack2.push(stack1.pop());
			}
			System.out.println("出队列的元素："+stack2.pop());
		}
	}
	
	public static void main(String[] args){
		//测试
		//向空的队列中添加元素
        appendTail(1);
        //向非空的队列中添加元素
        appendTail(2);
        appendTail(3);
        //从非空的队列中删除元素
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
