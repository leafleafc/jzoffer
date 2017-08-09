package JZoffer;

/*
 输入一个正数s,打印出所有和为s的连续正数序列（至少含有两个数）。例如输入15，由于1+2+3+4+5=4+5+6=7+8=15；所以打印出三个连续序列1~5,4~6,7~8；
思路：
从递增数组中两个何=和为s的数得到启示，我们也可以设置两个指针，一个指向当前序列的最小的数，一个指向当前序列最大的数。
1）设置两个指针，一个为small指向当前正数序列中最小的数，一个为big指向当前正数序列中最大的数；
2）若是当前的正数序列之和大于S，那么缩小序列范围，让small指针不停往前走，知道等于S停止；
3）若是当前的正数序列之和小于S，那么扩大序列范围，让big指针不停往前走，直到和为S停止；
注意点：设置mid变量，赋值为(1+s)/2，因为何为s的序列至少包括两个数，所以small要小于s的一半；
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
