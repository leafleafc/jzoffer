package learn;

public class TestStaticCon {
	public static int a = 0;

	static {
		a = 10;
		System.out.println("����ľ�̬�������ִ��a=" + a);
	}
	
	{
		a = 8;
		System.out.println("����ķǾ�̬�������ִ��a=" + a);
	}

	public TestStaticCon() {
		this("a�ڸ�����ι��췽���е�ֵ��" + TestStaticCon.a); // ��������һ�����췽��
		System.out.println(a);
		System.out.println("�����޲ι��췽����ִ��a=" + a);
	}

	public TestStaticCon(String n) {
		System.out.println(n);
		System.out.println(a);

	}

	public static void main(String[] args) {
		TestStaticCon tsc = null;
		System.out.println("!!!!!!!!!!!!!!!!!!!!!");
		tsc = new TestStaticCon();
	}/*Output:
           ����ľ�̬�������ִ��a=10
           !!!!!!!!!!!!!!!!!!!!!
           ����ķǾ�̬�������ִ��a=8
           a�ڸ�����ι��췽���е�ֵ��10
           8
           8
           �����޲ι��췽����ִ��a=8
           */

}
