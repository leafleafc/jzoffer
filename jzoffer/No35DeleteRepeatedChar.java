package JZoffer;

import java.util.ArrayList;
import java.util.List;

public class No35DeleteRepeatedChar {
	public String deleteChar(String str){
		if(str == null|| str.length()<=1)
			return str;
		
		List<Character> charList = new ArrayList<Character>();
		for(int i=0; i<=str.length()-1; i++){
			if(charList.contains(str.charAt(i))==false)
				charList.add(str.charAt(i));
		}
		StringBuilder ret = new StringBuilder("");
		StringBuffer ret2 = new StringBuffer("");
		for(int i=0; i<=charList.size()-1; i++)
			ret.append(charList.get(i));
		return ret.toString();
	}
	public static void main(String[] args){
		No35DeleteRepeatedChar delete = new No35DeleteRepeatedChar();
		String str = "google";
		str = null;
		str = "";
		str = "abcdabcdacbd    acf";
		System.out.println(delete.deleteChar(str));
	}
	

}
