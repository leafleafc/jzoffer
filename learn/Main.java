package learn;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main {



	/* 请完成下面这个函数，实现题目要求的功能 */
	/* 当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^ */
	/****************************** 开始写代码 ******************************/
	static String[] demo(int M, int N, List<String> listlog) {

		Main demo = new Main();

		List<String> nameList = demo.findNoisyBoy(M, N, listlog);

		return nameList.toArray(new String[0]);

	}
	private List<String> findNoisyBoy(int m, int n, List<String> listlog) {
		Map<String,Integer> userName=new HashMap<String,Integer>();
		List<String> resUser = new ArrayList<String>();
		int index=0, j=-1;
		ArrayList<ArrayList<Date>> userTimeInfo = new ArrayList<ArrayList<Date>>();
		for(int i=0;i<=listlog.size()-1;i++){
			String [] strArray = listlog.get(i).split("#");
			if(!userName.containsKey(strArray[1])){//当前用户不存在
				index=++j;
				userName.put(strArray[1],index);
				ArrayList<Date> listDate= new ArrayList<Date>();
				listDate.add(changeTimeFormat(strArray[0]));
				userTimeInfo.add(listDate);
			}
			else{//当前用户存在
			    index=userName.get(strArray[1]);
			    userTimeInfo.get(index).add(changeTimeFormat(strArray[0]));
			}	
		}
		for(int i=0; i<=userTimeInfo.size()-1; i++){
			for(int l=0;l<=userTimeInfo.get(i).size()-1;l++){
				
				System.out.println(userTimeInfo.get(i).get(l));
			}
		}
		
        return resUser;
	}
	
	private Date changeTimeFormat(String stringDate){
		Date theTime=new Date(); 
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
        try{
        	 theTime=sdf.parse(stringDate);
        }catch(ParseException e){
        	e.printStackTrace();
        }
		return theTime;
	}


	/****************************** 结束写代码 ******************************/

	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String[] res;

        int _nMin;
        _nMin = Integer.parseInt(in.nextLine().trim());//Integer.parseInt是把当前String对象转成int
        //trim()去掉两端空格
        //把StringBuffer转换成String类型时 没有用.trim()会导致意想不到的结果－－
        //用if语句判断时跟想的不一样
        //if(returnStr==null||returnStr==""){//没有.trim()这句通不过
        //if(returnStr.length()==0){//判断长度为零没有.trim()也可以。
        //System.out.println(_nMin);
        
        int _nNum;
        _nNum = Integer.parseInt(in.nextLine().trim());
        //System.out.println(_nNum);

		List<String> _listLog = new ArrayList<String>();

		String _result="";
		while (_result != null) {
			try {
				_result = in.nextLine();
				_listLog.add(_result);
				System.out.println(_result);
			} catch (Exception e) {
				_result = null;
			}
		}
		in.close();
		System.out.println("Stop reading");
		res = demo(_nMin, _nNum, _listLog);
		for (int res_i = 0; res_i < res.length; res_i++) {
			System.out.println(String.valueOf(res[res_i]));
		}
    }
}