package learn;

import java.util.Scanner;

public class Main_wangyi_reverse {
	public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int num[] = new int[n];
        int result[] = new int[n];
        for(int i=0; i<=n-1;i++){
        	num[i] = scanner.nextInt();
        }
		scanner.close();
		
		if(num.length%2==0){
			int j = 0;
			for(int i = num.length-1; i>=1; i=i-2, j++){
				result[j] = num[i];
			}
			for(int i = 0; i<=num.length-2; i=i+2, j++){
				result[j] = num[i];
			}
		}
		else{
			int j = 0;
			for(int i = num.length-1; i>=0; i=i-2, j++){
				result[j] = num[i];
			}
			for(int i = 1; i<=num.length-2; i=i+2, j++){
				result[j] = num[i];
			}
		}
		
		int i=0;
		while(i<=result.length-1){
			System.out.print(result[i++]+" ");
		}
	
	}

}
