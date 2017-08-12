package learn;

/**
 * java中的sleep()和wait()的区别
 * @author Hongten
 * @date 2013-12-10
 */
public class threadTest {

    public static void main(String[] args) {
    	
    	Thread t1 = new Thread(new Thread1(), "t1");
    	Thread t2 = new Thread(new Thread2(), "t2");
    	Thread t3 = new Thread(new Thread3(), "t3");
    	/*在HotSpot VM上，按照链接里的代码的写法，
    	 * 其实tt.m2()几乎总是会比Test2.run()要更早被调用，
    	 * 因为Thread.start()在调用（caller）线程上创建好线程就返回了，
    	 * 紧接着就可以去调用执行tt.m2()；
    	 * 而在被调用（callee）的新线程上还要经过一些JVM内部的初始化动作才能跑到您指定的入口方法
    	 * 这并不是Java语言规范或者JVM规范所要求的行为，
    	 * 只是在HotSpot VM这种特定实现上会有这样的特征，
    	 * 所以既不应该当作标准行为去依赖，也不要因为规范没要求而拒绝承认实现中有这样的特征。
    	 */
    	
    	
//    	try {
//	     	System.out.println("Thread starts sleep ******");
//	        Thread.sleep(5000);
//	        System.out.println("Thread stops sleep ******");
//	    } catch (Exception e) {
//	         e.printStackTrace();
//	    }
    	
//    	new Thread(new Thread1()).start();
//    	System.out.println("11111111111111");
//    	
//    	new Thread(new Thread2()).start();//在new的时候start()依次三个线程
//        System.out.println("222222222222222");
//    	
//    	
//    	new Thread(new Thread3()).start();
//    	System.out.println("33333333333333");
    	
        
        //启动三个线程，将同时执行创建的三个任务
    	t3.start();
    	t1.start();
    	t2.start();//两个线程同时启动也是一样的 t2可能先执行，然后t1再执行 ，t1就会一直挂起
    	
/*		三个线程同时启动，CPU调度的顺序是随机的
    	t3.start();
    	t1.start();
    	t2.start();
    	name:t1,优先级：5
    	name:t3,优先级：5
    	name:t2,优先级：5
    	enter thread1...
    	thread1 enters waiting
    	enter thread2....
    	thread2 starts sleeping....
    	thread2 stops sleeping....
    	Thread2:0
    	Thread2:1
    	Thread2:2
    	Thread2:3
    	Thread2:4
    	Thread2:5
    	Thread2:6
    	Thread2:7
    	Thread2:8
    	Thread2:9
    	Thread2:10
    	thread2 is going on....
    	thread2 is over!!!
    	enter thread3....
    	thread3 starts sleeping....
    	thread3 stops sleeping....
    	Thread3:0
    	Thread3:1
    	Thread3:2
    	Thread3:3
    	Thread3:4
    	Thread3:5
    	Thread3:6
    	Thread3:7
    	Thread3:8
    	Thread3:9
    	Thread3:10
    	thread3 is going on....
    	thread3 is over!!!
    	thread1 stops waiting...
    	thread1 is going on ....
    	Thread1:0
    	Thread1:1
    	Thread1:2
    	Thread1:3
    	Thread1:4
    	Thread1:5
    	Thread1:6
    	Thread1:7
    	Thread1:8
    	Thread1:9
    	Thread1:10
    	thread1 is over!!!
*/
/* 		t3.start();
    	t1.start();
    	t2.start();
    	//先进入的是线程2
    	name:t2,优先级：5
    	enter thread2....
    	thread2 starts sleeping....
    	name:t1,优先级：5//线程1
    	name:t3,优先级：5//线程3
    	thread2 stops sleeping....
    	Thread2:0
    	Thread2:1
    	Thread2:2
    	Thread2:3
    	Thread2:4
    	Thread2:5
    	Thread2:6
    	Thread2:7
    	Thread2:8
    	Thread2:9
    	Thread2:10
    	thread2 is going on....
    	thread2 is over!!!
    	//进入线程3
    	enter thread3....
    	thread3 starts sleeping....
    	thread3 stops sleeping....
    	Thread3:0
    	Thread3:1
    	Thread3:2
    	Thread3:3
    	Thread3:4
    	Thread3:5
    	Thread3:6
    	Thread3:7
    	Thread3:8
    	Thread3:9
    	Thread3:10
    	thread3 is going on....
    	thread3 is over!!!
    	//进入线程1 由于无法获取对象锁，会一直挂起
    	enter thread1...
    	thread1 enters waiting
*/   	
/*        System.out.println("Thread sleep ????");
        try {
        	System.out.println("Thread starts sleep ******");
            Thread.sleep(5000);
            System.out.println("Thread stops sleep ******");
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Thread2 to be started......");
        new Thread(new Thread2()).start();*/
    }
    
    private static class Thread1 implements Runnable{
        @Override
        public void run(){
        	System.out.println("name:"+Thread.currentThread().getName()+",优先级："+ Thread.currentThread().getPriority());
            synchronized (threadTest.class) {
        	//synchronized (Thread1.class) {
	            System.out.println("enter thread1...");    
	            //System.out.println("thread1 is waiting...");
	            try {
	                //调用wait()方法，线程会放弃对象锁，进入等待此对象的等待锁定池
	            	System.out.println("thread1 enters waiting");
	            	threadTest.class.wait();
	            	//Thread1.class.wait();
	            	System.out.println("thread1 stops waiting...");
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	            System.out.println("thread1 is going on ....");
	            for(int i =0;i<=10;i++){
                	System.out.println("Thread1:"+i);
                }
	            System.out.println("thread1 is over!!!");
            }
        }
    }
    
    private static class Thread2 implements Runnable{
        @Override
        public void run(){
        	System.out.println("name:"+Thread.currentThread().getName()+",优先级："+ Thread.currentThread().getPriority());
            synchronized (threadTest.class) {
                System.out.println("enter thread2....");
               
                //只有针对此对象调用notify()方法后本线程才进入对象锁定池准备获取对象锁进入运行状态。
                threadTest.class.notify();
                //==================
                //区别
                //如果我们把代码：TestD.class.notify();给注释掉，即TestD.class调用了wait()方法，但是没有调用notify()
                //方法，则线程永远处于挂起状态。
                try {
                    //sleep()方法导致了程序暂停执行指定的时间，让出cpu该其他线程，
                    //但是他的监控状态依然保持者，当指定的时间到了又会自动恢复运行状态。
                    //在调用sleep()方法的过程中，线程不会释放对象锁。
//                	System.out.println("thread2 starts sleeping....");
//                    Thread.sleep(5000);
//                    System.out.println("thread2 stops sleeping....");
                    for(int i =0;i<=10;i++){
                    	System.out.println("Thread2:"+i);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println("thread2 is going on....");
                System.out.println("thread2 is over!!!");
            }
        }
    }
    
    private static class Thread3 implements Runnable{
        @Override
        public void run(){
        	System.out.println("name:"+Thread.currentThread().getName()+",优先级："+ Thread.currentThread().getPriority());
            synchronized (threadTest.class) {
                System.out.println("enter thread3....");
               
                try {
                    //sleep()方法导致了程序暂停执行指定的时间，让出cpu该其他线程，
                    //但是他的监控状态依然保持者，当指定的时间到了又会自动恢复运行状态。
                    //在调用sleep()方法的过程中，线程不会释放对象锁。
                	System.out.println("thread3 starts sleeping....");
                    Thread.sleep(5000);
                    System.out.println("thread3 stops sleeping....");
                    for(int i =0;i<=10;i++){
                    	System.out.println("Thread3:"+i);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println("thread3 is going on....");
                System.out.println("thread3 is over!!!");
            }
        }
    }
}
