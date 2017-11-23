package collectionClass;

import java.io.File;
import java.io.FileInputStream;
import java.util.Scanner;

public class Both_threaded_FCFS extends Task{
	public void Both_threaded_FCFS(){//先到先服务/双线程
    	//File file = new File("task.txt");
    	
    	
    	int startingTime[]=new int[100];//开始时间
    	
    	int finishingTime[]=new int[100];//完成时间=开始时间+服务时间
    	
    	int turnAroundTime[]=new int[100];//周转时间=完成时间-达到时间
    	
    	float weightTurnAround[]=new float[100] ;//带权周转时间=周转时间/服务时间
    	
    	OutputData();
    	
    	/*if(file.exists()){	
    		try{   			
    		   FileInputStream in = new FileInputStream(file);   //从文件中读取数据信息
               for(int i=0;i<100;i++){
            	   int a=in.read();
            	   TaskId[i]=a;         	  
            	   int b=in.read();
            	   arrived_time[i] =b; 	   
            	   int c=in.read();    	   
            	   server_time[i]=c;           	   
               }*/
             
               
               

    			
    			File file = new File("input.txt");//创建文件对象	    
    	    	if(file.exists()){//判断文件是否存在   	
    	    		try{   			
    	    		   FileInputStream in = new FileInputStream(file);   //创建FileInputStream对象，将数据信息从文件中读取出来
    	    		   Scanner scan =new Scanner(in);//用scan读取string信息(遇到空格,换行就自动换)
    	    		   int i=0;
    	    		   while(scan.hasNext()){
    	    			   TaskId[i]=scan.nextInt();
    	    			   arrived_time[i]=scan.nextInt();
    	    			   server_time[i]=scan.nextInt();
    	    			   i=i+1;
    	    		   }
    	               scan.close();
               
               int FirstTime=0;//第一线程的时间
               
               int SecondTime=0;//第二线程的时间
               
               int MarkTask[];//用作标记
               
               MarkTask=new int[100];
               
               for(i=0;i<100;i++){
            	   if(FirstTime<=arrived_time[i]){//第一线程无任务
            		   
            		   startingTime[i]=FirstTime;//记录任务的开始时间	
            		   
            		   FirstTime=server_time[i]+arrived_time[i];
            		   
            		   finishingTime[i]=FirstTime;	
            		   
            		   MarkTask[i]=1;
            		   
            	   }else if(SecondTime<=arrived_time[i]){//第一线程正在工作，而第二线程空闲
            		   
            		   if(SecondTime==0){
            			   SecondTime=arrived_time[i];
            		   }
            		   
            		   startingTime[i]=SecondTime;		
            		   
            		   SecondTime=server_time[i]+arrived_time[i];   
            		   
            		   finishingTime[i]=SecondTime;
            		   
            		   MarkTask[i]=2;
            	   }else if(FirstTime<=SecondTime){//第一，第二线程都在工作，判断先结束任务的线程
            		   
            		   startingTime[i]=FirstTime;    
            		   
            		   FirstTime=FirstTime+server_time[i]; 
            		   
            		   finishingTime[i]=FirstTime;
            		   
            		   MarkTask[i]=1;
            		   
            	   }else{
            		   startingTime[i]=SecondTime;     
            		   
            		   SecondTime=server_time[i]+SecondTime; 	
            		   
            		   finishingTime[i]=SecondTime;
            		   
            		   MarkTask[i]=2;
            	   }
               }
               /*计算周转时间，带权周转时间*/
               for(i=0;i<100;i++){
            	   turnAroundTime[i]=finishingTime[i]-arrived_time[i];   	   
            	   weightTurnAround[i]=turnAroundTime[i]/server_time[i];
               }
               
               System.out.println("TaskID "+"ArriveTime "+"server_time "+"startingTime "+"finishingTime "+"turnAroundTime "+"weightTurnAround ");
               for(i=0;i<100;i++){
            	   System.out.print("  "+TaskId[i]+"        ");         	  
            	   System.out.print(arrived_time[i]+"          "); 	      	   
            	   System.out.print(server_time[i]+"           ");
            	   System.out.print(startingTime[i]+"          ");
            	   System.out.print(finishingTime[i]+"                  ");
            	   System.out.print(turnAroundTime[i]+"                 ");
            	   System.out.println(weightTurnAround[i]);            		   
            	   }
    		}catch(Exception e){
    			e.printStackTrace();//输出异常信息
    		}
    	}
    }
}
