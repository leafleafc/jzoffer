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

        //方法1
        Iterator it1 = list.iterator();
        while(it1.hasNext()){
            System.out.println(it1.next());
        }

        //方法2
        for(Iterator it2 = list.iterator();it2.hasNext();){
             System.out.println(it2.next());
        }

        //方法3
        for(String tmp:list){
            System.out.println(tmp);
        }

        //方法4
        for(int i = 0;i < list.size(); i ++){
            System.out.println(list.get(i));
        }
        
        ArrayList<String> al = new ArrayList<String>();   //ArrayList为泛型  
        al.add(new String("a"));  
        al.add(new String("b"));  
        al.add(new String("c"));  
        al.add(new String("d"));  

        //查询size  
        int size = al.size();  

        //查询特定的元素  
        boolean has = al.contains("a");  

        //是否为空  
        boolean isEmpty = al.isEmpty();  

        if (al.size() == 0){  

        }  


        //下标删除特定的元素  
        al.remove(1);  

        //根据内容删除特定元素  
        al.remove("a");  

        //删除全部元素  
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
        map.put(4, "ab");// 和上面相同 ， 会自己筛选
        System.out.println(map.size());
        // 第一种：
        /*
         * Set<Integer> set = map.keySet(); //得到所有key的集合
         * 
         * for (Integer in : set) { String str = map.get(in);
         * System.out.println(in + "     " + str); }
         */
        System.out.println("第一种：通过Map.keySet遍历key和value：");
        for (Integer in : map.keySet()) {
            //map.keySet()返回的是所有key的值
            String str = map.get(in);//得到每个key多对用value的值
            System.out.println(in + "     " + str);
        }
        // 第二种：
        System.out.println("第二种：通过Map.entrySet使用iterator遍历key和value：");
        Iterator<Map.Entry<Integer, String>> it = map.entrySet().iterator();
        while (it.hasNext()) {
             Map.Entry<Integer, String> entry = it.next();
               System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
        }
        // 第三种：推荐，尤其是容量大时
        System.out.println("第三种：通过Map.entrySet遍历key和value");
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            //Map.entry<Integer,String> 映射项（键-值对）  有几个方法：用上面的名字entry
            //entry.getKey() ;entry.getValue(); entry.setValue();
            //map.entrySet()  返回此映射中包含的映射关系的 Set视图。
            System.out.println("key= " + entry.getKey() + " and value= "
                    + entry.getValue());
        }
        // 第四种：
        System.out.println("第四种：通过Map.values()遍历所有的value，但不能遍历key");
        for (String v : map.values()) {
            System.out.println("value= " + v);
        }
    }
}