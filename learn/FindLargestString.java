package learn;
import java.util.*;

public class FindLargestString {
	
	public static String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0) return "";
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = nums[i]+"";
        }
        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String i, String j) {
                String s1 = i+j;
                String s2 = j+i;
//                System.out.println(s1);
//                System.out.println(s2);
//                System.out.println(s1.compareTo(s2));
//                return s1.compareTo(s2);
                return s2.compareTo(s1);
            }
        });
//        System.out.println(strs[strs.length-1].charAt(0));
//        if (strs[strs.length-1].charAt(0) == '0') return "0";
        if (strs[0].charAt(0) == '0') return "0";
        String res = new String();
        for (int i = 0; i < strs.length; i++) {
        	System.out.println(strs[i]);
            res = res+strs[i];
        }
        return res;
    }
	public static void main(String[] args){
		int[] test ={0,4,10};
		
		System.out.println(largestNumber(test));
	}
	

}
