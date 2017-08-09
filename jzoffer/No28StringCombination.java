package JZoffer;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

public class No28StringCombination {
	public static void main(String[] args){
		Scanner inner = new Scanner(System.in);
		Set<String> comSet = new HashSet<String>();
		while(inner.hasNext()){
			String line = inner.nextLine();
			char[] str = line.toCharArray();
//			char[] str = new char[line.length()];
//			for(int i=0; i<=line.length()-1; i++){
//				str[i] = line.charAt(i);
//			}
			combination(str, comSet);
			for(String comStr: comSet){
				System.out.println(comStr);
			}
		}
		inner.close();
	}
	public static void combination(char[] str, Set<String> comSet){
		if(str==null||str.length ==0)
			return;
		
		Stack<Character> stack = new Stack<Character>();
		for(int i=1;i<=str.length;i++){
			combination(str,0,i,stack, comSet);
		}
	}
	
	public static void combination(char[] str, int begin, int number, Stack<Character> stack, Set<String> comSet){
		if(number==0){
			//System.out.println(stack.toString());
			comSet.add(stack.toString());
			return;
		}
		
		if(begin == str.length){
			return;
		}
		
		stack.push(str[begin]);
		combination(str, begin+1, number-1,stack, comSet);
		stack.pop();
		combination(str, begin+1, number, stack, comSet);
	}

}
