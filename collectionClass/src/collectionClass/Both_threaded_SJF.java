package collectionClass;

import java.io.File;
import java.io.FileInputStream;

public class Both_threaded_SJF extends Task{
	public void Both_threaded_SJF(){//����ҵ����/˫�߳�
    	File file = new File("task.txt");
    	int Task_id[]=new int[100] ;//������

    	int []ServerTime=new int[100];//����ʱ��

    	int []ArrivedTime=new int[100];//����ʱ��
    	
    	int startingTime[]=new int[100];//��ʼʱ��
    	
    	int finishingTime[]=new int[100];//���ʱ��=��ʼʱ��+����ʱ��
    	
    	int turnAroundTime[]=new int[100];//��תʱ��=���ʱ��-�ﵽʱ��
    	
    	float weightTurnAround[]=new float[100] ;//��Ȩ��תʱ��=��תʱ��/����ʱ��
    
    	if(file.exists()){	
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
	    			   if(ServerTime[ready_id]>ServerTime[k]) {
	    				   ready_id=k;
	    			   }
	    		   }
            	   if(FirstTime<=ArrivedTime[ready_id]){//��һ�߳̿���
            		   startingTime[ready_id]=FirstTime;
            		   
            		   FirstTime=ArrivedTime[ready_id]+ServerTime[ready_id];
            		   
            		   finishingTime[ready_id]=FirstTime;
            		   
            		   turnAroundTime[ready_id]=finishingTime[ready_id]-ArrivedTime[ready_id];
            		   
            		   weightTurnAround[ready_id]=turnAroundTime[ready_id]/ServerTime[ready_id];   
            		   		   
            		   System.out.print("��"+(ready_id+1)+"�������ڵ�һ�߳��н��У���ʼʱ����");
            		   
            		   System.out.print(startingTime[ready_id]+",����ʱ����"+finishingTime[ready_id]+",");
            		   
            		   System.out.print("��תʱ��"+turnAroundTime[ready_id]+",");
            		   
            		   System.out.println("��Ȩ��תʱ����"+weightTurnAround[ready_id]);
            	   }else if(SecondTime<=ArrivedTime[ready_id]){//��һ�߳������������񣬵ڶ��߳̿���
            		   
            		   if(SecondTime==0){
            			   SecondTime=ArrivedTime[ready_id];
            		   }
            		   
            		   startingTime[ready_id]=SecondTime;
            		   
            		   SecondTime=ArrivedTime[ready_id]+ServerTime[ready_id];
            		   
            		   finishingTime[ready_id]=SecondTime;
            		   
            		   turnAroundTime[ready_id]=finishingTime[ready_id]-ArrivedTime[ready_id];
            		   
            		   weightTurnAround[ready_id]=turnAroundTime[ready_id]/ServerTime[ready_id];   
            		   
            		   System.out.print("��"+(ready_id+1)+"�������ڵڶ��߳��н��У���ʼʱ����");
            		   System.out.print(startingTime[ready_id]+",����ʱ����"+finishingTime[ready_id]+",");
            		   System.out.print("��תʱ��"+turnAroundTime[ready_id]+",");
            		   System.out.println("��Ȩ��תʱ����"+weightTurnAround[ready_id]);
            	   }else if(FirstTime<=SecondTime){//��һ�̱߳ȵڶ��߳���ǰ����
            		   startingTime[ready_id]=FirstTime;
            		   
            		   FirstTime=FirstTime+ServerTime[ready_id];
            		   
            		   finishingTime[ready_id]=FirstTime;
            		   
            		   turnAroundTime[ready_id]=finishingTime[ready_id]-ArrivedTime[ready_id];
            		   
            		   weightTurnAround[ready_id]=turnAroundTime[ready_id]/ServerTime[ready_id];   
            		   
            		   System.out.print("��"+(ready_id+1)+"�������ڵ�һ�߳��н��У���ʼʱ����");
            		   System.out.print(startingTime[ready_id]+",����ʱ����"+finishingTime[ready_id]+",");
            		   System.out.print("��תʱ��"+turnAroundTime[ready_id]+",");
            		   System.out.println("��Ȩ��תʱ����"+weightTurnAround[ready_id]);

            	   }else{
            		   startingTime[ready_id]=SecondTime;
            		   
            		   SecondTime=SecondTime+ServerTime[ready_id];
            		   
            		   finishingTime[ready_id]=SecondTime;
            		   
            		   turnAroundTime[ready_id]=finishingTime[ready_id]-ArrivedTime[ready_id];
            		   
            		   weightTurnAround[ready_id]=turnAroundTime[ready_id]/ServerTime[ready_id];  
            		   
            		   System.out.print("��"+(ready_id+1)+"�������ڵڶ��߳��н��У���ʼʱ����");
            		   System.out.print(startingTime[ready_id]+",����ʱ����"+finishingTime[ready_id]+",");
            		   System.out.print("��תʱ��"+turnAroundTime[ready_id]+",");
            		   System.out.println("��Ȩ��תʱ����"+weightTurnAround[ready_id]);
            	   }
            	   ID[ready_id]=true;//���������Ѿ����
               }

    		}catch(Exception e){
    			e.printStackTrace();//����쳣��Ϣ
    		}
    	}
    }
}
