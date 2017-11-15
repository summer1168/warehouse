package lab5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;

import javax.print.attribute.standard.Destination;

public class IO {
	 public void input(){
		 Scanner sc = new Scanner(System.in);
		 File infile = new File("src.txt");
	    	if(infile.exists()){//文件不存在，创建
	    		try{
	    			FileOutputStream out = new FileOutputStream(infile);
	    			OutputStreamWriter osw = new OutputStreamWriter(out, "utf-8");
	    			String a=sc.nextLine();
	    				osw.write(a); 			
	    			osw.close();
	    			sc.close();
	    		}catch(Exception e){
	    			e.printStackTrace();//输出异常信息
	    		}
	    	}else{
	    		try{//捕捉可能出现的异常
	    			infile.createNewFile();
	    			input();
	    		}
	    		catch(Exception e){
	    			e.printStackTrace();//输出异常信息
	    		}
	    	}
	 }	    	
	 public void output(){
		 File infile = new File("src.txt");
		 File outfile = new File("dest.txt");
		 if(outfile.exists()){//文件不存在，创建
	    		try{
	    			FileInputStream in = new FileInputStream(infile); //文件读入流
	    			FileOutputStream out = new FileOutputStream(outfile);//文件写出流	               
	                BufferedReader br = new BufferedReader(new InputStreamReader(in));
	                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
	                for(String line = br.readLine(); line != null; line = br.readLine())
	                {
	                   bw.write(line);//写入
	                   bw.newLine();//换行
	                   bw.flush();
	                }  
	                br.close();
	                bw.close();
	    		}catch(Exception e){
	    			e.printStackTrace();//输出异常信息
	    		}
	    	}else{
		    		try{//捕捉可能出现的异常
		    			outfile.createNewFile();
		    			output();
		    		}		
	    		catch (IOException e) {  
	                System.err.println("FileStreamsTest: " + e);  
	            } 
		
  		
	    }
   }
	 public void PrintScreen() {
		 File infile=new File("dest.txt");
		 if(infile.exists()){//文件不存在
	    		try{
	    			   InputStreamReader read = new InputStreamReader(new FileInputStream(infile));
	    			   BufferedReader bufferedReader = new BufferedReader(read);
	    			   String line = null;
	    			   while((line = bufferedReader.readLine()) != null){
	    			         System.out.println(line);
	    			   }
	    			   read.close();
	    		}catch(Exception e){
	    			e.printStackTrace();//输出异常信息
	    		}
	    	}else{
		    		System.out.println("文件不存在"); 
	        }
	 }
}



