package collectionClass;

import java.io.File;
import java.io.FileInputStream;
import java.util.Scanner;

public class Both_threaded_FCFS extends Task{
	public void Both_threaded_FCFS(){//�ȵ��ȷ���/˫�߳�
    	//File file = new File("task.txt");
    	
    	
    	int startingTime[]=new int[100];//��ʼʱ��
    	
    	int finishingTime[]=new int[100];//���ʱ��=��ʼʱ��+����ʱ��
    	
    	int turnAroundTime[]=new int[100];//��תʱ��=���ʱ��-�ﵽʱ��
    	
    	float weightTurnAround[]=new float[100] ;//��Ȩ��תʱ��=��תʱ��/����ʱ��
    	
    	OutputData();
    	
    	/*if(file.exists()){	
    		try{   			
    		   FileInputStream in = new FileInputStream(file);   //���ļ��ж�ȡ������Ϣ
               for(int i=0;i<100;i++){
            	   int a=in.read();
            	   TaskId[i]=a;         	  
            	   int b=in.read();
            	   arrived_time[i] =b; 	   
            	   int c=in.read();    	   
            	   server_time[i]=c;           	   
               }*/
             
               
               

    			
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
               
               int FirstTime=0;//��һ�̵߳�ʱ��
               
               int SecondTime=0;//�ڶ��̵߳�ʱ��
               
               int MarkTask[];//�������
               
               MarkTask=new int[100];
               
               for(i=0;i<100;i++){
            	   if(FirstTime<=arrived_time[i]){//��һ�߳�������
            		   
            		   startingTime[i]=FirstTime;//��¼����Ŀ�ʼʱ��	
            		   
            		   FirstTime=server_time[i]+arrived_time[i];
            		   
            		   finishingTime[i]=FirstTime;	
            		   
            		   MarkTask[i]=1;
            		   
            	   }else if(SecondTime<=arrived_time[i]){//��һ�߳����ڹ��������ڶ��߳̿���
            		   
            		   if(SecondTime==0){
            			   SecondTime=arrived_time[i];
            		   }
            		   
            		   startingTime[i]=SecondTime;		
            		   
            		   SecondTime=server_time[i]+arrived_time[i];   
            		   
            		   finishingTime[i]=SecondTime;
            		   
            		   MarkTask[i]=2;
            	   }else if(FirstTime<=SecondTime){//��һ���ڶ��̶߳��ڹ������ж��Ƚ���������߳�
            		   
            		   startingTime[i]=FirstTime;    
            		   
            		   FirstTime=FirstTime+server_time[i]; 
            		   
            		   finishingTime[i]=FirstTime;
            		   
            		   MarkTask[i]=1;
            		   
            	   }else{
            		   startingTime[i]=SecondTime;     
            		   
            		   SecondTime=server_time[i]+SecondTime; 	
            		   
            		   finishingTime[i]=SecondTime;
            		   
            		   MarkTask[i]=2;
            	   }
               }
               /*������תʱ�䣬��Ȩ��תʱ��*/
               for(i=0;i<100;i++){
            	   turnAroundTime[i]=finishingTime[i]-arrived_time[i];   	   
            	   weightTurnAround[i]=turnAroundTime[i]/server_time[i];
               }
               
               System.out.println("TaskID "+"ArriveTime "+"server_time "+"startingTime "+"finishingTime "+"turnAroundTime "+"weightTurnAround ");
               for(i=0;i<100;i++){
            	   System.out.print("  "+TaskId[i]+"        ");         	  
            	   System.out.print(arrived_time[i]+"          "); 	      	   
            	   System.out.print(server_time[i]+"           ");
            	   System.out.print(startingTime[i]+"          ");
            	   System.out.print(finishingTime[i]+"                  ");
            	   System.out.print(turnAroundTime[i]+"                 ");
            	   System.out.println(weightTurnAround[i]);            		   
            	   }
    		}catch(Exception e){
    			e.printStackTrace();//����쳣��Ϣ
    		}
    	}
    }
}
