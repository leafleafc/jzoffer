package JZoffer;

public class No4ReplaceSpace {
	public static void main(String[] args){
		 String string1="We are happy.";
		 String string2=" We  are happy. ";
		 String string3="Wearehappy.";
		 //String string4=null;
		 String string5="";
		 String string6=" ";
		 String string7="    ";
		 System.out.println(replaceSpace(string1.toCharArray()));
		 System.out.println(replaceSpace(string2.toCharArray()));
		 System.out.println(replaceSpace(string3.toCharArray()));
	     //System.out.println(replace('\0'));
		 System.out.println(replaceSpace(string5.toCharArray()));
		 System.out.println(replaceSpace(string6.toCharArray()));
		 System.out.println(replaceSpace(string7.toCharArray()));
		 
		 System.out.println(replaceSpace(new StringBuffer(string1)));
	     System.out.println(replaceSpace(new StringBuffer(string2)));
	     System.out.println(replaceSpace(new StringBuffer(string3)));
	     //System.out.println(replaceSpace(new StringBuffer(string4)));
	     System.out.println(replaceSpace(new StringBuffer(string5)));
	     System.out.println(replaceSpace(new StringBuffer(string6)));
	     System.out.println(replaceSpace(new StringBuffer(string7)));
	}
	
	public static char[] replaceSpace(char[] string){
		if(string == null)
			return null;
		int originalLength = string.length;
		int spaceCount = 0;
		
		for(int i =0; i<= string.length-1; i++)
			if(string[i] == ' ')
				spaceCount++;
		
		int newLength = originalLength+spaceCount*2;
	    char[] temp = new char[newLength];
		int i = originalLength-1, j = newLength-1;
		while(i>=0){ // && newLength>originalLength){
			if(string[i] == ' '){
				temp[j--]='0';
				temp[j--]='2';
				temp[j--]='%';
//				string[j--]='0';
//				string[j--]='2';
//				string[j--]='%'; 
				//java的数组会记录数组的大小，不能改变；c++里面的字符数组可以直接访问，没有固定长度，以'\0'结尾
			}
			else
				//string[j--]='0';
				temp[j--]=string[i];
			i--;
		}
		//return string;
		return temp;
		
	}
	
	/*
     * 时间复杂度为O(n)，利用StringBuffer实现
     * 通过indexOf(String str,int fromIndex)方法和subSequence(int start,int end)方法联合实现
     */
    public static String replaceSpace(StringBuffer str){
        if(str==null)
            return null;
        int fromIndex=0;
        int index=0;
        StringBuffer temp =new StringBuffer();
        while(index<=str.length()){
            index=str.indexOf(" ",fromIndex);
            if(index>=0){
                temp.append(str.subSequence(fromIndex, index)).append("%20");
                index=index+1;
                fromIndex=index;
            }else{
                temp.append(str.substring(fromIndex, str.length()));
                break;
            } 
        }
        return temp.toString();
    }

}
