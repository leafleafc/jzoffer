package learn;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class aaaaaaa {

}

class ArrayListDemo {
    public static void main(String args[]){
        List<String> list = new ArrayList<String>();
        list.add("luojiahui");
        list.add("luojiafeng");

        //����1
        Iterator it1 = list.iterator();
        while(it1.hasNext()){
            System.out.println(it1.next());
        }

        //����2
        for(Iterator it2 = list.iterator();it2.hasNext();){
             System.out.println(it2.next());
        }

        //����3
        for(String tmp:list){
            System.out.println(tmp);
        }

        //����4
        for(int i = 0;i < list.size(); i ++){
            System.out.println(list.get(i));
        }
        
        ArrayList<String> al = new ArrayList<String>();   //ArrayListΪ����  
        al.add(new String("a"));  
        al.add(new String("b"));  
        al.add(new String("c"));  
        al.add(new String("d"));  

        //��ѯsize  
        int size = al.size();  

        //��ѯ�ض���Ԫ��  
        boolean has = al.contains("a");  

        //�Ƿ�Ϊ��  
        boolean isEmpty = al.isEmpty();  

        if (al.size() == 0){  

        }  


        //�±�ɾ���ض���Ԫ��  
        al.remove(1);  

        //��������ɾ���ض�Ԫ��  
        al.remove("a");  

        //ɾ��ȫ��Ԫ��  
        al.removeAll(al);  
   }
}


class TestMap {
    //public static void main(String[] args) {
	public void main1(String[] args) {
        Map<Integer, String> map = new HashMap<Integer, String>();
        map.put(1, "a");
        map.put(2, "b");
        map.put(3, "ab");
        map.put(4, "ab");
        map.put(4, "ab");// ��������ͬ �� ���Լ�ɸѡ
        System.out.println(map.size());
        // ��һ�֣�
        /*
         * Set<Integer> set = map.keySet(); //�õ�����key�ļ���
         * 
         * for (Integer in : set) { String str = map.get(in);
         * System.out.println(in + "     " + str); }
         */
        System.out.println("��һ�֣�ͨ��Map.keySet����key��value��");
        for (Integer in : map.keySet()) {
            //map.keySet()���ص�������key��ֵ
            String str = map.get(in);//�õ�ÿ��key�����value��ֵ
            System.out.println(in + "     " + str);
        }
        // �ڶ��֣�
        System.out.println("�ڶ��֣�ͨ��Map.entrySetʹ��iterator����key��value��");
        Iterator<Map.Entry<Integer, String>> it = map.entrySet().iterator();
        while (it.hasNext()) {
             Map.Entry<Integer, String> entry = it.next();
               System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
        }
        // �����֣��Ƽ���������������ʱ
        System.out.println("�����֣�ͨ��Map.entrySet����key��value");
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            //Map.entry<Integer,String> ӳ�����-ֵ�ԣ�  �м��������������������entry
            //entry.getKey() ;entry.getValue(); entry.setValue();
            //map.entrySet()  ���ش�ӳ���а�����ӳ���ϵ�� Set��ͼ��
            System.out.println("key= " + entry.getKey() + " and value= "
                    + entry.getValue());
        }
        // �����֣�
        System.out.println("�����֣�ͨ��Map.values()�������е�value�������ܱ���key");
        for (String v : map.values()) {
            System.out.println("value= " + v);
        }
    }
}