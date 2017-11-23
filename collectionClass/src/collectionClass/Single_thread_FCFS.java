package collectionClass;

import java.io.File;
import java.io.FileInputStream;

public class Single_thread_FCFS extends Task{
	public void Single_thread_FCFS(){//先来先服务/单线程
    	File file = new File("task.txt");
    	
    	int startingTime[]=new int[100];//开始时间
    	
    	int finishingTime[]=new int[100];//完成时间=开始时间+服务时间
    	
    	int turnAroundTime[]=new int[100];//周转时间=完成时间-达到时间
    	   	
    	float weightTurnAround[]=new float[100] ;//带权周转时间=周转时间/服务时间
    	
    	OutputData();
    	
    	/*if(file.exists()){//判断文件是否存在   	
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
            
               

               
               startingTime[0]=arrived_time[0];//第一个服务开始时间
               
               finishingTime[0]=arrived_time[0]+server_time[0];//第一个服务结束时间
               
               turnAroundTime[0]=finishingTime[0]-startingTime[0];//第一个服务周转时间
               
               weightTurnAround[0]=turnAroundTime[0]/server_time[0];//第一个服务带权周转时间
               
               for(int i=1;i<100;i++){
            	   startingTime[i]=startingTime[i-1]+server_time[i-1];
            	   finishingTime[i]=finishingTime[i-1]+server_time[i];
            	   turnAroundTime[i]=finishingTime[i]-arrived_time[i];
            	   weightTurnAround[i]=turnAroundTime[i]/server_time[i];
               }
               System.out.println("TaskID "+"ArriveTime "+"server_time "+"start_time "+"finish_time "+"turnAroundTime "+"weightTurnAround ");
               for(int i=0;i<100;i++){
            	   System.out.print("  "+TaskId[i]+"          ");         	  
            	   System.out.print(arrived_time[i]+"          "); 	      	   
            	   System.out.print(server_time[i]+"          ");
            	   System.out.print(startingTime[i]+"          ");
            	   System.out.print(finishingTime[i]+"          ");
            	   System.out.print(turnAroundTime[i]+"          ");
            	   System.out.println(weightTurnAround[i]);
               }
    		}
    	
    }


