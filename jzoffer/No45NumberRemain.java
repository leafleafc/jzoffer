package JZoffer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class No45NumberRemain {
	public static void main(String[] args){
		int n = 5;
		int m = 3;
		No45NumberRemain nr = new No45NumberRemain();
		System.out.println(nr.numberRemainInCircle(n,m));
	}
	public int numberRemainInCircle(int n, int m){
		if(n<1||m<1)
			return -1;
		
		List<Integer> list = new ArrayList<Integer>();
		for(int i=0; i<=n-1;i++){
			list.add(i);
		}
		int current = 0;
		int currentSize = n;
		Iterator<Integer> it = list.iterator();
		while(currentSize>1){
			for(current=1; current<=m; current++){
				if(it.hasNext())
					it.next();
				else{
					it = list.iterator();
					it.next();
				}
			}
			it.remove();
			currentSize--;
		}
		it = list.iterator();
		return it.next();
	}

}
