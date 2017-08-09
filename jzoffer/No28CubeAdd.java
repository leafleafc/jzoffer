package JZoffer;

public class No28CubeAdd {
	public static void main(String[] args){
		int[] str = {1,2,3,4,5,6,7,8};
		addTheCube(str);
	}
	
	public static void addTheCube(int[] str){
		if(str==null||str.length==0)
			return;
		int total =0;
		total = addTheCube(str,0,total);
		System.out.println("total:"+total);
	}
	
	public static int addTheCube(int[] str, int begin,int total){
		if(begin == str.length){
			if((str[0]+str[1]+str[2]+str[3] == str[4]+str[5]+str[6]+str[7])
					&& (str[0]+str[2]+str[4]+str[6] == str[1]+str[3]+str[5]+str[7])
					&& (str[0]+str[1]+str[4]+str[5] == str[2]+str[3]+str[6]+str[7])
			){
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
	
	public static boolean hasBeenSwaped(int[] str, int begin, int i){
		for(int k=begin; k<=i-1; k++){
			if(str[k] == str[i])
				return true;
		}
		return false;
	}
}
