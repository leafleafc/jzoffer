package learn;


import java.util.Scanner;

public class Maxyueshu {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            System.out.println(sumOfMaxOdd(n));
        }
    }

    /*
     * ���������Լ�����Ǳ����������������f(i), iΪż���ĺ� ��ΪҪ����������Լ��������f(2k) = f(k)������f(2) + f(4)
     * + ... + f(2k) = f(1) + f(2) + ... + f(k);
     * 
     * sum(n) = sum (n / 2) + 1 + 3 + ... + n - 1 = sum (n/2) + n*n/4��n Ϊż���� 
     *        
     *        = sum (n - 1) + n ��nΪ������
     * 
     * 
     */

    public static long sumOfMaxOdd(long n) {
        if (n == 1) {
            return 1;
        }
        if (n % 2 == 0) {
            return sumOfMaxOdd(n / 2) + n * n / 4;
        } else {
            return sumOfMaxOdd(n - 1) + n;
        }
    }

}