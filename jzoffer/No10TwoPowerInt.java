package JZoffer;

public class No10TwoPowerInt {
	public static void main(String[] args){
		int number=64;
		System.out.println(number+"是2的整数次方："+intTwoPower(number));
	}
	
	public static boolean intTwoPower(int number){
		boolean ret = false;
		if((number>=0)&&(number&(number-1)) == 0)
			ret = true;
		return ret;
	}

}
