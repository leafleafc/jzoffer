package JZoffer;

/**
 * ��ָoffer������12�����Ŀ����λ���Ӽ��˷���ʵ�֡�
 * ����˼·��ʹ���ַ�����ʾ���֣�ת����������м��㡣��λ��ӣ�Ȼ�����λ
 * ���ַ�����ת����ģ��ӵ�λ����λ�����
 * @author GL
 *
 */
public class No12BigDigitalCalculate {

    /**
     * ����������ӣ�Ĭ����������λ��������λ������
     * @param a
     * @param b
     * @return
     */
    public static String bigDigitalSum(String a,String b){

        //��ת�����ַ�����ת��������
        char[] aArray=new StringBuffer(a).reverse().toString().toCharArray();
        char[] bArray=new StringBuffer(b).reverse().toString().toCharArray();
        int aLength=aArray.length;
        int bLength=bArray.length;
        
        //����������ӵ����λ��Ϊ�������������λ��+1
        int maxLength=aLength>bLength?aLength:bLength;
        int[] result=new int[maxLength+1];
        
        //������λ��Ӧ���
        for(int i=0;i<maxLength+1;i++){
            //�жϵ�ǰλ�Ƿ񳬹��˵�ǰ��ֵ�����λ�����������0�����������
            int aInt=i<aLength?(aArray[i]-'0'):0;
            int bInt=i<bLength?(bArray[i]-'0'):0;
            result[i]=aInt+bInt;
        }
        
        //�����λ����λ�ӵ����ڵĸ�λ��
        for(int i=0;i<result.length;i++){
            if(result[i]>10){
                result[i+1]=result[i+1]+result[i]/10;
                result[i]=result[i]%10;
            }
        }
        
        StringBuffer realResult=new StringBuffer();
        //�ж��Ƿ���ǰ��0������в����ӡ����
        boolean isBeginning=true;
        for(int i=result.length-1;i>=0;i--){
            if(result[i]==0&&isBeginning)
                continue;
            else
                isBeginning=false;
            //�Ӻ���ǰ�������ת
            realResult.append(result[i]);
        }
        return realResult.toString();
    }
    
    public static void main(String[] args) {
        String a="88900988";
        String b="7878778888";
        System.out.println(bigDigitalSum(a,b));
        
    }
}

