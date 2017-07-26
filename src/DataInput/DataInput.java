package DataInput;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class DataInput {

    public String[] getStr(String s){  
        String[] str_string = s.split("\\d");//  \d 为正则表达式表示[0-9]数字  
        return str_string;  
    }  
      
    public int[] getNum(String s){  
        String[] num_string = s.split("\\D");  // \D 为正则表达式表示非数字  
        String a = "";  
          
        for(String m : num_string){  
            a += m;  
        }  
          
        String[] num = a.split("");  //将分离出的重新保存在新数组num中不要直接用num_string，  因为在正则表达式对字符串进行选择时若前面的几个字符不符合要求但num_string数组中仍会存有其位置 是空格  
        int[] inte = new int[num.length];  
          
        for(int i =0; i < num.length; i++){  
            inte[i] = Integer.parseInt(num[i]); //将该数组中的数字存入int数组  
        }  
          
        return inte;  
    } 

	 public static void main(String args[]) throws Exception {
		 Matcher mat = Pattern.compile("\\D*(\\d+)\\D*").matcher("05jun12");
		 Vector v_num = new Vector();
		 while(mat.find()) {
			 v_num.addElement(Integer.parseInt(mat.group(1)));
		 }
		 Map map = new HashMap();
		 map.put("JUL",7);
	     Calendar cal = Calendar.getInstance();
	     int cur_year = cal.get(Calendar.YEAR);//获取年份
	     int cur_month=cal.get(Calendar.MONTH);//获取月份
	     int cur_day=cal.get(Calendar.DATE);//获取日
	     
	     Integer input_month = 0; 
		 Matcher mat_str = Pattern.compile("\\D+").matcher("05JUL12");
		 while(mat_str.find()) {
			 input_month = (Integer)map.get(mat_str.group(0));
		 }
		 
		 Integer input_day=(Integer) v_num.elementAt(0);
		 
		 Integer year = cur_year;
		 if(v_num.size()==2) //表示输入了05JUL12
		 {
			 cur_year=(Integer) v_num.elementAt(1); //
		 }
		 else //表示没有输入年，入05JUL
		 {
			 //判断今天之前，取明年，否则取今年
			 if(input_month < cur_month){
				 cur_year = cur_year -1;
			 } else if((input_month == cur_month) && (input_day<cur_day)) {
				 cur_year = cur_year -1;
			 }			 
		 }

		 Calendar c1 = Calendar.getInstance();
		 c1.set(year, input_month - 1 , input_day);
		 Date date=c1.getTime();   //这个时间就是日期往后推一天的结果 
	     System.out.println(date);

	 }
}
