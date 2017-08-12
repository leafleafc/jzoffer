package learn;


import java.util.Scanner;

public class Mian6 {
	public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        int n=0,result=0;
        n=scanner.nextInt();
        scanner.nextLine();
        String myStr1= scanner.nextLine();
        StringBuilder myStr = new StringBuilder(myStr1);
        scanner.close();
        
        for(int i=0; i<myStr.length(); i++){
        	if(myStr.charAt(i) != 'X' && myStr.charAt(i) != '#' ){
        		int police =i;
        		int police_pow = Integer.parseInt(""+myStr.charAt(i));
        		int start=0,end =0;
        		start= (police-police_pow)>0?(police-police_pow):0;
        		end = (police+police_pow)<(myStr.length()-1)?(police+police_pow):(myStr.length()-1);
        		for(int j=start; j<=end; j++){
        			if(myStr.charAt(j)=='X'){
        				result++;
        				myStr.setCharAt(j,'#');
        			}
        		}
        	}
        	
        }
       
	    System.out.print(result);
    }
}
