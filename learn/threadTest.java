package learn;

/**
 * java�е�sleep()��wait()������
 * @author Hongten
 * @date 2013-12-10
 */
public class threadTest {

    public static void main(String[] args) {
    	
    	Thread t1 = new Thread(new Thread1(), "t1");
    	Thread t2 = new Thread(new Thread2(), "t2");
    	Thread t3 = new Thread(new Thread3(), "t3");
    	/*��HotSpot VM�ϣ�����������Ĵ����д����
    	 * ��ʵtt.m2()�������ǻ��Test2.run()Ҫ���类���ã�
    	 * ��ΪThread.start()�ڵ��ã�caller���߳��ϴ������߳̾ͷ����ˣ�
    	 * �����žͿ���ȥ����ִ��tt.m2()��
    	 * ���ڱ����ã�callee�������߳��ϻ�Ҫ����һЩJVM�ڲ��ĳ�ʼ�����������ܵ���ָ������ڷ���
    	 * �Ⲣ����Java���Թ淶����JVM�淶��Ҫ�����Ϊ��
    	 * ֻ����HotSpot VM�����ض�ʵ���ϻ���������������
    	 * ���ԼȲ�Ӧ�õ�����׼��Ϊȥ������Ҳ��Ҫ��Ϊ�淶ûҪ����ܾ�����ʵ������������������
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
//    	new Thread(new Thread2()).start();//��new��ʱ��start()���������߳�
//        System.out.println("222222222222222");
//    	
//    	
//    	new Thread(new Thread3()).start();
//    	System.out.println("33333333333333");
    	
        
        //���������̣߳���ͬʱִ�д�������������
    	t3.start();
    	t1.start();
    	t2.start();//�����߳�ͬʱ����Ҳ��һ���� t2������ִ�У�Ȼ��t1��ִ�� ��t1�ͻ�һֱ����
    	
/*		�����߳�ͬʱ������CPU���ȵ�˳���������
    	t3.start();
    	t1.start();
    	t2.start();
    	name:t1,���ȼ���5
    	name:t3,���ȼ���5
    	name:t2,���ȼ���5
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
    	//�Ƚ�������߳�2
    	name:t2,���ȼ���5
    	enter thread2....
    	thread2 starts sleeping....
    	name:t1,���ȼ���5//�߳�1
    	name:t3,���ȼ���5//�߳�3
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
    	//�����߳�3
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
    	//�����߳�1 �����޷���ȡ����������һֱ����
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
        	System.out.println("name:"+Thread.currentThread().getName()+",���ȼ���"+ Thread.currentThread().getPriority());
            synchronized (threadTest.class) {
        	//synchronized (Thread1.class) {
	            System.out.println("enter thread1...");    
	            //System.out.println("thread1 is waiting...");
	            try {
	                //����wait()�������̻߳����������������ȴ��˶���ĵȴ�������
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
        	System.out.println("name:"+Thread.currentThread().getName()+",���ȼ���"+ Thread.currentThread().getPriority());
            synchronized (threadTest.class) {
                System.out.println("enter thread2....");
               
                //ֻ����Դ˶������notify()�������̲߳Ž������������׼����ȡ��������������״̬��
                threadTest.class.notify();
                //==================
                //����
                //������ǰѴ��룺TestD.class.notify();��ע�͵�����TestD.class������wait()����������û�е���notify()
                //���������߳���Զ���ڹ���״̬��
                try {
                    //sleep()���������˳�����ִͣ��ָ����ʱ�䣬�ó�cpu�������̣߳�
                    //�������ļ��״̬��Ȼ�����ߣ���ָ����ʱ�䵽���ֻ��Զ��ָ�����״̬��
                    //�ڵ���sleep()�����Ĺ����У��̲߳����ͷŶ�������
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
        	System.out.println("name:"+Thread.currentThread().getName()+",���ȼ���"+ Thread.currentThread().getPriority());
            synchronized (threadTest.class) {
                System.out.println("enter thread3....");
               
                try {
                    //sleep()���������˳�����ִͣ��ָ����ʱ�䣬�ó�cpu�������̣߳�
                    //�������ļ��״̬��Ȼ�����ߣ���ָ����ʱ�䵽���ֻ��Զ��ָ�����״̬��
                    //�ڵ���sleep()�����Ĺ����У��̲߳����ͷŶ�������
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
