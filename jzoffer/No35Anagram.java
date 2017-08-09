package JZoffer;

import java.util.HashMap;
import java.util.Map;

public class No35Anagram {
	public boolean judgeAnagram(String aStr, String bStr){
		if(aStr==null||bStr == null||aStr.length()!=bStr.length())
			return false;
		if(aStr.length()==0&&bStr.length()==0)
			return true;
		
		Map<Character, Integer> charMap = new HashMap<Character, Integer>();
		for(int i=0; i <= aStr.length()-1; i++){
			if(charMap.containsKey(aStr.charAt(i)))
				charMap.put(aStr.charAt(i), charMap.get(aStr.charAt(i))+1);
			else
				charMap.put(aStr.charAt(i), 1);
		}
		for(int i=0; i <= bStr.length()-1; i++){
			if(charMap.containsKey(bStr.charAt(i)))
				charMap.put(bStr.charAt(i), charMap.get(bStr.charAt(i))-1);
			else
				return false;
		}
		for(Integer value:charMap.values()){
			if(value!=0)
				return false;
		}
		return true;
	}
	public static void main(String[] args){
		String aStr = "slient";
		String bStr = "listen";
		aStr = "";
		bStr = "";
		aStr = "evil";
		bStr = "live";
		aStr = "";
		bStr = "abcd";
		aStr = "abcd";
		bStr = "";
		aStr = "abcd";
		bStr = "abcf";
		No35Anagram an = new No35Anagram();
		System.out.println(an.judgeAnagram(aStr, bStr));
	}

}
