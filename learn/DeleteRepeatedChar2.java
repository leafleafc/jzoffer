package learn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class DeleteRepeatedChar2 {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		System.out.println("ÇëÊäÈë×Ö·û´®£º");
		String str = in.nextLine();
		DeleteRepeatedChar2 myChar = new DeleteRepeatedChar2();
		System.out.println(myChar.deleteChar(str));
	}
	
	public String deleteChar(String inStr){
		//Map<Character, Boolean> fMap = new HashMap<Character, Boolean>();
		List<Character> fList = new ArrayList<Character>();
		String sRet = new String();
		sRet = "";
		for(int i=0; i<= inStr.length()-1; i++){
			//boolean fRet = fMap.containsKey(inStr.charAt(i));
			boolean fRet = fList.contains(inStr.charAt(i));
			if(fRet == false){
				//fMap.put(inStr.charAt(i),fRet);
				fList.add(inStr.charAt(i));
				sRet += inStr.charAt(i);
			}
		}
		return sRet;
	} 
}
