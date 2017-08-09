package JZoffer;

import java.util.Scanner;

public class No28StringPermutation {
	public static void main(String[] args){
		Scanner inner = new Scanner(System.in);
		while(inner.hasNext()){
			String line = inner.nextLine();
			char[] str = line.toCharArray();
//			char[] str = new char[line.length()];
//			for(int i=0; i<=line.length()-1; i++){
//				str[i] = line.charAt(i);
//			}
			permutation(str);
		}
		inner.close();
	}
	public static void permutation(char[] str){
		if(str == null)
			return;
		permutation(str, 0);
	}
	public static void permutation(char[] str, int begin){
		if(begin==str.length)
			System.out.println(str);
		else{
			for(int i=begin; i<=str.length-1;i++){
					if(hasBeenSwaped(str, begin, i)){
						char tmp = str[begin];
						str[begin]=str[i];
						str[i] = tmp;
					
						permutation(str, begin+1);
					
						tmp = str[begin];
						str[begin]=str[i];
						str[i] = tmp;
					}
			}
			
		}
	}
	//�жϵ�ǰ"i"�����ַ��Ƿ�֮ǰ�Ѿ����ֹ������ֹ��򷵻�false��������
	public static boolean hasBeenSwaped(char[] str, int begin, int i){
        for(int k = begin; k<=i-1;k++)
            if(str[k] == str[i])
                return false;
        return true;
    }

}
/*
 * ��һ��if(begin==i||str[begin]!=str[i])
 * abaa�Ľ�����£�
 �̶�a:
abaa
b�͵�һ��a������
�̶�aa,�����ba��ba��ab���ֽ��
aaba
aaab
b�͵ڶ���a������
�̶�aa,�����ab��ba��ab���ֽ��
aaab
aaba
��һ��a��b�������̶�b��
baaa
���������޷������ظ���ĸ
 * */

//http://blog.csdn.net/baidu_22405691/article/details/51325385
//���ظ��ַ����ַ�����ȫ�������⣨Java��
