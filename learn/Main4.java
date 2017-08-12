package learn;

import java.util.Scanner;
import java.math.BigDecimal;
import java.text.DecimalFormat;   

public class Main4 {
	public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        int n=0,result=0;
        n=scanner.nextInt();
        int x=0, p=0;
        for(int i=0; i<n;i++){
        	x=scanner.nextInt();
        	p=scanner.nextInt();
        	result+=x*p;
        }
		scanner.close();
		double f_result= result/100.0;
		BigDecimal  b   =   new   BigDecimal(f_result);  
		double   f1   =   b.setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue();  
		String sf1 = String.format("%.3f",f1);
	    System.out.print(sf1);
    }
}
