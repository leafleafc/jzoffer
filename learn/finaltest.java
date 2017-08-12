package learn;

import java.util.*;

public class finaltest
{
	public int containsInWords(String str, String[] systemWords)
	{
		for(String words:systemWords)
		{
			if(str.equals(words))
				return 1;
		}
		return 0;
	}
public void calculateLength()
	{
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int m = scanner.nextInt();
		//System.out.println(m+","+n);
		scanner.nextLine();
		String[] systemWords = new String[m];
		systemWords = scanner.nextLine().split(" ");
		//System.out.println(systemWords.length);
		String[] MyWords = scanner.nextLine().split(" ");
		//System.out.println(MyWords.length);
		//scanner.nextLine();
		Map<String,Integer> MyWORDS = new HashMap<String,Integer>();
		for(String word:MyWords)
		{
			MyWORDS.put(word, 1);
		}
		//System.out.println(MyWORDS.size());
		Iterator<Map.Entry<String,Integer>> iterator =  MyWORDS.entrySet().iterator();
		int score = 0;
		while(iterator.hasNext())
		{
			Map.Entry<String, Integer> entry = iterator.next();
			//System.out.println(entry.getKey());
			if(1 == containsInWords(entry.getKey(),systemWords))
				score += Math.pow(Integer.valueOf(entry.getKey().length()),2);
		}
		
		System.out.println(score);
	}


	public static void main(String[] args) {
                finaltest ft = new finaltest();
                ft.calculateLength();
        }
}
