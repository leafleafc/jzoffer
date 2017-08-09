package JZoffer;

public class No12PrintFromOneToMaxNByString {
	
	public static void main(String[] args){
		char[] number = new char[4];//java默认初始化为'\0'即'\u0000'
		//Integer[] a = new Integer[4];
//		for(int i=0;i<=3;i++)
//		    System.out.print(number[i]+",");
		if(number[0]=='\0')
			System.out.println("true");
		for(int i=0;i<=3;i++)
		    number[i] = '0';
//		for(int i=0;i<=3;i++)
//		    System.out.print(number[i]+",");
		while(!increment(number)){
			printN(number);
		}
	}
	
	public static void printN(char[] number){
		boolean isBeginningZero = true;
		for(int i=0;i<=number.length-1;i++){
			if(isBeginningZero&&number[i]!='0'){//找到第一个非零位置
				isBeginningZero = false;
			}
			if(!isBeginningZero)//从这个非零元素开始依次打印
				System.out.print(number[i]);
		}
		System.out.println();
	} 
	
	public static boolean increment(char[] number){
		boolean isOverFlow=false;//最高位是否有进位
		int carry=0;//运算是否有进位
		if(number.length<=0)
			throw new RuntimeException("Invalid array");
		for(int i=number.length-1; i>=0; i--){
			int sum=number[i]-'0'+carry;//本次加法之前先加进位
			if(i==number.length-1)//最后一位加一
				sum++;
			
			if(sum==10){//产生进位
				if(i==0)//最高位产生进位
					isOverFlow=true;
				else{//其它位产生进位
					carry=1;
					sum=0;
					number[i]=(char)(sum+'0');
				}
			}
			else{//没有进位，跳出for循环
				number[i]=(char)(sum+'0');
				break;
			}
				
		}
		return isOverFlow;
	}
}
