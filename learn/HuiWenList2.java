package learn;

import java.util.ArrayList;
import java.util.Scanner;

public class HuiWenList2 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] item = new int[n];
            for(int i=0;i<n;i++){
                item[i] = scanner.nextInt();
            }
            System.out.println(leastTimeToHuiwen(n, item));
        }
    }
    public static int leastTimeToHuiwen(int n, int[] item) {
        //�Ƚϵ�һ�������һ�����������һ��С����ǰ��������滻ԭ��λ�á�
        //������һ����С���������������滻ԭ��λ�á�
        //�����βԪ����ȣ���ɾ����βԪ�ء�
        int leastTime = 0;
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i=0;i<n;i++){
            list.add(item[i]);
        }
        while(list.size() > 1){
            if(list.get(0) < list.get(list.size() - 1)){
                int a = list.get(0);
                int b = list.get(1);
                list.set(0, a+b);
                list.remove(1);
                leastTime++;
            }
            else if(list.get(0) > list.get(list.size() - 1)){
                int a = list.get(list.size() - 1);
                int b = list.get(list.size() - 2);
                list.set(list.size() - 2, a+b);
                list.remove(list.size() - 1);
                leastTime++;
            }
            else{
                list.remove(0);
                list.remove(list.size() - 1);
            }
        }
        return leastTime;
    }

}