package collectionClass;

import java.io.File;
import java.io.FileInputStream;

public class Single_thread_SJF extends Task{
	public void Single_thread_SJF(){//����ҵ����/���߳�
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

               startingTime[0]=ArrivedTime[0];//��һ������ʼʱ��
               finishingTime[0]=ArrivedTime[0]+ServerTime[0];//��һ���������ʱ��
               turnAroundTime[0]=finishingTime[0]-startingTime[0];//��һ����תʱ��
               weightTurnAround[0]=turnAroundTime[0]/ServerTime[0];//��һ����Ȩ��תʱ��            	   
               System.out.print("��1������Ŀ�ʼʱ��:"+startingTime[0]+"     ");
        	   System.out.print("����ʱ��:"+finishingTime[0]+"     ");
        	   System.out.print("��תʱ��:"+turnAroundTime[0]+"     ");
        	   System.out.println("��Ȩ��תʱ��:"+weightTurnAround[0]);
        	   int temp_id;//��ʱ�洢����ID       	   
        	   int temp;//��һ��������ɵ�ʱ��
        	   int temp_AT;//��ʱ����ʱ��
        	   int temp_ST;//��ʱ����ʱ��

               for(int i=1;i<100;i++){//��ʼ�ж϶���ҵ
            	   temp=finishingTime[i-1];//�洢��һ��������ɵ�ʱ��
            	   temp_id=i;
            	   if(temp>=99){
            		   temp=99;
            	   }
            	   
            	   for(int j=i+1;j<=temp ;j++){
            		   if(ServerTime[temp_id]>ServerTime[j]){
            			   temp_id=j;
            		   }
            	   }//����ʱ��С�����Ļ���λ��
            	   
            	   temp_AT=ArrivedTime[i];  
            	   
            	   ArrivedTime[i]=ArrivedTime[temp_id];
            	   
            	   ArrivedTime[temp_id]=temp_AT;     	
            	   
            	   temp_ST=ServerTime[i];         
            	   
            	   ServerTime[i]=ServerTime[temp_id];
            	   
            	   ServerTime[temp_id]=temp_ST;
            	   
            	   startingTime[i]=startingTime[i-1]+ServerTime[i-1];
            	   
            	   finishingTime[i]=finishingTime[i-1]+ServerTime[i];
            	   
            	   turnAroundTime[i]=finishingTime[i]-ArrivedTime[i];
            	   
            	   weightTurnAround[i]=turnAroundTime[i]/ServerTime[i]; 
            	   
            	   System.out.print("��"+(Task_id[i])+"������Ŀ�ʼʱ��:"+startingTime[i]+"     ");
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