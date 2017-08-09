package JZoffer;

public class No42ReverseWords {
	public static void main(String[] args){
		No42ReverseWords rw = new No42ReverseWords();
		//char[] str = "I'm a student.".toCharArray();
		//char[] str = "      abcd efg    ".toCharArray();
		//char[] str = "abc".toCharArray();
		//char[] str = null;
		String s_no_content = "";
		char[] str = s_no_content.toCharArray();
		System.out.print(str);
		System.out.print("aaaaaa");
		rw.reverseWords(str);
		if(str!=null)
			System.out.println(str);
		else
			System.out.println("×Ö·û´®Îªnull");
	}
	public void reverseWords(char[] str){
		if(str == null|| str.length <=1)
			return;
		int start = 0, end =str.length-1;
		reverseSingleWord(str,start,end);
		start = end =0;
		while(start<=str.length-1&&end<=str.length-1){
			if(str[start]==' '){
				start++;
				end++;
			}
			else if(str[end]==' '){
				reverseSingleWord(str, start, end-1);
				start = end++;
			}
			else if(end == str.length-1){
				reverseSingleWord(str, start, end);
				start = end++;
			}
			else
				end++;
		}
	}
	public void reverseSingleWord(char[] word, int start, int end){
		if(word == null || word.length == 0|| start<0 || end> word.length-1|| start>end)
			return;
		while(start<end){
			char tmp = word[start];
			word[start] = word[end];
			word[end] = tmp;
			start++;
			end--;
		}
	}

}
