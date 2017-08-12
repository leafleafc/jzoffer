package learn;

import java.util.Scanner;

public class tets {

    public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		//System.out.println("请输入算术表达式：   ");
		while (scanner.hasNext()) {
			String str=scanner.next();
			System.out.println(calcu_my(str));
		}
	}
    private static int calcu_my(String str){
    	int result =0;
    	int i1 = 0,i2=0;
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (c>='0'&&c<='9') {
				//System.out.println("i:"+i);
				String str2=c+"";
				i1 = Integer.valueOf(str2.toString());
				//System.out.println(i1);
				result += i1;
			}
			else{
				//System.out.println("i:"+i);
				int j=++i;
				String str3=str.charAt(j)+"";
				//System.out.println(str3);
				i2 = Integer.valueOf(str3.toString());
				switch (c) {
				case '+':
					result=result+i2;
					break;
				case '-':
					result=result-i2;
					break;
				case '*':
					result=result*i2;
					break;
				default:
					break;
				}
				
			}

		}
		return result;
    }
}
