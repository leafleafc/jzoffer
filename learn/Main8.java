package learn;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main8 {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		List<Integer> aList = new ArrayList<Integer>();
        List<Integer> bList = new ArrayList<Integer>();

        int m;
        m = Integer.parseInt(in.nextLine().trim());
        for(int i=0; i<=m-1;i++){
        	aList.add(Integer.parseInt(in.nextLine().trim()));
        }
        int n;
        n = Integer.parseInt(in.nextLine().trim());
        
        for(int i=0; i<=n-1;i++){
        	bList.add(Integer.parseInt(in.nextLine().trim()));
        }
        
		in.close();
		
		boolean ret = bList.retainAll(aList);
        //if(ret){
        	System.out.println("b " + bList.size());
        	//System.out.println("求交集成功");
        	for (int res_i = 0; res_i < bList.size(); res_i++) {
    			System.out.print(bList.get(res_i)+" ");
    		}
        	
        //}
        //else
        //	System.out.println("没有需要修改的元素");
    }

}
