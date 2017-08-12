package learn;
import java.util.*;

//栈操作，vector操作
public class Stacks {
	static String[] months = {"January", "Febuary", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
	
	public static void main(String[] args){
		Stack stk = new Stack();
		System.out.println(months.length);
		for (int i=0; i<months.length; i++){
			stk.push(months[i]+" ");
		}
		System.out.println("stk = "+stk);
		System.out.println(stk.getClass());
		
		//把栈当作一个vector
		stk.addElement("The last line");
		System.out.println("element 0 = "+ stk.elementAt(0));
		System.out.println("popping elements:");
		while(!stk.empty()){
			System.out.println(stk.pop());
		}
		String str = "test";
		System.out.println(str.length());
		
		Vector vq = new Vector();
		for (int i=0; i<months.length; i++){
			vq.addElement(months[i]);
		}
		System.out.println(vq.capacity());
		System.out.println(vq.firstElement());
		System.out.println(vq.lastElement());
		vq.clear();
	}

}
