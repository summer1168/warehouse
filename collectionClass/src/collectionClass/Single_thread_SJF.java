package collectionClass;

import java.io.File;
import java.io.FileInputStream;

public class Single_thread_SJF extends Task{
	public void Single_thread_SJF(){//����ҵ����/���߳�
    	File file = new File("task.txt");
    	
    	int startingTime[]=new int[100];//��ʼʱ��
    	
    	int finishingTime[]=new int[100];//���ʱ��=��ʼʱ��+����ʱ��
    	
    	int turnAroundTime[]=new int[100];//��תʱ��=���ʱ��-�ﵽʱ��
    	
    	float weightTurnAround[]=new float[100];//��Ȩ��תʱ��=��תʱ��/����ʱ��
    	
    	boolean ID[]= new boolean [100];//�ж������Ƿ��Ѿ����
    	
    	OutputData();
        		
    		/*try{   			
    		   FileInputStream in = new FileInputStream(file);//���ļ��ж�ȡ������Ϣ
               for(int i=0;i<100;i++){
            	   int a=in.read();
            	   TaskId[i]=a;
            	   int b=in.read();
            	   arrive_time[i] =b;
            	   int c=in.read();            	   
            	   server_time[i]=c;           	   
               }*/
                             
               startingTime[0]=arrived_time[0];//��һ������ʼʱ��
               
               finishingTime[0]=arrived_time[0]+server_time[0];//��һ���������ʱ��
               
               turnAroundTime[0]=finishingTime[0]-startingTime[0];//��һ����תʱ��
               
               weightTurnAround[0]=turnAroundTime[0]/server_time[0];//��һ����Ȩ��תʱ��         
               
               int r_startingTime[]=new int[100];//��ʼʱ��
           	
           	   int r_finishingTime[]=new int[100];//���ʱ��=��ʼʱ��+����ʱ��
           	
           	   int r_turnAroundTime[]=new int[100];//��תʱ��=���ʱ��-�ﵽʱ��
           	
           	   float r_weightTurnAround[]=new float[100];//��Ȩ��תʱ��=��תʱ��/����ʱ��
           	   
           	   r_startingTime[0]=startingTime[0];
           	   
           	   r_finishingTime[0]=finishingTime[0];
           	   
           	   r_turnAroundTime[0]=turnAroundTime[0];
           	   
           	   r_weightTurnAround[0]=weightTurnAround[0];
        	   
        	   int ready_id=1;//��ʱ�洢����ID       
        	   
        	   int NoServerID=1;//��Ƕ�����ǰ��δ������������
        	   
        	   /*����ҵ����
        	    ���ж������Ƿ��Ѿ����
        	  �ж������Ƿ��Ѿ�����
        	  */
        	   int currentTime=finishingTime[0];//��¼�߳��������ʱ��
        	   
        	   for(int i=1;i<100;i++){//������ѭ�����ڿ��������������
            	   for(int j=NoServerID;j<100;j++){
            		   if(ID[j]==false){
            			   ready_id=j;//�ҵ�δ��ʼ����Ķ�����ǰ��
            			   break;
            		   }
            	   }
        	   for(int k=ready_id+1;k<100 && k<=currentTime; k++) {//�ҵ��ѵ���������ʱ���������
    			   if(ID[k]==true) {
    				   continue;
    			   }
    			   if(server_time[ready_id]>server_time[k]) {
    				   ready_id=k;
    			   }
    		   }
        	   /*��ʱready_id���ѵ��������з���ʱ����̵�����*/
       	   
        	   startingTime[i]=finishingTime[i-1];
        	   
        	   finishingTime[i]=startingTime[i]+server_time[ready_id];
        	   
        	   currentTime=finishingTime[i];
        	   
        	   turnAroundTime[i]=finishingTime[i]-arrived_time[ready_id];
        	   
        	   weightTurnAround[i]=turnAroundTime[i]/server_time[ready_id]; 
        	   
        	   ID[ready_id]=true;//���������Ѿ����
        	   
        	   r_startingTime[ready_id]=startingTime[i];
        	   r_finishingTime[ready_id]=finishingTime[i];
        	   r_turnAroundTime[ready_id]=turnAroundTime[i];
        	   r_weightTurnAround[ready_id]=weightTurnAround[i]; 
               
       }
        	   System.out.println("TaskID "+"ArriveTime "+"server_time "+"startingTime "+"finishingTime "+"turnAroundTime "+"weightTurnAround ");
               for(int i=0;i<100;i++){
            	   System.out.print("  "+TaskId[i]+"        ");         	  
            	   System.out.print(arrived_time[i]+"          "); 	      	   
            	   System.out.print(server_time[i]+"          ");
            	   System.out.print(r_startingTime[i]+"          ");
            	   System.out.print(r_finishingTime[i]+"          ");
            	   System.out.print(r_turnAroundTime[i]+"          ");
            	   System.out.print(r_weightTurnAround[i]+"          ");
            	   System.out.println();
               }   
    }
    }


 
