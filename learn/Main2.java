package learn;

import java.util.*;


public class Main2{
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int num = scanner.nextInt();
            System.out.println(calcu_buy(num));
        }
    }
    private static int calcu_buy(int num){
        int x=0, y=0;
        if (num%2 !=0) return -1;
        num/=2;
        for(x=0;3*x<=num;x++){
            y = (int) ((num -3*x)/4);
            if((3*x+4*y)==num){
                return x+y;
            }
        }
        return -1;
    }
}
