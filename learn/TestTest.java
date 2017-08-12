package learn;


public class TestTest {

public static void test(String str) {
	   System.out.println(str);
       str = "World"; 
       
       
  } 
public static void test(StringBuffer str) {
	
	System.out.println(str);
    str = new StringBuffer("World"); 
    str.append("World");
} 

public static void test(String[] str) {
	   System.out.println(str[0]);
    str[0] = "World"; 
    
    
} 

  public static void main(String[] args) {

       String string = new String("Hello");
       StringBuffer stringB = new StringBuffer("Hello");
       String[] str1 = new String[1];
       str1[0] = "Helloooo";
       
       test(string);  
       test(stringB);
       test(str1);

     System.out.println(string);
     System.out.println(stringB);
     System.out.println(str1[0]);
     }

}