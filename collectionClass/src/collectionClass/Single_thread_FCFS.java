package collectionClass;

import java.io.File;
import java.io.FileInputStream;

public class Single_thread_FCFS extends Task{
	public void Single_thread_FCFS(){//�����ȷ���/���߳�
    	File file = new File("task.txt");
    	int Task_id[]=new int[100] ;//������
    	
    	int []ServerTime=new int[100];//����ʱ��
    	
    	int []ArrivedTime=new int[100];//����ʱ��
    	
    	int startingTime[]=new int[100];//��ʼʱ��
    	
    	int finishingTime[]=new int[100];//���ʱ��=��ʼʱ��+����ʱ��
    	
    	int turnAroundTime[]=new int[100];//��תʱ��=���ʱ��-�ﵽʱ��
    	
    	float weightTurnAround[]=new float[100] ;//��Ȩ��תʱ��=��תʱ��/����ʱ��
    	
    	if(file.exists()){//�ж��ļ��Ƿ����   	
    		try{   			
    		   FileInputStream in = new FileInputStream(file);//���ļ��ж�ȡ������Ϣ
               for(int i=0;i<100;i++){
            	   int a=in.read();
            	   Task_id[i]=a;
            	   int b=in.read();
            	   ArrivedTime[i] =b;
            	   int c=in.read();            	   
            	   ServerTime[i]=c;           	   
               }
               System.out.println("TaskID "+"ArriveTime "+"ServerTime ");
               for(int i=0;i<100;i++){
            	   System.out.print("  "+Task_id[i]+"        ");         	  
            	   System.out.print(ArrivedTime[i]+"          "); 	      	   
            	   System.out.print(ServerTime[i]);
            	   System.out.println();
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
