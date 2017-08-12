package learn;

public class sT { 
     class Inner {//内部类 
          private void m4t1() { 
               int i = 5; 
               while(i-- > 0) { 
                    System.out.println(Thread.currentThread().getName() + " : Inner.m4t1()=" + i); 
                    try { 
                         Thread.sleep(500); 
                    } catch(InterruptedException ie) { 
                    } 
               } 
          } 
          private void m4t2() { 
               int i = 5; 
               while(i-- > 0) { 
                    System.out.println(Thread.currentThread().getName() + " : Inner.m4t2()=" + i); 
                    try { 
                         Thread.sleep(500); 
                    } catch(InterruptedException ie) { 
                    } 
               } 
          }
          private synchronized void innerFunc(){
        	  System.out.println("I'm innerFunc!");
        	  //sT.this.outFuc();
          }
     } 
     private void m4t1(Inner inner) { 
          synchronized(Inner.class) { //使用对象锁 
          inner.m4t1();
          }
     } 
     private void m4t2(Inner inner) { 
    	 //synchronized(Inner.class) { //使用对象锁 
          inner.m4t2(); 
    	 //}
     } 
     private void outFuc(){
    	 System.out.println("I'm outFunc!");
     }
     public static void main(String[] args) { 
          final sT myt3 = new sT();//final 不可变 
          final Inner inner = myt3.new Inner(); 
          Thread t1 = new Thread( new Runnable() {public void run() { myt3.m4t1(inner);} }, "t1");
          
          Thread t2 = new Thread( new Runnable() {public void run() { myt3.m4t2(inner);} }, "t2"); //重写Runnable的run
          t1.start();
          t2.start();
          //Thread t3 = new Thread( new Runnable() {public void run() { inner.innerFunc();} }, "t3"); //重写Runnable的run
          //t3.start();
          //System.out.println(sT.class);
          //System.out.println(Inner.class);
  } 
}
