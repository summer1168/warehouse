package collectionClass;

import java.io.File;
import java.io.FileInputStream;

public class Both_threaded_SJF extends Task{
	public void Both_threaded_SJF(){//短作业优先/双线程
    	File file = new File("task.txt");
    	int Task_id[]=new int[100] ;//任务编号

    	int []ServerTime=new int[100];//服务时间

    	int []ArrivedTime=new int[100];//到达时间
    	
    	int startingTime[]=new int[100];//开始时间
    	
    	int finishingTime[]=new int[100];//完成时间=开始时间+服务时间
    	
    	int turnAroundTime[]=new int[100];//周转时间=完成时间-达到时间
    	
    	float weightTurnAround[]=new float[100] ;//带权周转时间=周转时间/服务时间
    
    	if(file.exists()){	
    		try{   			
    		   FileInputStream in = new FileInputStream(file);//从文件中读取数据信息
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
	           int FirstTime=0;//第一线程的时间
	           
	           int SecondTime=0;//第二线程的时间
	           
	           boolean ID[]= new boolean [100];//判断任务是否已经完成
	           
	           int NoServerID=0;//标记队列最前方未服务任务的序号
	           
	           int ready_id=0;//已到达的短作业所在序号
	           
               for(int i=0;i<100;i++){
            	   for(int j=NoServerID;j<100;j++){
            		   if(ID[j]==false){
            			   ready_id=j;//1
            			   break;
            		   }
            	   }
            	   NoServerID=ready_id;//1
	       		   for(int k=ready_id+1;k<100 && k<=FirstTime && k<=SecondTime ; k++) {//找到已到达任务中时间最短任务
	    			   if(ID[k]==true) {//2 时间1的时候任务2已经到达 这时线程1处于忙碌状态
	    				   continue;
	    			   }
	    			   if(ServerTime[ready_id]>ServerTime[k]) {
	    				   ready_id=k;
	    			   }
	    		   }
            	   if(FirstTime<=ArrivedTime[ready_id]){//第一线程空闲
            		   startingTime[ready_id]=FirstTime;
            		   
            		   FirstTime=ArrivedTime[ready_id]+ServerTime[ready_id];
            		   
            		   finishingTime[ready_id]=FirstTime;
            		   
            		   turnAroundTime[ready_id]=finishingTime[ready_id]-ArrivedTime[ready_id];
            		   
            		   weightTurnAround[ready_id]=turnAroundTime[ready_id]/ServerTime[ready_id];   
            		   		   
            		   System.out.print("第"+(ready_id+1)+"个任务在第一线程中进行，开始时间是");
            		   
            		   System.out.print(startingTime[ready_id]+",结束时间是"+finishingTime[ready_id]+",");
            		   
            		   System.out.print("周转时间"+turnAroundTime[ready_id]+",");
            		   
            		   System.out.println("带权周转时间是"+weightTurnAround[ready_id]);
            	   }else if(SecondTime<=ArrivedTime[ready_id]){//第一线程正在运行任务，第二线程空闲
            		   
            		   if(SecondTime==0){
            			   SecondTime=ArrivedTime[ready_id];
            		   }
            		   
            		   startingTime[ready_id]=SecondTime;
            		   
            		   SecondTime=ArrivedTime[ready_id]+ServerTime[ready_id];
            		   
            		   finishingTime[ready_id]=SecondTime;
            		   
            		   turnAroundTime[ready_id]=finishingTime[ready_id]-ArrivedTime[ready_id];
            		   
            		   weightTurnAround[ready_id]=turnAroundTime[ready_id]/ServerTime[ready_id];   
            		   
            		   System.out.print("第"+(ready_id+1)+"个任务在第二线程中进行，开始时间是");
            		   System.out.print(startingTime[ready_id]+",结束时间是"+finishingTime[ready_id]+",");
            		   System.out.print("周转时间"+turnAroundTime[ready_id]+",");
            		   System.out.println("带权周转时间是"+weightTurnAround[ready_id]);
            	   }else if(FirstTime<=SecondTime){//第一线程比第二线程提前空闲
            		   startingTime[ready_id]=FirstTime;
            		   
            		   FirstTime=FirstTime+ServerTime[ready_id];
            		   
            		   finishingTime[ready_id]=FirstTime;
            		   
            		   turnAroundTime[ready_id]=finishingTime[ready_id]-ArrivedTime[ready_id];
            		   
            		   weightTurnAround[ready_id]=turnAroundTime[ready_id]/ServerTime[ready_id];   
            		   
            		   System.out.print("第"+(ready_id+1)+"个任务在第一线程中进行，开始时间是");
            		   System.out.print(startingTime[ready_id]+",结束时间是"+finishingTime[ready_id]+",");
            		   System.out.print("周转时间"+turnAroundTime[ready_id]+",");
            		   System.out.println("带权周转时间是"+weightTurnAround[ready_id]);

            	   }else{
            		   startingTime[ready_id]=SecondTime;
            		   
            		   SecondTime=SecondTime+ServerTime[ready_id];
            		   
            		   finishingTime[ready_id]=SecondTime;
            		   
            		   turnAroundTime[ready_id]=finishingTime[ready_id]-ArrivedTime[ready_id];
            		   
            		   weightTurnAround[ready_id]=turnAroundTime[ready_id]/ServerTime[ready_id];  
            		   
            		   System.out.print("第"+(ready_id+1)+"个任务在第二线程中进行，开始时间是");
            		   System.out.print(startingTime[ready_id]+",结束时间是"+finishingTime[ready_id]+",");
            		   System.out.print("周转时间"+turnAroundTime[ready_id]+",");
            		   System.out.println("带权周转时间是"+weightTurnAround[ready_id]);
            	   }
            	   ID[ready_id]=true;//将该任务已经完成
               }

    		}catch(Exception e){
    			e.printStackTrace();//输出异常信息
    		}
    	}
    }
}
