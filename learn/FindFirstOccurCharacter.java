package learn;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FindFirstOccurCharacter {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
	    System.out.println("�������ַ���:");
		String str = in.nextLine();
		FindFirstOccurCharacter myDele = new FindFirstOccurCharacter();
		int ret = myDele.findChar(str);
		if(ret == -1)
			System.out.println("û��ֻ����һ�ε��ַ�");
		else
			System.out.println("��һ��ֻ����һ�ε��ַ�Ϊ��"+str.charAt(ret)+"���ֵ�λ��Ϊ��"+(ret+1));
		
		char cRet = '\u0000';//��ʾ�ַ���ʼ��Ϊ��
		System.out.println(cRet);
		//System.out.println(('\0'=='\u0000'));//true
		//System.out.println(( 0 =='\u0000'));//true
		//System.out.println(( '0' =='\u0000'));//false
		cRet = myDele.findOnlyChar(str);
		if(cRet == '\0')
			System.out.println("û��ֻ����һ�ε��ַ�");
		else
			System.out.println("��һ��ֻ����һ�ε��ַ�Ϊ��"+cRet);
	}
	
	public int findChar(String inStr){
		Map<Character, Boolean> fMap = new HashMap<Character, Boolean>();
		for(int i=0; i<= inStr.length()-1; i++){
			boolean fRet = fMap.containsKey(inStr.charAt(i));
			fMap.put(inStr.charAt(i),fRet);
			//System.out.println(inStr.charAt(i)+" "+fRet);
		}
		for(int i=0; i<= inStr.length()-1; i++){
			if(fMap.get(inStr.charAt(i)) == false)
				return i;
		}
		return -1;
	}
	public char findOnlyChar(String inStr){
	    //��Map�����ҵ���һ��false 
	    Map<Character, Boolean> fMap = new LinkedHashMap<Character, Boolean>();
	    for(int i=0; i<= inStr.length()-1; i++){
			boolean fRet = fMap.containsKey(inStr.charAt(i));
			fMap.put(inStr.charAt(i),fRet);
			//System.out.println(inStr.charAt(i)+" "+fRet);
		}
	    Iterator<Map.Entry<Character, Boolean>> iterator = fMap.entrySet().iterator();
		while(iterator.hasNext()){
			Map.Entry<Character, Boolean> fEntry = iterator.next();
			if(fEntry.getValue() == false)
				return fEntry.getKey();
		}
		return '\0';
	}

}
