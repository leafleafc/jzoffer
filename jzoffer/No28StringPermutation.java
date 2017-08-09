package JZoffer;

import java.util.Scanner;

public class No28StringPermutation {
	public static void main(String[] args){
		Scanner inner = new Scanner(System.in);
		while(inner.hasNext()){
			String line = inner.nextLine();
			char[] str = line.toCharArray();
//			char[] str = new char[line.length()];
//			for(int i=0; i<=line.length()-1; i++){
//				str[i] = line.charAt(i);
//			}
			permutation(str);
		}
		inner.close();
	}
	public static void permutation(char[] str){
		if(str == null)
			return;
		permutation(str, 0);
	}
	public static void permutation(char[] str, int begin){
		if(begin==str.length)
			System.out.println(str);
		else{
			for(int i=begin; i<=str.length-1;i++){
					if(hasBeenSwaped(str, begin, i)){
						char tmp = str[begin];
						str[begin]=str[i];
						str[i] = tmp;
					
						permutation(str, begin+1);
					
						tmp = str[begin];
						str[begin]=str[i];
						str[i] = tmp;
					}
			}
			
		}
	}
	//判断当前"i"处的字符是否之前已经出现过，出现过则返回false，不交换
	public static boolean hasBeenSwaped(char[] str, int begin, int i){
        for(int k = begin; k<=i-1;k++)
            if(str[k] == str[i])
                return false;
        return true;
    }

}
/*
 * 加一句if(begin==i||str[begin]!=str[i])
 * abaa的结果如下：
 固定a:
abaa
b和第一个a交换：
固定aa,后面的ba有ba和ab两种结果
aaba
aaab
b和第二个a交换：
固定aa,后面的ab有ba和ab两种结果
aaab
aaba
第一个a与b交换，固定b：
baaa
这样还是无法避免重复字母
 * */

//http://blog.csdn.net/baidu_22405691/article/details/51325385
//含重复字符的字符串的全排列问题（Java）
