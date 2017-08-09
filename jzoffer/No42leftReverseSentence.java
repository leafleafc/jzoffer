package JZoffer;

public class No42leftReverseSentence {
	public static void main(String[] args){
		char[] str ="abcdefg".toCharArray();
		No42leftReverseSentence lfr = new No42leftReverseSentence();
		lfr.reverseSentenseByLeft(str, -1);
		System.out.println(str);
	}
	public void reverse(char[] str, int start, int end){
		if(str == null || str.length == 0|| start<0 || end> str.length-1|| start>end)
			return; 
		while(start<end){
			char tmp = str[start];
			str[start] = str[end];
			str[end] = tmp;
			start++;
			end--;
		}
	}
	public void reverseSentenseByLeft(char[] str, int left){
		if(str == null|| str.length<=1|| left<=0 || left>str.length-1)
			return;
		reverse(str, 0, left-1);
		reverse(str, left, str.length-1);
		reverse(str, 0, str.length-1);
	}

}
