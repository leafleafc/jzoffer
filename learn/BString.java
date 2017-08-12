package learn;

import java.util.Scanner;
import java.lang.Math;
//1.一个只包含'A'、'B'和'C'的字符串，如果存在某一段长度为3的连续子串中恰好'A'、'B'和'C'各有一个，那么这个字符串就是纯净的，否则这个字符串就是暗黑的。例如：
//BAACAACCBAAA 连续子串"CBA"中包含了'A','B','C'各一个，所以是纯净的字符串
//AABBCCAABB 不存在一个长度为3的连续子串包含'A','B','C',所以是暗黑的字符串
//你的任务就是计算出长度为n的字符串(只包含'A'、'B'和'C')，有多少个是暗黑的字符串。
//一个牛客大神的解析，如图片
//1      2                 3
//A(A,B,C)
//如果前两个数相同，则能选择前两个数中的一个+另外一个数
//B(A,B,C)
//不同的话，只能选择前两个数中的一个
//C(A,B,C)
//得到公式：f(n)=2f(n-1)+f(n-2)=======》接着进行code

public class BString {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        long[] num = new long[input+1];//此处为啥是加1，因为默认数组是从0开始的，所以在这个数的基础上加了1
        num[1] = 3;
        num[2] = 9;
        for(int i=3; i<=input; i++){
            num[i] = 2*num[i-1] + num[i-2];
        }
        System.out.print(num[input]);
    }
}