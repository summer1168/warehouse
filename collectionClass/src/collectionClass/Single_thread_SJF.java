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
    	
    	float weightTurnAround[]=new float[100];//��Ȩ��תʱ��=��תʱ��/����ʱ��
    	
    	boolean ID[]= new boolean [100];//�ж������Ƿ��Ѿ����
        		
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
    			   if(ServerTime[ready_id]>ServerTime[k]) {
    				   ready_id=k;
    			   }
    		   }
        	   /*��ʱready_id���ѵ��������з���ʱ����̵�����*/
       	   
        	   startingTime[i]=finishingTime[i-1];
        	   
        	   finishingTime[i]=startingTime[i]+ServerTime[ready_id];
        	   
        	   currentTime=finishingTime[i];
        	   
        	   turnAroundTime[i]=finishingTime[i]-ArrivedTime[i];
        	   
        	   weightTurnAround[i]=turnAroundTime[i]/ServerTime[i]; 
        	   
        	   System.out.print("��"+(ready_id+1)+"������"+"�Ŀ�ʼʱ��:"+startingTime[i]+"     ");
        	   System.out.print("����ʱ��:"+finishingTime[i]+"     ");
        	   System.out.print("��תʱ��:"+turnAroundTime[i]+"     ");
        	   System.out.println("��Ȩ��תʱ��:"+weightTurnAround[i]); 
               ID[ready_id]=true;//���������Ѿ����
       }
    }catch(Exception e){
    			e.printStackTrace();//����쳣��Ϣ
    		}
    }
}

 
