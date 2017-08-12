package learn;

import java.util.*;
//����һ������X���������rev(X)Ϊ��X����λ��ת����������ȥ����ǰ��0������:
//��� X = 123����rev(X) = 321;
//��� X = 100����rev(X) = 1.
//���ڸ�������x��y,Ҫ��rev(rev(x) + rev(y))Ϊ���٣�

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

	// ��ת�������
	private static int rev(int x) {
		Integer sum = 0;
		// ��ÿ�εõ��������뵽������
		ArrayList<Integer> num = new ArrayList<Integer>();
		while (x > 0) {
			num.add(x % 10);
			x = x / 10;
		}
		// �ж����������ֵ�ǲ��ǲ�ֹһ���������һ��ֱ�ӷ��أ�����Ƕ������������ֵ�����û�У�����0�����м���ȥ����ǰ��0�Ĺ���
		if (num.size() > 1) {
			// ���㼯���е�ֵ
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
