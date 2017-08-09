package JZoffer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Test {
	public static void main(String[] args) {
		int[] num = {1,2,3,4,5,5};
		for(int i:num){
			System.out.print(i+" ");
		}
		
		System.out.println(containsDuplicate(num));
		
		Map<String, Integer> cMap = new HashMap<String, Integer>();
		cMap.put("abc",3);
		cMap.put("abcde", 5);
		cMap.put("abcdefghijk", 11);
		cMap.put("bc",2);
		cMap.put("c",1);
		
		List<String> cList = new ArrayList<String>();
		for(String str: cMap.keySet()) {
			cList.add(str);
		}
		Collections.sort(cList);
		for(String str: cList){
			System.out.println("key:"+str+",value:"+cMap.get(str));
		}
		Iterator<Map.Entry<String, Integer>> it = cMap.entrySet().iterator();
		while(it.hasNext()){
			Map.Entry<String, Integer> entry = it.next();
			System.out.println("key:"+entry.getKey()+",value:"+entry.getValue());
		}
		
		//Set<Map.Entry<String, Integer>> keySet = cMap.entrySet();
		
		for(String str: cMap.keySet()){
			System.out.println("key:"+str+",value:"+cMap.get(str));
		}
	}
	
	public static boolean containsDuplicate(int[] num){
		Set<Integer> numSet = new HashSet<Integer>();
		for(int i:num){
			if(numSet.contains(i))
				return true;
			else
				numSet.add(i);
		}
		return false;
	} 

}
