package learn;

import java.util.*;


public class Main10{
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        System.out.println(calcu(n,a,b,c));
    }
    private static int calcu(int num, int a ,int b, int c){
        int x=0, y=0, z=0;
        int res = 0;
        int m1,m2=0;
        if (num<5) return 0;
        m1 = 0;
        for(x=0;m1<=num && x<=a;x++){
        	m1 = 5*x;
        	m2=0;
        	for(y=0;m2<=num && y<=b;y++){
        		m2 = 8*y+m1;
                z = (int) ((num -m2)/10);
                if((10*z+m2)==num && z<=c)
                    res ++;
            }
        }
        return res;
    }
}