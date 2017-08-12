package learn;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;


public class TestReadWriteLock {
         public static void main(String[] args) {
                 //�����������ʵ��˻�
                 MyCount myCount = new MyCount("95599200901215522", 10000);
                 //����һ��������
                 ReadWriteLock lock = new ReentrantReadWriteLock(false);
                 //����һ���̳߳�
                 ExecutorService pool = Executors.newFixedThreadPool(2);
                 //����һЩ���������û���һ�����ÿ�����Ĵ棬ȡ��ȡ�������ְ�
                 User u1 = new User("����", myCount, -4000, lock, false);
                 User u2 = new User("��������", myCount, 6000, lock, false);
                 User u3 = new User("��������", myCount, -8000, lock, false);
                 User u4 = new User("����", myCount, 800, lock, false);
                 User u5 = new User("��������", myCount, 0, lock, true);
                 User u6 = new User("����", myCount, 0, lock, true);
                 //���̳߳���ִ�и����û��Ĳ���
                 pool.execute(u1);
                 pool.execute(u2);
                 pool.execute(u5);
                 pool.execute(u6);
                 pool.execute(u3);
                 pool.execute(u4);
                 
                 //�ر��̳߳�
                 pool.shutdown();
         }
}


class User implements Runnable {
         private String name;                 //�û���
         private MyCount myCount;         //��Ҫ�������˻�
         private int iocash;                 //�����Ľ���Ȼ������֮����
         private ReadWriteLock myLock;                 //ִ�в��������������
         private boolean ischeck;         //�Ƿ��ѯ

         User(String name, MyCount myCount, int iocash, ReadWriteLock myLock, boolean ischeck) {
                 this.name = name;
                 this.myCount = myCount;
                 this.iocash = iocash;
                 this.myLock = myLock;
                 this.ischeck = ischeck;
         }

         public void run() {
                 if (ischeck) {
                	 try{
                         //��ȡ����
                         myLock.readLock().lock();
                         System.out.println("����" + name + "���ڲ�ѯ" + myCount + "�˻�����ǰ���Ϊ" + myCount.getCash());
                     }
                	 finally{
                         //�ͷŶ���
                         myLock.readLock().unlock();
                     }
                 } else {
                	 try{
                         //��ȡд��
                         myLock.writeLock().lock();
                         //ִ���ֽ�ҵ��
                         System.out.println("д��" + name + "���ڲ���" + myCount + "�˻������Ϊ" + iocash +"����ǰ���Ϊ" + myCount.getCash());
                         myCount.setCash(myCount.getCash() + iocash);
                         System.out.println("д��" + name + "����" + myCount + "�˻��ɹ������Ϊ" + iocash +"����ǰ���Ϊ" + myCount.getCash());
                	 }
                	 finally{
                         //�ͷ�д��
                         myLock.writeLock().unlock();
                     }
                 }
         }
}


class MyCount {
         private String oid;         //�˺�
         private int cash;             //�˻����

         MyCount(String oid, int cash) {
                 this.oid = oid;
                 this.cash = cash;
         }

         public String getOid() {
                 return oid;
         }

         public void setOid(String oid) {
                 this.oid = oid;
         }

         public int getCash() {
                 return cash;
         }

         public void setCash(int cash) {
                 this.cash = cash;
         }

         @Override
         public String toString() {
                 return "MyCount{" +
                                 "oid='" + oid + '\'' +
                                 ", cash=" + cash +
                                 '}';
         }
}
/*
д���������ڲ���MyCount{oid='95599200901215522', cash=10000}�˻������Ϊ-4000����ǰ���Ϊ10000
д����������MyCount{oid='95599200901215522', cash=6000}�˻��ɹ������Ϊ-4000����ǰ���Ϊ6000
д�������������ڲ���MyCount{oid='95599200901215522', cash=6000}�˻������Ϊ-8000����ǰ���Ϊ6000
д���������ܲ���MyCount{oid='95599200901215522', cash=-2000}�˻��ɹ������Ϊ-8000����ǰ���Ϊ-2000
д���������ڲ���MyCount{oid='95599200901215522', cash=-2000}�˻������Ϊ800����ǰ���Ϊ-2000
д����������MyCount{oid='95599200901215522', cash=-1200}�˻��ɹ������Ϊ800����ǰ���Ϊ-1200
���������������ڲ�ѯMyCount{oid='95599200901215522', cash=-1200}�˻�����ǰ���Ϊ-1200
д�������������ڲ���MyCount{oid='95599200901215522', cash=-1200}�˻������Ϊ6000����ǰ���Ϊ-1200
д��������������MyCount{oid='95599200901215522', cash=4800}�˻��ɹ������Ϊ6000����ǰ���Ϊ4800

Process finished with exit code 0
*/
