package learn;


public class Baset {
     private String baseName = "base";
     // 构造方法
     public Baset() {
         callName();
     }
     // 成员方法
     public void callName() {
         // TODO Auto-generated method stub
         System.out.println("basename:" + baseName);
     }
   //静态内部类
     static class Sub extends Baset {//static必须写在开头
         // 静态字段
         private String baseName = "sub";
         public Sub() {
             callName();
         }
         // 重写父类的方法
         public void callName() {
             System.out.println("subname:" + baseName);
         }
     }
 
     public static void main(String[] args) {
         Baset base0 = new Baset();
    	 Baset base = new Sub();
         Sub sub = new Sub();
     }
 }