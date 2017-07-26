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
        String[] str_string = s.split("\\d");//  \d Ϊ������ʽ��ʾ[0-9]����  
        return str_string;  
    }  
      
    public int[] getNum(String s){  
        String[] num_string = s.split("\\D");  // \D Ϊ������ʽ��ʾ������  
        String a = "";  
          
        for(String m : num_string){  
            a += m;  
        }  
          
        String[] num = a.split("");  //������������±�����������num�в�Ҫֱ����num_string��  ��Ϊ��������ʽ���ַ�������ѡ��ʱ��ǰ��ļ����ַ�������Ҫ��num_string�������Ի������λ�� �ǿո�  
        int[] inte = new int[num.length];  
          
        for(int i =0; i < num.length; i++){  
            inte[i] = Integer.parseInt(num[i]); //���������е����ִ���int����  
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
	     int cur_year = cal.get(Calendar.YEAR);//��ȡ���
	     int cur_month=cal.get(Calendar.MONTH);//��ȡ�·�
	     int cur_day=cal.get(Calendar.DATE);//��ȡ��
	     
	     Integer input_month = 0; 
		 Matcher mat_str = Pattern.compile("\\D+").matcher("05JUL12");
		 while(mat_str.find()) {
			 input_month = (Integer)map.get(mat_str.group(0));
		 }
		 
		 Integer input_day=(Integer) v_num.elementAt(0);
		 
		 Integer year = cur_year;
		 if(v_num.size()==2) //��ʾ������05JUL12
		 {
			 cur_year=(Integer) v_num.elementAt(1); //
		 }
		 else //��ʾû�������꣬��05JUL
		 {
			 //�жϽ���֮ǰ��ȡ���꣬����ȡ����
			 if(input_month < cur_month){
				 cur_year = cur_year -1;
			 } else if((input_month == cur_month) && (input_day<cur_day)) {
				 cur_year = cur_year -1;
			 }			 
		 }

		 Calendar c1 = Calendar.getInstance();
		 c1.set(year, input_month - 1 , input_day);
		 Date date=c1.getTime();   //���ʱ���������������һ��Ľ�� 
	     System.out.println(date);

	 }
}
