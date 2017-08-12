package learn;

import java.util.Scanner;

public class CirclePoint {
	public static void main(String args[]){
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()){
			int r2 = scanner.nextInt();
			System.out.println(solve(r2));
		}
		scanner.close();
	} 
	
	private static int solve(int r2){
		int count = 0;
		for (int x=1; x*x<=r2; x++){
			int x2 =x*x;
			int y = (int) Math.sqrt(r2-x2);
			if(y*y + x2 == r2){
				++count;
			}
		}
		return count*4;
	}
}
