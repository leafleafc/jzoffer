package learn;

import java.util.Scanner;
import java.lang.Math;
//1.һ��ֻ����'A'��'B'��'C'���ַ������������ĳһ�γ���Ϊ3�������Ӵ���ǡ��'A'��'B'��'C'����һ������ô����ַ������Ǵ����ģ���������ַ������ǰ��ڵġ����磺
//BAACAACCBAAA �����Ӵ�"CBA"�а�����'A','B','C'��һ���������Ǵ������ַ���
//AABBCCAABB ������һ������Ϊ3�������Ӵ�����'A','B','C',�����ǰ��ڵ��ַ���
//���������Ǽ��������Ϊn���ַ���(ֻ����'A'��'B'��'C')���ж��ٸ��ǰ��ڵ��ַ�����
//һ��ţ�ʹ���Ľ�������ͼƬ
//1      2                 3
//A(A,B,C)
//���ǰ��������ͬ������ѡ��ǰ�������е�һ��+����һ����
//B(A,B,C)
//��ͬ�Ļ���ֻ��ѡ��ǰ�������е�һ��
//C(A,B,C)
//�õ���ʽ��f(n)=2f(n-1)+f(n-2)=======�����Ž���code

public class BString {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        long[] num = new long[input+1];//�˴�Ϊɶ�Ǽ�1����ΪĬ�������Ǵ�0��ʼ�ģ�������������Ļ����ϼ���1
        num[1] = 3;
        num[2] = 9;
        for(int i=3; i<=input; i++){
            num[i] = 2*num[i-1] + num[i-2];
        }
        System.out.print(num[input]);
    }
}