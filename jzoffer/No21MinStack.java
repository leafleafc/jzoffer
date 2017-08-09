package JZoffer;

public class No21MinStack{
	public MyStack<Integer> dataStack = new MyStack<Integer>();
	public MyStack<Integer> minStack = new MyStack<Integer>();
	
	public void push(Integer data){
		dataStack.push(data);
		if(minStack==null)
			return;//throw new RuntimeException("Wrong Stack");
		if(minStack.head!=null){
			if(minStack.head.value>data)
				minStack.push(data);
			else
				minStack.push(minStack.head.value);
		}
		else
			minStack.push(data);
	}
	
	public Integer pop(){
		if(dataStack == null||minStack==null||dataStack.head == null||minStack.head==null)
			return null;
		minStack.pop();
		return dataStack.pop();
	}
	
	public Integer min(){
		if(minStack == null|| minStack.head==null)
			return null;
		return minStack.head.value;
	}
	
	public static void main(String[] args){
		No21MinStack myMinStack = new No21MinStack();
		myMinStack.push(3);
		myMinStack.push(4);
		myMinStack.push(2);
		myMinStack.push(1);
		while(myMinStack.dataStack.head!=null){
			System.out.println("min:"+myMinStack.min());
			System.out.println("top:"+myMinStack.pop());
		}
		System.out.println("min:"+myMinStack.min());
		System.out.println("top:"+myMinStack.pop());
	}

}

class Node<K>{
	public K value;
	public Node<K> next;
	
	public Node(K node){
		this.value = node;
		this.next = null;
	}	
}

class MyStack<K>{
	public Node<K> head;
	
	public void push(K data){
		Node<K> newNode = new Node<K>(data);
		newNode.next = this.head;
		this.head = newNode;
	}
	
	public K pop(){
		if(head == null)
			return null;
		
		K top = head.value;
		head = head.next;
		return top;
	}
}


