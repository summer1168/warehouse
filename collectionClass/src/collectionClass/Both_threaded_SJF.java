package collectionClass;

import java.io.File;
import java.io.FileInputStream;

public class Both_threaded_SJF extends Task{
	public void Both_threaded_SJF(){//����ҵ����/˫�߳�
    	File file = new File("task.txt");
    	
    	int startingTime[]=new int[100];//��ʼʱ��
    	
    	int finishingTime[]=new int[100];//���ʱ��=��ʼʱ��+����ʱ��
    	
    	int turnAroundTime[]=new int[100];//��תʱ��=���ʱ��-�ﵽʱ��
    	
    	float weightTurnAround[]=new float[100] ;//��Ȩ��תʱ��=��תʱ��/����ʱ��
    	
    	int r_startingTime[]=new int[100];//��ʼʱ��
       	
    	   int r_finishingTime[]=new int[100];//���ʱ��=��ʼʱ��+����ʱ��
    	
    	   int r_turnAroundTime[]=new int[100];//��תʱ��=���ʱ��-�ﵽʱ��
    	
    	   float r_weightTurnAround[]=new float[100];//��Ȩ��תʱ��=��תʱ��/����ʱ��
    	   
    	OutputData();
    	/*if(file.exists()){	
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
            
               

	           int FirstTime=0;//��һ�̵߳�ʱ��
	           
	           int SecondTime=0;//�ڶ��̵߳�ʱ��
	           
	           boolean ID[]= new boolean [100];//�ж������Ƿ��Ѿ����
	           
	           int NoServerID=0;//��Ƕ�����ǰ��δ������������
	           
	           int ready_id=0;//�ѵ���Ķ���ҵ�������
	           
               for(int i=0;i<100;i++){
            	   for(int j=NoServerID;j<100;j++){
            		   if(ID[j]==false){
            			   ready_id=j;//1
            			   break;
            		   }
            	   }
            	   NoServerID=ready_id;//1
	       		   for(int k=ready_id+1;k<100 && k<=FirstTime && k<=SecondTime ; k++) {//�ҵ��ѵ���������ʱ���������
	    			   if(ID[k]==true) {//2 ʱ��1��ʱ������2�Ѿ����� ��ʱ�߳�1����æµ״̬
	    				   continue;
	    			   }
	    			   if(server_time[ready_id]>server_time[k]) {
	    				   ready_id=k;
	    			   }
	    		   }
            	   if(FirstTime<=arrived_time[ready_id]){//��һ�߳̿���
            		   startingTime[ready_id]=FirstTime;
            		   
            		   FirstTime=arrived_time[ready_id]+server_time[ready_id];
            		   
            		   finishingTime[ready_id]=FirstTime;
            		   
            		   turnAroundTime[ready_id]=finishingTime[ready_id]-arrived_time[ready_id];
            		   
            		   weightTurnAround[ready_id]=turnAroundTime[ready_id]/server_time[ready_id]; 
            		   		   
            		   r_startingTime[ready_id]=startingTime[ready_id];
            		   
            		   r_finishingTime[ready_id]=finishingTime[ready_id];
            		   
            		   r_turnAroundTime[ready_id]=turnAroundTime[ready_id];
            		   
            		   r_weightTurnAround[ready_id]=weightTurnAround[ready_id];
            	   }else if(SecondTime<=arrived_time[ready_id]){//��һ�߳������������񣬵ڶ��߳̿���
            		   
            		   if(SecondTime==0){
            			   SecondTime=arrived_time[ready_id];
            		   }
            		   
            		   startingTime[ready_id]=SecondTime;
            		   
            		   SecondTime=arrived_time[ready_id]+server_time[ready_id];
            		   
            		   finishingTime[ready_id]=SecondTime;
            		   
            		   turnAroundTime[ready_id]=finishingTime[ready_id]-arrived_time[ready_id];
            		   
            		   weightTurnAround[ready_id]=turnAroundTime[ready_id]/server_time[ready_id];   
            		   
                       r_startingTime[ready_id]=startingTime[ready_id];
            		   
            		   r_finishingTime[ready_id]=finishingTime[ready_id];
            		   
            		   r_turnAroundTime[ready_id]=turnAroundTime[ready_id];
            		   
            		   r_weightTurnAround[ready_id]=weightTurnAround[ready_id];
            	   }else if(FirstTime<=SecondTime){//��һ�̱߳ȵڶ��߳���ǰ����
            		   startingTime[ready_id]=FirstTime;
            		   
            		   FirstTime=FirstTime+server_time[ready_id];
            		   
            		   finishingTime[ready_id]=FirstTime;
            		   
            		   turnAroundTime[ready_id]=finishingTime[ready_id]-arrived_time[ready_id];
            		   
            		   weightTurnAround[ready_id]=turnAroundTime[ready_id]/server_time[ready_id];   
            		   
                       r_startingTime[ready_id]=startingTime[ready_id];
            		   
            		   r_finishingTime[ready_id]=finishingTime[ready_id];
            		   
            		   r_turnAroundTime[ready_id]=turnAroundTime[ready_id];
            		   
            		   r_weightTurnAround[ready_id]=weightTurnAround[ready_id];

            	   }else{
            		   startingTime[ready_id]=SecondTime;
            		   
            		   SecondTime=SecondTime+server_time[ready_id];
            		   
            		   finishingTime[ready_id]=SecondTime;
            		   
            		   turnAroundTime[ready_id]=finishingTime[ready_id]-arrived_time[ready_id];
            		   
            		   weightTurnAround[ready_id]=turnAroundTime[ready_id]/server_time[ready_id];  
            		   
                       r_startingTime[ready_id]=startingTime[ready_id];
            		   
            		   r_finishingTime[ready_id]=finishingTime[ready_id];
            		   
            		   r_turnAroundTime[ready_id]=turnAroundTime[ready_id];
            		   
            		   r_weightTurnAround[ready_id]=weightTurnAround[ready_id];
            	   }
            	   ID[ready_id]=true;//���������Ѿ����
               }
               
               
               System.out.println("TaskID "+"ArriveTime "+"server_time "+"startingTime "+"finishingTime "+"turnAroundTime "+"weightTurnAround ");
               for(int i=0;i<100;i++){
            	   System.out.print("  "+TaskId[i]+"        ");         	  
            	   System.out.print(arrived_time[i]+"          "); 	      	   
            	   System.out.print(server_time[i]+"             ");
            	   System.out.print(r_startingTime[i]+"          ");
            	   System.out.print(r_finishingTime[i]+"              ");
            	   System.out.print(r_turnAroundTime[i]+"          ");
            	   System.out.print(r_weightTurnAround[i]+"          ");
            	   System.out.println();
               }   
    		}
    }

