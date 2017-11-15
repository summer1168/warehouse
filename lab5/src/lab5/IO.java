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
	    	if(infile.exists()){//�ļ������ڣ�����
	    		try{
	    			FileOutputStream out = new FileOutputStream(infile);
	    			OutputStreamWriter osw = new OutputStreamWriter(out, "utf-8");
	    			String a=sc.nextLine();
	    				osw.write(a); 			
	    			osw.close();
	    			sc.close();
	    		}catch(Exception e){
	    			e.printStackTrace();//����쳣��Ϣ
	    		}
	    	}else{
	    		try{//��׽���ܳ��ֵ��쳣
	    			infile.createNewFile();
	    			input();
	    		}
	    		catch(Exception e){
	    			e.printStackTrace();//����쳣��Ϣ
	    		}
	    	}
	 }	    	
	 public void output(){
		 File infile = new File("src.txt");
		 File outfile = new File("dest.txt");
		 if(outfile.exists()){//�ļ������ڣ�����
	    		try{
	    			FileInputStream in = new FileInputStream(infile); //�ļ�������
	    			FileOutputStream out = new FileOutputStream(outfile);//�ļ�д����	               
	                BufferedReader br = new BufferedReader(new InputStreamReader(in));
	                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
	                for(String line = br.readLine(); line != null; line = br.readLine())
	                {
	                   bw.write(line);//д��
	                   bw.newLine();//����
	                   bw.flush();
	                }  
	                br.close();
	                bw.close();
	    		}catch(Exception e){
	    			e.printStackTrace();//����쳣��Ϣ
	    		}
	    	}else{
		    		try{//��׽���ܳ��ֵ��쳣
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
		 if(infile.exists()){//�ļ�������
	    		try{
	    			   InputStreamReader read = new InputStreamReader(new FileInputStream(infile));
	    			   BufferedReader bufferedReader = new BufferedReader(read);
	    			   String line = null;
	    			   while((line = bufferedReader.readLine()) != null){
	    			         System.out.println(line);
	    			   }
	    			   read.close();
	    		}catch(Exception e){
	    			e.printStackTrace();//����쳣��Ϣ
	    		}
	    	}else{
		    		System.out.println("�ļ�������"); 
	        }
	 }
}



