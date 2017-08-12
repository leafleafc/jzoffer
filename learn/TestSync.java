package learn;

public class TestSync implements Runnable {


	Timer timer = new Timer();
	public static void main(String[] args) {
		TestSync testSync = new TestSync();
		Thread t1 = new Thread(testSync);
		Thread t2 = new Thread(testSync);
		Thread t3 = new Thread(testSync);
		t1.setName("t1");
		t2.setName("t2");
		t3.setName("t3");
		
		
		t2.start();
		t3.start();
		t1.start();
	}
	
	public void run() {
		timer.add(Thread.currentThread().getName());
	}
}


class Timer {
	private static int num = 0;
	//public void add(String name) {
	public synchronized void add(String name) {//执行这个方法的过程中当前对象被锁定
		synchronized (this) {//锁定当前对象
			System.out.println(Thread.currentThread().getName());
			this.notify();
			num++;
			System.out.println(name + "你是第" + num + "个使用Timer的线程");
			
			try {
				System.out.println(Thread.currentThread().getName()+" is trying to wait");
				//Thread.sleep(20);
				this.wait();
			} catch (InterruptedException e) { 
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+" stopped waiting");
			this.notify();
		}
	}
}
