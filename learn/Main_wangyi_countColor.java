package learn;

import java.util.Scanner;

public class Main_wangyi_countColor {
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        System.out.print(testC(str));
	}
	public static int testC(String s){
		int count = 0;
		char a=' ';
		char b=' ';
		for(int i = 0; i < s.length(); i ++){
			if(s.charAt(i) != a && s.charAt(i) != b){
			   if(count == 0){
				  a = s.charAt(i);
				  ++ count;
			   }
			   else if(count == 1){
				   b = s.charAt(i);
				   ++ count;
			   }
			   else
				   return 0;
			}
		}
		return count;
	}
}
