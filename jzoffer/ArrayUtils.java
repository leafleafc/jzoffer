package JZoffer;

public class ArrayUtils {
	public static void printArray(int[] array) {
		if(array==null||array.length==0)
			return;
		System.out.print("{");  
        for (int i = 0; i <= array.length-1; i++) {  
            System.out.print(array[i]);  
            if (i < array.length - 1) {  
                System.out.print(", ");  
            }  
        }  
        System.out.println("}"); 
	}
	
	public static void exchangeElements(int[] array, int index_a, int index_b) {
		int temp = array[index_a];
		array[index_a] = array[index_b];
		array[index_b] = temp;
	}

}
