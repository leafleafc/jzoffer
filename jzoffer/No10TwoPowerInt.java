package JZoffer;

public class No10TwoPowerInt {
	public static void main(String[] args){
		int number=64;
		System.out.println(number+"��2�������η���"+intTwoPower(number));
	}
	
	public static boolean intTwoPower(int number){
		boolean ret = false;
		if((number>=0)&&(number&(number-1)) == 0)
			ret = true;
		return ret;
	}

}
