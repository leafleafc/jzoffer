package learn;

public class lTest {
	public static void main(String[] args){
		
//		System.out.println("AAA"+1);
//		System.out.println("A"+1);
//		System.out.println(1+2+"");
//		System.out.println(""+1+2);
//		System.out.println('A'+1);
//		System.out.println('a'+1);
//		System.out.println("330".compareTo("303"));
        String s1 = "aabbc";
        String s2 = new String("aabbc");
        String s3 = "aa"+ "bbc";
        String s4 = "aa"+ new String("bbc");
        System.out.println(s1==s2);
        System.out.println(s1==s3);
        System.out.println(s1==s4);
        
        System.out.println(s1.equals(s2));
        System.out.println(s1.equals(s3));
        System.out.println(s1.equals(s4));
	} 

}
