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
	    	    System.out.println("请输入目录路径：");
			    Scanner sc = new Scanner(System.in);
	            String path = sc.nextLine();
	            sc.close();
			    String [] fileName = getFileName(path);
		        for(String name:fileName)
		        {
		        	File file=new File(name);
		        	if(file.length()==0){//大小为0，是文件夹，先输出
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
		        	if(file.length()!=0){//大小不为0，是文件，后输出
		        	Calendar cal = Calendar.getInstance();  
		            long time = file.lastModified();  
		            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");         
		            cal.setTimeInMillis(time); 
		            System.out.println(name+"   "+formatter.format(cal.getTime())+"  " +file.length());
		        	}
		        }
		        
		        
		        
		 }
}
