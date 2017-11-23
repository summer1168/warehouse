package collectionClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.Random;
import java.util.Scanner;

public class Task {
	protected int TaskId[];//任务编号
	protected int arrived_time[];//到达时间
	protected int server_time[];//服务时间
	
	public Task(){
		TaskId= new int[100];
		arrived_time=new int[100];
		server_time=new int[100];		
	}
	
	public void InputData(){
    	File file = new File("task.txt");
    	int[] numbers = {6,2,1,3,9};//在6，2，1，3，9中产生随机数
    	if(!file.exists()){
    		try{
    			file.createNewFile();
    			FileOutputStream out = new FileOutputStream(file);
    			OutputStreamWriter osw = new OutputStreamWriter(out, "utf-8");
    			for(int i=0;i<100;i++){
    				TaskId[i]=i+1;//赋予任务编号
    				osw.write(TaskId[i]);
    				
    				arrived_time[i]=i;//赋予任务达到时间
    				osw.write(arrived_time[i]);
    				
    	    		Random random = new Random();
    	    		int index = random.nextInt(numbers.length);//生成随机数作为任务到达时间
    	    		server_time[i]=numbers[index];
    	    		osw.write(server_time[i]);   	    		
    			}
    			osw.close();
    		}catch(Exception e){
    			e.printStackTrace();//输出异常信息
    		}
    	}
    }
	public void OutputData(){	
		File file = new File("input.txt");//创建文件对象	    
    	if(file.exists()){//判断文件是否存在   	
    		try{   			
    		   FileInputStream in = new FileInputStream(file);   //创建FileInputStream对象，将数据信息从文件中读取出来
    		   Scanner scan =new Scanner(in);//用scan读取string信息(遇到空格,换行就自动换)
    		   int i=0;
    		   while(scan.hasNext()){
    			   TaskId[i]=scan.nextInt();
    			   arrived_time[i]=scan.nextInt();
    			   server_time[i]=scan.nextInt();
    			   i=i+1;
    		   }
               scan.close();
	}catch(Exception e){
		e.printStackTrace();//输出异常信息
	}

    	}
	}
	
}

