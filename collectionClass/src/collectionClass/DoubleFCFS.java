package collectionClass;

import java.io.File;
import java.io.FileInputStream;

public class DoubleFCFS extends Task{
	public void DoubleFCFS(){//�ȵ��ȷ���˫�̣߳�
    	File file = new File("task.txt");
    	int Task_id[] ;
    	Task_id=new int[100];
    	int []ServerTime;
    	ServerTime=new int[100];
    	int []ArrivedTime;
    	ArrivedTime=new int[100];
    	
    	int startingTime[];//��ʼʱ��
    	startingTime =new int[100];
    	
    	int finishingTime[];//���ʱ��=��ʼʱ��+����ʱ��
    	finishingTime=new int[100];
    	
    	int turnAroundTime[];//��תʱ��=���ʱ��-�ﵽʱ��
    	turnAroundTime=new int[100];
    	
    	float weightTurnAround[] ;//��Ȩ��תʱ��=��תʱ��/����ʱ��
    	weightTurnAround=new float[100];
    	
    	if(file.exists()){	
    		try{   			
    		   FileInputStream in = new FileInputStream(file);   //���ļ��ж�ȡ������Ϣ
               for(int i=0;i<100;i++){
            	   int a=in.read();
            	   Task_id[i]=a;
            	   int b=in.read();
            	   ArrivedTime[i] =b;
            	   int c=in.read();            	   
            	   ServerTime[i]=c;           	   
               }
               in.close();
               int FirstTime=0;//��һ�̵߳�ʱ��
               int SecondTime=0;//�ڶ��̵߳�ʱ��
               int MarkTask[];//�������
               MarkTask=new int[100];
               for(int i=0;i<100;i++){
            	   if(FirstTime<=ArrivedTime[i]){//��һ�߳�������
            		   startingTime[i]=FirstTime;//��¼����Ŀ�ʼʱ��
            		   FirstTime=ServerTime[i]+ArrivedTime[i];
            		   finishingTime[i]=FirstTime;
            		   MarkTask[i]=1;
            	   }else if(SecondTime<=ArrivedTime[i]){//��һ�߳����ڹ��������ڶ��߳̿���
            		   startingTime[i]=SecondTime;
            		   SecondTime=ServerTime[i]+ArrivedTime[i];
            		   finishingTime[i]=SecondTime;
            		   MarkTask[i]=2;
            	   }else if(FirstTime<=SecondTime){//��һ���ڶ��̶߳��ڹ������ж��Ƚ���������߳�
            		   startingTime[i]=FirstTime;
            		   FirstTime=FirstTime+ServerTime[i];
            		   finishingTime[i]=FirstTime;
            		   MarkTask[i]=1;
            	   }else{
            		   startingTime[i]=SecondTime;
            		   SecondTime=ServerTime[i]+SecondTime;
            		   finishingTime[i]=SecondTime;
            		   MarkTask[i]=2;
            	   }
               }
               /*������תʱ�䣬��Ȩ��תʱ��*/
               for(int i=0;i<100;i++){
            	   turnAroundTime[i]=finishingTime[i]-ArrivedTime[i];
            	   weightTurnAround[i]=turnAroundTime[i]/ServerTime[i];
               }
               
               for(int i=0;i<100;i++){
            	   if(MarkTask[i]==1){
            		   System.out.print("��"+(i+1)+"��������");
            		   System.out.print("��һ�߳̽���,��ʼʱ����"+startingTime[i]+",");
            		   System.out.print("����ʱ����"+finishingTime[i]+",");
            		   System.out.print("��תʱ����"+turnAroundTime[i]+",");
            		   System.out.println("��Ȩ��תʱ����"+weightTurnAround[i]);            		   
            	   }else{
            		   System.out.print("��"+(i+1)+"��������");
            		   System.out.print("�ڶ��߳̽���,��ʼʱ����"+startingTime[i]+",");
            		   System.out.print("����ʱ����"+finishingTime[i]+",");
            		   System.out.print("��תʱ����"+turnAroundTime[i]+",");
            		   System.out.println("��Ȩ��תʱ����"+weightTurnAround[i]);
            	   }
               }
    		}catch(Exception e){
    			e.printStackTrace();//����쳣��Ϣ
    		}
    	}
    }
}
