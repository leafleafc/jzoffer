package JZoffer;

//这个方法有问题，有重复（对称，旋转）
public class No28EightQueen {
	public static void main(String[] args){
		int[] str = {0,1,2,3,4,5,6,7};
		addTheCube(str);
	}
	
	public static void addTheCube(int[] str){
		if(str==null||str.length==0)
			return;
		Integer total = new Integer(0);
		total = addTheCube(str,0,total);
		System.out.println("total:"+total);
	}
	
	public static int addTheCube(int[] str, int begin,int total){
		if(begin == str.length){
			if(judge(str)){
				for(int i=0; i<=str.length -1; i++)
					System.out.print(str[i]+" ");
				System.out.println();
				total++;
			}
		}
		else{
			for(int i=begin; i<=str.length-1;i++){
				if(!hasBeenSwaped(str, begin, i)){
					int tmp = str[begin];
					str[begin]=str[i];
					str[i] = tmp;
				
					total = addTheCube(str, begin+1,total);
				
					tmp = str[begin];
					str[begin]=str[i];
					str[i] = tmp;
				}
			}
		}
		return total;
	}
	
	public static boolean judge(int[] str){
		for(int i=0; i<=str.length-1; i++){
			for(int j = i+1; j<=str.length-1;j++){
				if((i-j == str[i]-str[j])||(j-i == str[j]-str[i]))
					return false;
			}
		}
		return true;
	}
	
	public static boolean hasBeenSwaped(int[] str, int begin, int i){
		for(int k=begin; k<=i-1; k++){
			if(str[k] == str[i])
				return true;
		}
		return false;
	}

}
