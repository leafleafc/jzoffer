package JZoffer;

/*
 ����һ������s,��ӡ�����к�Ϊs�������������У����ٺ���������������������15������1+2+3+4+5=4+5+6=7+8=15�����Դ�ӡ��������������1~5,4~6,7~8��
˼·��
�ӵ���������������=��Ϊs�����õ���ʾ������Ҳ������������ָ�룬һ��ָ��ǰ���е���С������һ��ָ��ǰ������������
1����������ָ�룬һ��Ϊsmallָ��ǰ������������С������һ��Ϊbigָ��ǰ������������������
2�����ǵ�ǰ����������֮�ʹ���S����ô��С���з�Χ����smallָ�벻ͣ��ǰ�ߣ�֪������Sֹͣ��
3�����ǵ�ǰ����������֮��С��S����ô�������з�Χ����bigָ�벻ͣ��ǰ�ߣ�ֱ����ΪSֹͣ��
ע��㣺����mid��������ֵΪ(1+s)/2����Ϊ��Ϊs���������ٰ���������������smallҪС��s��һ�룻
*/
public class No41FindNumberSequenceSumAsS {
	public static void main(String[] args){
		int sum = 100;
		No41FindNumberSequenceSumAsS fns = new No41FindNumberSequenceSumAsS();
		fns.findSequenceSumAsS(sum);
	}
	public void findSequenceSumAsS(int sum){
		if(sum<3)
			return;
		
		int small = 1;
		int big = 2;
		int mid = (1+sum)/2;
		int curSum = small+big;
		while(small<mid){
			if(curSum == sum){
				for(int i=small; i<=big; i++)
					System.out.print(i+" ");
				System.out.println();
				curSum -= small;
				small++;
			}else if(curSum>sum){
				curSum -= small;
				small++;
			}
			else{
				big++;
				curSum += big;
				//System.out.println("big"+big);
			}
		}
	}

}
