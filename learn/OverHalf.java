package learn;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OverHalf {
	public static void main(String args[]){
		Scanner cin = new Scanner(System.in);
		List<Integer> mylist= new ArrayList<Integer>();
		int a,n=9, res=-1, cnt=0;
		while (n>0){
			a = cin.nextInt();
			n--;
			mylist.add(a);
			if(cnt==0){
				res =a;
				cnt++;
				System.out.println(cnt);
				//continue;
			}
			
			if(a!=res) {cnt--; System.out.println(cnt);}
			else {cnt++; System.out.println(cnt);}
			
		}
		cnt=0;
		for(int i=0; i< mylist.size(); i++){
			if(mylist.get(i)==res)
				cnt++;
		}
		System.out.println(cnt);
		if (cnt>mylist.size()/2)  
			System.out.println(res);
		
	}

}