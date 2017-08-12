package learn;

import java.util.Scanner;
import java.math.BigInteger;
public class BigIntegerMultiply{
	public static void main(String args[]){
		Scanner cin = new Scanner(System.in);
		BigInteger a, b;

		while (cin.hasNext()){
			a = cin.nextBigInteger();
			b = cin.nextBigInteger();
			System.out.println(a.add(b).toString());
			System.out.println(a.multiply(b).toString());
		}
	}
}
