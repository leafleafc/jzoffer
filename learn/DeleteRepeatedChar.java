package learn;

import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;
 
public class DeleteRepeatedChar {
    private String str;
    private TreeSet<String> noReapted;//����String���͵�TreeSet����
         
    public DeleteRepeatedChar() {
        Scanner in = new Scanner(System.in);
         
        System.out.println ("����һ���ַ���:");
        str = in.nextLine();
         
        noReapted = new TreeSet();
    }
     
    //����ظ�������
    public void removeRepeated(){
        for (int i = 0; i < str.length(); i++){
            noReapted.add(""+str.charAt(i));
            //str.charAt(i)���ص���char��  �����ȼ�һ��""�ո� , ת����String��
            //TreeSet�����ܱ�֤�ظ��Ĳ����� , ��������
        }
         
        str = "";
         
        for(String index:noReapted){
            str += index;
        }
         
        //���
        System.out.println (str);
    }
     
    public static void main(String[] args) {
        DeleteRepeatedChar dr = new DeleteRepeatedChar();
        dr.removeRepeated();
    }
}
