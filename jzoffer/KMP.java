package JZoffer;

public class KMP {
	public static int indexOf(String source, String pattern){
		int i=0, j=0;
		char[] s = source.toCharArray();
		char[] p = pattern.toCharArray();
		int sLen = s.length;
		int pLen = p.length;
		int[] next = getNext(p);
		while(i<sLen && j<pLen){
			if(j==-1||s[i]==p[j]){
				i++;
				j++;
			}
			else
				j=next[j];
				
		}
		if(j==pLen)
			return i-j;
		else
			return -1;
	}
	
	public static int[] getNext(char[] p){
		int pLen = p.length;
		int[] next = new int[pLen];
		int k=-1, j=0;
		next[0] =-1;
		while(j<pLen-1){
			if(k==-1 || p[j]==p[k]){
				k++;
				j++;
				next[j] = k;
			}
			else
				k=next[k];
		}
		return next;
	}
	
	public static void main(String[] args){
		String s = "ABBABBBBCAB";
		String p = "BBCAB";
		System.out.println(indexOf(s,p));
		
		s = "abcdabceabcdefg";
		p = "abcdef";
		System.out.println(indexOf(s,p));
	}

}
