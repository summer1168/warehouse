package collectionClass;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.Random;

public class Task {
	private int TaskId[];//������
	private int arrived_time[];//����ʱ��
	private int server_time[];//����ʱ��
	
	public Task(){
		TaskId= new int[100];
		arrived_time=new int[100];
		server_time=new int[100];		
	}
	
	public void InputData(){
    	File file = new File("task.txt");
    	int[] numbers = {6,2,1,3,9};//��6��2��1��3��9�в��������
    	if(file.exists()){
    		try{
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
    	}else{
    		try{//����ļ������ڣ��򴴽�
    			file.createNewFile();
    			InputData();
    		}
    		catch(Exception e){
    			e.printStackTrace();//����쳣��Ϣ
    		}
    	}
    }
}

