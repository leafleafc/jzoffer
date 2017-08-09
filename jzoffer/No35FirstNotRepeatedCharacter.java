package JZoffer;

import java.util.HashMap;
import java.util.Map;

public class No35FirstNotRepeatedCharacter {
	public static void main(String[] args){
		String str = "aabcddc";
		str = "";
		str = null;
		str = "aabbccddeeff";
		findFirstNotRepeatedChar(str);
	}
	public static void findFirstNotRepeatedChar(String str){
		if(str == null||str.length()==0)
			return;
		char ch = findChar(str);
		if(ch == '\0')
			System.out.println("没有只出现一次的字符");
		else
			System.out.println("第一个只出现一次的字符为："+ch);
	}
	public static char findChar(String str){
		if(str == null||str.length()==0)
			return '\0';
		Map<Character, Integer> charMap = new HashMap<Character, Integer>();
		for(int i=0; i<=str.length()-1; i++){
			if(charMap.containsKey(str.charAt(i)))
				charMap.put(str.charAt(i), charMap.get(str.charAt(i))+1);
			else
				charMap.put(str.charAt(i), 1);
		}
		for(int i=0; i<=str.length()-1; i++){
			if(charMap.get(str.charAt(i))==1)
				return str.charAt(i);
		}
		return '\0';
	}
}
