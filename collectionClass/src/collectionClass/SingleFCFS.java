package collectionClass;

import java.io.File;
import java.io.FileInputStream;

public class SingleFCFS extends Task{
	public void SingleFCFS(){//�����ȷ���(���߳�)
    	File file = new File("task.txt");
    	int Task_id[] ;
    	Task_id=new int[100];//������
    	int []ServerTime;//����ʱ��
    	ServerTime=new int[100];
    	
    	int []ArrivedTime;//����ʱ��
    	ArrivedTime=new int[100];
    	
    	int startingTime[];//��ʼʱ��
    	startingTime =new int[100];
    	
    	int finishingTime[];//���ʱ��=��ʼʱ��+����ʱ��
    	finishingTime=new int[100];
    	
    	int turnAroundTime[];//��תʱ��=���ʱ��-�ﵽʱ��
    	turnAroundTime=new int[100];
    	
    	float weightTurnAround[] ;//��Ȩ��תʱ��=��תʱ��/����ʱ��
    	weightTurnAround=new float[100];
    	
    	if(file.exists()){//�ж��ļ��Ƿ����   	
    		try{   			
    		   FileInputStream in = new FileInputStream(file);//��������Ϣ���ļ��ж�ȡ����
               for(int i=0;i<100;i++){
            	   int a=in.read();
            	   Task_id[i]=a;
            	   int b=in.read();
            	   ArrivedTime[i] =b;
            	   int c=in.read();            	   
            	   ServerTime[i]=c;           	   
               }
               in.close();
               startingTime[0]=ArrivedTime[0];//��һ������ʼʱ��
               finishingTime[0]=ArrivedTime[0]+ServerTime[0];//��һ���������ʱ��
               turnAroundTime[0]=finishingTime[0]-startingTime[0];//��һ��������תʱ��
               weightTurnAround[0]=turnAroundTime[0]/ServerTime[0];//��һ�������Ȩ��תʱ��
               for(int i=1;i<100;i++){
            	   startingTime[i]=startingTime[i-1]+ServerTime[i-1];
            	   finishingTime[i]=finishingTime[i-1]+ServerTime[i];
            	   turnAroundTime[i]=finishingTime[i]-ArrivedTime[i];
            	   weightTurnAround[i]=turnAroundTime[i]/ServerTime[i];
               }
               for(int i=0;i<100;i++){
            	   System.out.print("��"+(i+1)+"������Ŀ�ʼʱ��:"+startingTime[i]+"     ");
            	   System.out.print("����ʱ��:"+finishingTime[i]+"     ");
            	   System.out.print("��תʱ��:"+turnAroundTime[i]+"     ");
            	   System.out.println("��Ȩ��תʱ��:"+weightTurnAround[i]);
               }
    		}catch(Exception e){
    			e.printStackTrace();//����쳣��Ϣ
    		}
    	}
    	
    }

}
