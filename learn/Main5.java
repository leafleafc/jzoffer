package learn;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main5 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			int res = 0;
			char[] arr = sc.next().toCharArray();
			for(int i = 0; i < arr.length - 1; i++){
				Set<Character> set = new HashSet<Character>();
				set.add(arr[i]);
				for(int j = i + 1; j < arr.length; j++){
					if(set.contains(arr[j]))
						set.remove(arr[j]);
					else
						set.add(arr[j]);
					if(((j - i + 1) & 1) == 1) continue;
					res += set.size() == 0 ? 1 : 0;
				}
			}
			System.out.println(res);
		}
		
	}
}
