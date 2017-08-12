package learn;

import java.util.*;
//对于一个整数X，定义操作rev(X)为将X按数位翻转过来，并且去除掉前导0。例如:
//如果 X = 123，则rev(X) = 321;
//如果 X = 100，则rev(X) = 1.
//现在给出整数x和y,要求rev(rev(x) + rev(y))为多少？

public class revString{
    public static void main(String[] args){
        Scanner reader = new Scanner(System.in);
        int x = reader.nextInt();
        int y = reader.nextInt();
        System.out.println(rev(rev(x)+rev(y)));
    }
    
    public static int rev(int x){
        StringBuffer buffer = new StringBuffer(x+"");
        buffer.reverse();
        return Integer.valueOf(buffer.toString());
    }
}

class TestDemo {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int y = sc.nextInt();
		System.out.println(rev(rev(x) + rev(y)));
	}

	// 翻转，这个数
	private static int rev(int x) {
		Integer sum = 0;
		// 把每次得到的数存入到集合中
		ArrayList<Integer> num = new ArrayList<Integer>();
		while (x > 0) {
			num.add(x % 10);
			x = x / 10;
		}
		// 判断这个集合中值是不是不止一个，如果是一个直接返回，如果是多个，计算出这个值，如果没有，返回0，这中间有去除掉前导0的功能
		if (num.size() > 1) {
			// 计算集合中的值
			for (int i = 0; i < num.size(); i++) {
				int temp = num.get(i);
				sum = i != 0 ? sum * 10 + temp : temp;
			}
		} else {
			sum = num.size() == 1 ? num.get(0) : sum;
		}
		return sum;
	}
}
