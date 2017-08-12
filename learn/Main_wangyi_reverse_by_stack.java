package learn;

import java.util.Scanner;
import java.util.Stack;

public class Main_wangyi_reverse_by_stack {
	public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int num[] = new int[n];
        for(int i=0; i<=n-1;i++){
        	num[i] = scanner.nextInt();
        }
		scanner.close();
	
		Stack<Integer> stack1 = new Stack<Integer>();
		Stack<Integer> stack2 = new Stack<Integer>();
		for(int i = 0; i<= num.length-1; i++){
			if( i%2 == 1){
				stack2.push(num[i]);
				if(i == num.length-1)
					break;
				while(!stack2.isEmpty()){
					stack1.push(stack2.pop());
				}
			}
			else{
				stack1.push(num[i]);
				if(i == num.length-1)
					break;
				while(!stack1.isEmpty()){
					stack2.push(stack1.pop());
				}
			}
		}
		int i = 0;
		if(num.length%2==1){
			while(!stack1.isEmpty()){
				num[i++] = stack1.pop();
			}
		}
		else{
			while(!stack2.isEmpty()){
				num[i++] = stack2.pop();
			}
		}
		i=0;
		while(i<=num.length-1){
			System.out.print(num[i++]+" ");
		}
    }

}
