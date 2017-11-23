package collectionClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.Random;
import java.util.Scanner;

public class Task {
	protected int TaskId[];//������
	protected int arrived_time[];//����ʱ��
	protected int server_time[];//����ʱ��
	
	public Task(){
		TaskId= new int[100];
		arrived_time=new int[100];
		server_time=new int[100];		
	}
	
	public void InputData(){
    	File file = new File("task.txt");
    	int[] numbers = {6,2,1,3,9};//��6��2��1��3��9�в��������
    	if(!file.exists()){
    		try{
    			file.createNewFile();
    			FileOutputStream out = new FileOutputStream(file);
    			OutputStreamWriter osw = new OutputStreamWriter(out, "utf-8");
    			for(int i=0;i<100;i++){
    				TaskId[i]=i+1;//����������
    				osw.write(TaskId[i]);
    				
    				arrived_time[i]=i;//��������ﵽʱ��
    				osw.write(arrived_time[i]);
    				
    	    		Random random = new Random();
    	    		int index = random.nextInt(numbers.length);//�����������Ϊ���񵽴�ʱ��
    	    		server_time[i]=numbers[index];
    	    		osw.write(server_time[i]);   	    		
    			}
    			osw.close();
    		}catch(Exception e){
    			e.printStackTrace();//����쳣��Ϣ
    		}
    	}
    }
	public void OutputData(){	
		File file = new File("input.txt");//�����ļ�����	    
    	if(file.exists()){//�ж��ļ��Ƿ����   	
    		try{   			
    		   FileInputStream in = new FileInputStream(file);   //����FileInputStream���󣬽�������Ϣ���ļ��ж�ȡ����
    		   Scanner scan =new Scanner(in);//��scan��ȡstring��Ϣ(�����ո�,���о��Զ���)
    		   int i=0;
    		   while(scan.hasNext()){
    			   TaskId[i]=scan.nextInt();
    			   arrived_time[i]=scan.nextInt();
    			   server_time[i]=scan.nextInt();
    			   i=i+1;
    		   }
               scan.close();
	}catch(Exception e){
		e.printStackTrace();//����쳣��Ϣ
	}

    	}
	}
	
}

