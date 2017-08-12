package learn;



public class TestClass { 
    public static void main(String[] args) { 
        // �������ڼ䣬�������Ҫ����ĳ����Ķ���java�������������͵�Class�����Ƿ��ѱ�����
	    //���û�м��أ�java������������������ҵ�.class�ļ����������� 
        // ��new Point()��ʱ���������࣬��forName����ʵ����ʱ��Ҳ���ظ��ࡣ ֻ����һ�� 
        System.out.println("before new Point()"); 
        new Point(); 
        System.out.println("after new Point()"); 
        try { 
        	//String className= "Point";
            Class.forName("learn.Point");//�������һ��Ҫ�Ӱ���
        	//Class.forName(className); 
        } catch (Exception e) { 
            e.printStackTrace(); 
        } 
        try { 
        	Class.forName("learn.TestClass");  
        } catch (Exception e) { 
            e.printStackTrace(); 
        } 
        
 
        // ���ö������getClass()������ȡ�ö����Classʵ�� 
        Point pt = new Point(); 
        Class c1 = pt.getClass(); 
        System.out.println(c1.getName()); 					// ���:Point 
 
        // ʹ��Class�ľ�̬����forName()����������ֻ�ȡһ��Classʵ�� 
        try { 
            Class c2 = Class.forName("learn.Point"); 
            System.out.println(c2.getName()); 				// ���:Point 
			
            // һ��ĳ�����͵�Class�����Ѿ������ص��ڴ棬�Ϳ������������������͵����ж���
			Point pp = (Point) c2.newInstance();  			// newInstance()��������ȱʡ�Ĺ��췽��
													
            pp.output(); 
        } catch (Exception e) { 
            e.printStackTrace(); 
        } 
 
        // ����.class�ķ�ʽ��ȡClassʵ��(��) 
        Class c3 = Point.class; 
        System.out.println(c3.getName()); 					// ���:Point 
 
        // ����.calss�ķ�ʽ��ȡClassʵ��(��������) 
        Class c4 = int.class; 
        System.out.println(c4.getName()); 					// ���:int 
 
        // ����.class�ķ�ʽ��ȡClassʵ��(�����������͵ķ�װ��) 
        Class c5 = Integer.TYPE; 
        System.out.println(c5.getName()); 					// ���:int 
        Class c6 = Integer.class; 
        System.out.println(c6.getName()); 					// ���:java.lang.Integer 
    } 
} 

class Point { 
    static { 
        System.out.println("loading point"); 
    } 
 
    void output() { 
        System.out.println("x=" + x + ",y=" + y); 
    } 
    int x, y; 
} 

class Line { 
    static { 
        System.out.println("loading Line"); 
    } 
} 
 
