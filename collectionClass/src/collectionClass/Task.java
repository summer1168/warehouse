package collectionClass;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.Random;

public class Task {
	private int TaskId[];//������
	private int arrived_time[];//����ʱ��
	private int server_time[];//����ʱ��
	
	public Task(){//��������
		TaskId= new int[100];
		arrived_time=new int[100];
		server_time=new int[100];		
	}
	
	public void InputData(){  //���������뵽�ļ����� 	 
    	File file = new File("task.txt");//�����ļ�����
    	int[] numbers = {6,2,1,3,9};//�������Χ������������
    	if(file.exists()){//�ж��ļ��Ƿ����
    		try{
    			FileOutputStream out = new FileOutputStream(file);//����FileOutputStream���󣬽�������Ϣд�뵽�ļ���
    			OutputStreamWriter osw = new OutputStreamWriter(out, "gbk");
    			for(int i=0;i<100;i++){
    				TaskId[i]=i+1;//����������
    				osw.write(TaskId[i]);
    				
    				arrived_time[i]=i;//��������ﵽʱ��
    				osw.write(arrived_time[i]);
    				
    	    		Random random = new Random();//�������������ѡ������ķ���ʱ��
    	    		int index = random.nextInt(numbers.length);
    	    		server_time[i]=numbers[index];
    	    		osw.write(server_time[i]);   	    		
    			}
    			osw.close();
    		}catch(Exception e){
    			e.printStackTrace();//����쳣��Ϣ
    		}
    	}else{//�����ڵĻ����½��ļ�
    		try{//try���鲶׽���ܳ��ֵ��쳣
    			file.createNewFile();//�������ļ� 
    			InputData();
    		}
    		catch(Exception e){
    			e.printStackTrace();//����쳣��Ϣ
    		}
    	}
    }
}

