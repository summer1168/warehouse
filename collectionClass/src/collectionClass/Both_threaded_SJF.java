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
	           
	           boolean ID[];//�ж������Ƿ��Ѿ����
	           ID = new boolean [100];
	           
	           int NoServerID=0;//��Ƕ�����ǰ��δ������������
	           int min=0;//�����ҵ�������
	           
               for(int i=0;i<100;i++){
            	   for(int j=NoServerID;j<100;j++){
            		   if(ID[j]==false){
            			   min=j;
            			   break;
            		   }
            	   }
            	   NoServerID=min;
	       		   for(int k=min+1;k<100 && k<=FirstTime && k<=SecondTime ; k++) {//�ҵ��ѵ���������ʱ���������
	    			   if(ID[k]==true) {
	    				   continue;
	    			   }
	    			   if(ServerTime[min]>ServerTime[k]) {
	    				   min=k;
	    			   }
	    		   }
            	   if(FirstTime<=ArrivedTime[min]){//��һ�߳̿���
            		   startingTime[min]=FirstTime;
            		   FirstTime=ArrivedTime[min]+ServerTime[min];
            		   finishingTime[min]=FirstTime;
            		   turnAroundTime[min]=finishingTime[min]-ArrivedTime[min];
            		   weightTurnAround[min]=turnAroundTime[min]/ServerTime[min];            		   
            		   System.out.print("��"+(min+1)+"�������ڵ�һ�߳��н��У���ʼʱ����");
            		   System.out.print(startingTime[min]+",����ʱ����"+finishingTime[min]+",");
            		   System.out.print("��תʱ��"+turnAroundTime[min]+",");
            		   System.out.println("��Ȩ��תʱ����"+weightTurnAround[min]);
            	   }else if(SecondTime<=ArrivedTime[min]){//��һ�߳������������񣬵ڶ��߳̿���
            		   startingTime[min]=SecondTime;
            		   SecondTime=ArrivedTime[min]+ServerTime[min];
            		   finishingTime[min]=SecondTime;
            		   turnAroundTime[min]=finishingTime[min]-ArrivedTime[min];
            		   weightTurnAround[min]=turnAroundTime[min]/ServerTime[min];            		   
            		   System.out.print("��"+(min+1)+"�������ڵڶ��߳��н��У���ʼʱ����");
            		   System.out.print(startingTime[min]+",����ʱ����"+finishingTime[min]+",");
            		   System.out.print("��תʱ��"+turnAroundTime[min]+",");
            		   System.out.println("��Ȩ��תʱ����"+weightTurnAround[min]);
            	   }else if(FirstTime<=SecondTime){//��һ�̱߳ȵڶ��߳���ǰ����
            		   startingTime[min]=FirstTime;
            		   FirstTime=FirstTime+ServerTime[min];
            		   finishingTime[min]=FirstTime;
            		   turnAroundTime[min]=finishingTime[min]-ArrivedTime[min];
            		   weightTurnAround[min]=turnAroundTime[min]/ServerTime[min];            		   
            		   System.out.print("���ǵ�"+(min+1)+"�������ڵ�һ�߳��н��У���ʼʱ����");
            		   System.out.print(startingTime[min]+",����ʱ����"+finishingTime[min]+",");
            		   System.out.print("��תʱ��"+turnAroundTime[min]+",");
            		   System.out.println("��Ȩ��תʱ����"+weightTurnAround[min]);

            	   }else{
            		   startingTime[min]=SecondTime;
            		   SecondTime=SecondTime+ServerTime[min];
            		   finishingTime[min]=SecondTime;
            		   turnAroundTime[min]=finishingTime[min]-ArrivedTime[min];
            		   weightTurnAround[min]=turnAroundTime[min]/ServerTime[min];            		   
            		   System.out.print("���ǵ�"+(min+1)+"�������ڵڶ��߳��н��У���ʼʱ����");
            		   System.out.print(startingTime[min]+",����ʱ����"+finishingTime[min]+",");
            		   System.out.print("��תʱ��"+turnAroundTime[min]+",");
            		   System.out.println("��Ȩ��תʱ����"+weightTurnAround[min]);
            	   }
            	   ID[min]=true;//���������Ѿ����
               }

    		}catch(Exception e){
    			e.printStackTrace();//����쳣��Ϣ
    		}
    	}
    }
}
