package learn;


import java.util.*;

public class Main3{
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        int num[] = new int[4];
        for(int i=0; i<=3;i++){
        	num[i] = scanner.nextInt();
        }
		scanner.close();
        int ABC[] = calcu_ABC(num);
        if(ABC!=null){
            System.out.print(ABC[0]+" ");
            System.out.print(ABC[1]+" ");
            System.out.print(ABC[2]);
        }
        else
        	System.out.print("No");
    }
    private static int[] calcu_ABC(int[] num){
        int ABC[]=new int[3];
        if((num[0]+num[2])%2==0 &&(num[0]+num[2])>=0){
        	ABC[0] = (num[0]+num[2])/2;
        	//System.out.println(ABC[0]);
        } 
        else
        	return null;
        if((num[1]+num[3])%2==0 && (num[1]+num[3])>=0){
        	ABC[1] = (num[1]+num[3])/2; 
        	//System.out.println(ABC[1]);
        }
        else 
        	return null;
        if (ABC[1]-num[1] >=0){
        	ABC[2]=ABC[1]-num[1];
        	return ABC;
        }
        else 
        	return null;
            
    }
}
