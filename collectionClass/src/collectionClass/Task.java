package collectionClass;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.Random;

public class Task {
	private int TaskId[];//任务编号
	private int arrived_time[];//到达时间
	private int server_time[];//服务时间
	
	public Task(){//构建函数
		TaskId= new int[100];
		arrived_time=new int[100];
		server_time=new int[100];		
	}
	
	public void InputData(){  //将数据输入到文件里面 	 
    	File file = new File("task.txt");//创建文件对象
    	int[] numbers = {6,2,1,3,9};//在这个范围里面产生随机数
    	if(file.exists()){//判断文件是否存在
    		try{
    			FileOutputStream out = new FileOutputStream(file);//创建FileOutputStream对象，将数据信息写入到文件中
    			OutputStreamWriter osw = new OutputStreamWriter(out, "gbk");
    			for(int i=0;i<100;i++){
    				TaskId[i]=i+1;//赋予任务编号
    				osw.write(TaskId[i]);
    				
    				arrived_time[i]=i;//赋予任务达到时间
    				osw.write(arrived_time[i]);
    				
    	    		Random random = new Random();//利用随机数，来选择任务的服务时间
    	    		int index = random.nextInt(numbers.length);
    	    		server_time[i]=numbers[index];
    	    		osw.write(server_time[i]);   	    		
    			}
    			osw.close();
    		}catch(Exception e){
    			e.printStackTrace();//输出异常信息
    		}
    	}else{//不存在的话，新建文件
    		try{//try语句块捕捉可能出现的异常
    			file.createNewFile();//创建该文件 
    			InputData();
    		}
    		catch(Exception e){
    			e.printStackTrace();//输出异常信息
    		}
    	}
    }
}

