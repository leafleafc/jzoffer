package JZoffer;

import java.util.HashMap;
import java.util.Map;

public class No35DeleteCharOccurInAnotherString {
	public static void main(String[] args){
		String aStr = "We are students.";
		String bStr = "aeiou";
		System.out.println("删除后的结果为："+deleteCharInAnotherString(aStr, bStr));
	}
	public static String deleteCharInAnotherString(String aStr, String bStr){
		if(aStr == null||aStr.length()==0||bStr == null||bStr.length()==0)
			return aStr;
		
		Map<Character, Boolean> charMap = new HashMap<Character, Boolean>();
		for(int i = 0; i<=bStr.length()-1; i++)
			charMap.put(bStr.charAt(i), true);
		StringBuilder cStr = new StringBuilder(aStr);
		int i=0;
		while(i<=cStr.length()-1){
			if(charMap.containsKey(cStr.charAt(i)))
				cStr.deleteCharAt(i);
			else
				i++;
		}
		return cStr.toString();
	}

}
