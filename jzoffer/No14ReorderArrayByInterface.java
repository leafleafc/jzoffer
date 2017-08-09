package JZoffer;

public class No14ReorderArrayByInterface {
	public static void main(String[] args){
		//int[] array={1,2,-3,4,-5};
		//int[] array={2,4,6,7,9};
		//int[] array={7,9,11,2,0};
		//int[] array={7};
		int[] array={};
	    Function isEven = new IsEvenFunc();
		reoderByOddEven(array, isEven);
		
//		Function isNoNegative = new IsNonNegativeFunc();
//		reoderByOddEven(array, isNoNegative);
		for(int i=0;i<=array.length-1;i++)
			System.out.print(array[i]+",");
		
	}
	
	public static void reoderByOddEven(int[] array, Function func){
		if(array.length<=0||array==null)
			throw new RuntimeException("Invalid array");
		int i=0, j=array.length-1;
		while(i<j){
			while(i<j&&!func.jugde(array[i])){
				i++;
			}
			while(i<j&&func.jugde(array[j])){
				j--;
			}
			if(i<j){
				int temp = array[i];
				array[i] = array[j];
				array[j] = temp;
			}
		}
	}
	
}

interface Function{
	public boolean jugde(int n);
}

class IsEvenFunc implements Function{//判断是否是偶数
	@Override
	public boolean jugde(int n) {
		if((n&1)==0) return true;
		else return false;
	}
}

class IsNonNegativeFunc implements Function{//判断是否是非负数
	@Override
	public boolean jugde(int n) {
		if(n>=0) return true;
		else return false;
	}
}

//Java实现类似C里面传指针的功能
/**
 * 利用接口和类实现函数指针的功能
 * @author Administrator
 *
 */
interface Compare{
	public int cmp(int a , int b );
}
class Compare1 implements Compare {
	@Override
	public int cmp(int a, int b) {
		return a;
	}
}
class Compare2 implements Compare {
	@Override
	public int cmp(int a, int b) {
		return b;
	}
}

class InterfaceTest {//public 
	public InterfaceTest(Compare com){
		System.out.println(com.cmp(1, 2));
}
	public static void main(String[] args) {
		Compare com = new Compare1();
		Compare com1 = new Compare2();
		new InterfaceTest(com);
		new InterfaceTest(com1);
	}
}

