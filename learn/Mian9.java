package learn;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Mian9 {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

        int m;
        m = Integer.parseInt(in.nextLine().trim());
        int[] aList = new int[m];
        for(int i=0; i<=m-1;i++){
        	aList[i] = Integer.parseInt(in.nextLine().trim());
        }
        int n;
        n = Integer.parseInt(in.nextLine().trim());
        int[] bList = new int[n];
        
        for(int i=0; i<=n-1;i++){
        	bList[i] = Integer.parseInt(in.nextLine().trim());
        }
		in.close();
		
		List<Integer> rList = new ArrayList<Integer>();
		for (int i = 0; i < bList.length; i++) {
            for (int j = 0; j < aList.length; j++) {
                if (bList[i] == aList[j]) {
                    rList.add(bList[i]);
                    break;
                }
            }
        }
		
        for (int res_i = 0; res_i < rList.size(); res_i++) {
    			System.out.print(rList.get(res_i)+" ");
    	}
        	
        
    }

}
