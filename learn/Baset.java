package learn;


public class Baset {
     private String baseName = "base";
     // ���췽��
     public Baset() {
         callName();
     }
     // ��Ա����
     public void callName() {
         // TODO Auto-generated method stub
         System.out.println("basename:" + baseName);
     }
   //��̬�ڲ���
     static class Sub extends Baset {//static����д�ڿ�ͷ
         // ��̬�ֶ�
         private String baseName = "sub";
         public Sub() {
             callName();
         }
         // ��д����ķ���
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