package collectionClass;

import java.io.File;
import java.io.FileInputStream;

public class Both_threaded_SJF extends Task{
	public void Both_threaded_SJF(){//短作业优先/双线程
    	File file = new File("task.txt");
    	
    	int startingTime[]=new int[100];//开始时间
    	
    	int finishingTime[]=new int[100];//完成时间=开始时间+服务时间
    	
    	int turnAroundTime[]=new int[100];//周转时间=完成时间-达到时间
    	
    	float weightTurnAround[]=new float[100] ;//带权周转时间=周转时间/服务时间
    	
    	int r_startingTime[]=new int[100];//开始时间
       	
    	   int r_finishingTime[]=new int[100];//完成时间=开始时间+服务时间
    	
    	   int r_turnAroundTime[]=new int[100];//周转时间=完成时间-达到时间
    	
    	   float r_weightTurnAround[]=new float[100];//带权周转时间=周转时间/服务时间
    	   
    	OutputData();
    	/*if(file.exists()){	
    		try{   			
    		   FileInputStream in = new FileInputStream(file);//从文件中读取数据信息
               for(int i=0;i<100;i++){
            	   int a=in.read();
            	   TaskId[i]=a;
            	   int b=in.read();
            	   arrived_time[i] =b;
            	   int c=in.read();            	   
            	   server_time[i]=c;           	   
               }*/
            
               

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
	    			   if(server_time[ready_id]>server_time[k]) {
	    				   ready_id=k;
	    			   }
	    		   }
            	   if(FirstTime<=arrived_time[ready_id]){//第一线程空闲
            		   startingTime[ready_id]=FirstTime;
            		   
            		   FirstTime=arrived_time[ready_id]+server_time[ready_id];
            		   
            		   finishingTime[ready_id]=FirstTime;
            		   
            		   turnAroundTime[ready_id]=finishingTime[ready_id]-arrived_time[ready_id];
            		   
            		   weightTurnAround[ready_id]=turnAroundTime[ready_id]/server_time[ready_id]; 
            		   		   
            		   r_startingTime[ready_id]=startingTime[ready_id];
            		   
            		   r_finishingTime[ready_id]=finishingTime[ready_id];
            		   
            		   r_turnAroundTime[ready_id]=turnAroundTime[ready_id];
            		   
            		   r_weightTurnAround[ready_id]=weightTurnAround[ready_id];
            	   }else if(SecondTime<=arrived_time[ready_id]){//第一线程正在运行任务，第二线程空闲
            		   
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
            	   }else if(FirstTime<=SecondTime){//第一线程比第二线程提前空闲
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
            	   ID[ready_id]=true;//将该任务已经完成
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

