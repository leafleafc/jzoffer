package JZoffer;

public class JavaArray {
	public static void main(String[] args){
//		0,0,0,0,
//		null,null,null,null,
//		0.0,0.0,0.0,0.0,
//		false,false,false,false,
//		 , , , ,
//		null,null,null,null,
//		0,0,
//		0,0,0,

		int[] inumber = new int[4];
		for(int i=0;i<=3;i++)
		    System.out.print(inumber[i]+",");
		System.out.println();
		
		Integer[] Inumber = new Integer[4];
		for(int i=0;i<=3;i++)
		    System.out.print(Inumber[i]+",");
		System.out.println();
		
		double[] dnumber = new double[4];
		for(int i=0;i<=3;i++)
		    System.out.print(dnumber[i]+",");
		System.out.println();
		
		boolean[] bnumber = new boolean[4];
		for(int i=0;i<=3;i++)
		    System.out.print(bnumber[i]+",");
		System.out.println();
		
		char[] cnumber = new char[4];
		for(int i=0;i<=3;i++)
		    System.out.print(cnumber[i]+",");
		System.out.println();
		
		String[] snumber = new String[4];
		for(int i=0;i<=3;i++)
		    System.out.print(snumber[i]+",");
		System.out.println();
		
		int[][] dd=new int[2][];
		
		dd[0]=new int[2];
		dd[1]=new int[3];
		for(int i=0;i<=1;i++){
			for(int j=0;j<=dd[i].length-1;j++)
		        System.out.print(dd[i][j]+",");
		    System.out.println();
		}
		System.out.println();
	} 

}
