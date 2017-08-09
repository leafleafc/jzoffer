package JZoffer;

import java.util.HashMap;
import java.util.Map;

public class MapTest {
	public static void main(String[] args){
		Map<Character, Integer> charMap = new HashMap<Character, Integer>();
		String aStr = "abcdab";
		for(int i=0; i <= aStr.length()-1; i++){
			if(charMap.containsKey(aStr.charAt(i)))
				charMap.put(aStr.charAt(i), charMap.get(aStr.charAt(i))+1);
			else
				charMap.put(aStr.charAt(i), 1);
		}
		System.out.println("Map的大小为："+charMap.values().size());
		for(Integer value:charMap.values()){
			System.out.print(value);		
		}
		System.out.println();
		
		Map<Character, Integer> charMap2 = new HashMap<Character, Integer>();
		charMap2.put('a', 1);
		charMap2.put('b', 1);
		charMap2.put('c', 1);
		charMap2.put('d', 1);
		System.out.println("Map的大小为："+charMap2.values().size());
		for(Integer value:charMap2.values()){
			System.out.print(value);		
		}
	}

}
