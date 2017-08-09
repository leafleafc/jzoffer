package JZoffer;

public class No43DiceProbabilities {
	public static void main(String[] args){
		int number=11;
		No43DiceProbabilities dp = new No43DiceProbabilities();
		//dp.printProbability(number);
		dp.printProbabilityByCycle(number);
	}
	public void printProbability(int n){
		if(n<1)
			return;
		int g_maxValue = 6;
		int maxSum = n*g_maxValue;
		int[] pProbabilities = new int[maxSum-n+1];
		for(int i=0; i<=maxSum-n; i++){
			pProbabilities[i] = 0;
		}
		probability(n, pProbabilities, g_maxValue);
		double total = Math.pow(g_maxValue, n);
		for(int i=0; i<=maxSum-n; i++){
			double ratio = pProbabilities[i]/total;
			int nowSum = i+n;
			System.out.println("和为"+nowSum+"的概率为："+ratio);
		}
	}
	void probability(int n, int[] pProbabilities, int g_maxValue){
		for(int i=1;i<=g_maxValue;i++){
			probability(n,n,i,pProbabilities, g_maxValue);
		}
	}
	void probability(int original, int current, int sum, int[] pProbabilities, int g_maxValue){
		if(current ==1){
			pProbabilities[sum-original]++;
		}
		else{
			for(int i=1;i<=g_maxValue; i++){
				probability(original, current-1, sum+i, pProbabilities, g_maxValue);
			}
		}
	}
	public void printProbabilityByCycle(int n){
		if(n<1)
			return;
		int g_maxValue = 6;
		int[][] pProbabilities = new int[2][g_maxValue*n+1];
		int flag = 0;
		for(int i=0;i<=g_maxValue*n; i++){
			pProbabilities[0][i] = 0;
			pProbabilities[1][i] = 0;
		}
		for(int i=1;i<=g_maxValue;i++){
			pProbabilities[0][i] = 1;
		}
		
		for(int k =2; k<=n; k++){
			for(int i=0; i<=g_maxValue*k; i++){
				pProbabilities[1-flag][i] = 0;
			}
			for(int i=k; i<=g_maxValue*k; i++){
				for(int j=1; j<=i&&j<=g_maxValue;j++){
					pProbabilities[1-flag][i] += pProbabilities[flag][i-j];
				}
			}
			flag = 1-flag;
		}
		double total = Math.pow(g_maxValue, n);
		for(int i=n; i<=g_maxValue*n; i++){
			double ratio = pProbabilities[flag][i]/total;
			System.out.println("和为"+i+"的概率为："+ratio);
		}
	}
}
