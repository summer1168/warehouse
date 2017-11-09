package collectionClass;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.Random;

public class Task {
	private int TaskId[];//任务编号
	private int arrived_time[];//到达时间
	private int server_time[];//服务时间
	
	public Task(){
		TaskId= new int[100];
		arrived_time=new int[100];
		server_time=new int[100];		
	}
	
	public void InputData(){
    	File file = new File("task.txt");
    	int[] numbers = {6,2,1,3,9};//在6，2，1，3，9中产生随机数
    	if(file.exists()){
    		try{
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
    	}else{
    		try{//如果文件不存在，则创建
    			file.createNewFile();
    			InputData();
    		}
    		catch(Exception e){
    			e.printStackTrace();//输出异常信息
    		}
    	}
    }
}

