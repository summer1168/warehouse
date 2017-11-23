package collectionClass;

import java.io.File;
import java.io.FileInputStream;

public class Single_thread_SJF extends Task{
	public void Single_thread_SJF(){//短作业优先/单线程
    	File file = new File("task.txt");
    	
    	int startingTime[]=new int[100];//开始时间
    	
    	int finishingTime[]=new int[100];//完成时间=开始时间+服务时间
    	
    	int turnAroundTime[]=new int[100];//周转时间=完成时间-达到时间
    	
    	float weightTurnAround[]=new float[100];//带权周转时间=周转时间/服务时间
    	
    	boolean ID[]= new boolean [100];//判断任务是否已经完成
    	
    	OutputData();
        		
    		/*try{   			
    		   FileInputStream in = new FileInputStream(file);//从文件中读取数据信息
               for(int i=0;i<100;i++){
            	   int a=in.read();
            	   TaskId[i]=a;
            	   int b=in.read();
            	   arrive_time[i] =b;
            	   int c=in.read();            	   
            	   server_time[i]=c;           	   
               }*/
                             
               startingTime[0]=arrived_time[0];//第一个服务开始时间
               
               finishingTime[0]=arrived_time[0]+server_time[0];//第一个服务结束时间
               
               turnAroundTime[0]=finishingTime[0]-startingTime[0];//第一个周转时间
               
               weightTurnAround[0]=turnAroundTime[0]/server_time[0];//第一个带权周转时间         
               
               int r_startingTime[]=new int[100];//开始时间
           	
           	   int r_finishingTime[]=new int[100];//完成时间=开始时间+服务时间
           	
           	   int r_turnAroundTime[]=new int[100];//周转时间=完成时间-达到时间
           	
           	   float r_weightTurnAround[]=new float[100];//带权周转时间=周转时间/服务时间
           	   
           	   r_startingTime[0]=startingTime[0];
           	   
           	   r_finishingTime[0]=finishingTime[0];
           	   
           	   r_turnAroundTime[0]=turnAroundTime[0];
           	   
           	   r_weightTurnAround[0]=weightTurnAround[0];
        	   
        	   int ready_id=1;//暂时存储任务ID       
        	   
        	   int NoServerID=1;//标记队列最前方未服务任务的序号
        	   
        	   /*短作业优先
        	    先判断任务是否已经完成
        	  判断任务是否已经到达
        	  */
        	   int currentTime=finishingTime[0];//记录线程任务完成时间
        	   
        	   for(int i=1;i<100;i++){//最外层的循环用于控制所有任务都完成
            	   for(int j=NoServerID;j<100;j++){
            		   if(ID[j]==false){
            			   ready_id=j;//找到未开始服务的队伍最前列
            			   break;
            		   }
            	   }
        	   for(int k=ready_id+1;k<100 && k<=currentTime; k++) {//找到已到达任务中时间最短任务
    			   if(ID[k]==true) {
    				   continue;
    			   }
    			   if(server_time[ready_id]>server_time[k]) {
    				   ready_id=k;
    			   }
    		   }
        	   /*此时ready_id是已到达任务中服务时间最短的任务*/
       	   
        	   startingTime[i]=finishingTime[i-1];
        	   
        	   finishingTime[i]=startingTime[i]+server_time[ready_id];
        	   
        	   currentTime=finishingTime[i];
        	   
        	   turnAroundTime[i]=finishingTime[i]-arrived_time[ready_id];
        	   
        	   weightTurnAround[i]=turnAroundTime[i]/server_time[ready_id]; 
        	   
        	   ID[ready_id]=true;//将该任务已经完成
        	   
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


 
