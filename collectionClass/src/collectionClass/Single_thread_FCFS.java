package collectionClass;

import java.io.File;
import java.io.FileInputStream;

public class Single_thread_FCFS extends Task{
	public void Single_thread_FCFS(){//�����ȷ���/���߳�
    	File file = new File("task.txt");
    	
    	int startingTime[]=new int[100];//��ʼʱ��
    	
    	int finishingTime[]=new int[100];//���ʱ��=��ʼʱ��+����ʱ��
    	
    	int turnAroundTime[]=new int[100];//��תʱ��=���ʱ��-�ﵽʱ��
    	   	
    	float weightTurnAround[]=new float[100] ;//��Ȩ��תʱ��=��תʱ��/����ʱ��
    	
    	OutputData();
    	
    	/*if(file.exists()){//�ж��ļ��Ƿ����   	
    		try{   			
    		   FileInputStream in = new FileInputStream(file);//���ļ��ж�ȡ������Ϣ
               for(int i=0;i<100;i++){
            	   int a=in.read();
            	   TaskId[i]=a;
            	   int b=in.read();
            	   arrived_time[i] =b;
            	   int c=in.read();            	   
            	   server_time[i]=c;           	   
               }*/
            
               

               
               startingTime[0]=arrived_time[0];//��һ������ʼʱ��
               
               finishingTime[0]=arrived_time[0]+server_time[0];//��һ���������ʱ��
               
               turnAroundTime[0]=finishingTime[0]-startingTime[0];//��һ��������תʱ��
               
               weightTurnAround[0]=turnAroundTime[0]/server_time[0];//��һ�������Ȩ��תʱ��
               
               for(int i=1;i<100;i++){
            	   startingTime[i]=startingTime[i-1]+server_time[i-1];
            	   finishingTime[i]=finishingTime[i-1]+server_time[i];
            	   turnAroundTime[i]=finishingTime[i]-arrived_time[i];
            	   weightTurnAround[i]=turnAroundTime[i]/server_time[i];
               }
               System.out.println("TaskID "+"ArriveTime "+"server_time "+"start_time "+"finish_time "+"turnAroundTime "+"weightTurnAround ");
               for(int i=0;i<100;i++){
            	   System.out.print("  "+TaskId[i]+"          ");         	  
            	   System.out.print(arrived_time[i]+"          "); 	      	   
            	   System.out.print(server_time[i]+"          ");
            	   System.out.print(startingTime[i]+"          ");
            	   System.out.print(finishingTime[i]+"          ");
            	   System.out.print(turnAroundTime[i]+"          ");
            	   System.out.println(weightTurnAround[i]);
               }
    		}
    	
    }


