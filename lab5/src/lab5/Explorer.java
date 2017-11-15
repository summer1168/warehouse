package lab5;

import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

public class Explorer {
	    public static String [] getFileName(String path)
	    {
	        File file = new File(path);
	        String [] fileName = file.list();
	        return fileName;
	    }	
	    public static void main(String[] args){
	    	    System.out.println("������Ŀ¼·����");
			    Scanner sc = new Scanner(System.in);
	            String path = sc.nextLine();
	            sc.close();
			    String [] fileName = getFileName(path);
		        for(String name:fileName)
		        {
		        	File file=new File(name);
		        	if(file.length()==0){//��СΪ0�����ļ��У������
		        	Calendar cal = Calendar.getInstance();  
		            long time = file.lastModified();  
		            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");         
		            cal.setTimeInMillis(time); 
		            System.out.println(name+"      "+formatter.format(cal.getTime()));
		        	}
		        }
		        for(String name:fileName)
		        {
		        	File file=new File(name);
		        	if(file.length()!=0){//��С��Ϊ0�����ļ��������
		        	Calendar cal = Calendar.getInstance();  
		            long time = file.lastModified();  
		            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");         
		            cal.setTimeInMillis(time); 
		            System.out.println(name+"   "+formatter.format(cal.getTime())+"  " +file.length());
		        	}
		        }
		        
		        
		        
		 }
}
