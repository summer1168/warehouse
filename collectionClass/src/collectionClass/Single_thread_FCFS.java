package collectionClass;

import java.io.File;
import java.io.FileInputStream;

public class Single_thread_FCFS extends Task{
	public void Single_thread_FCFS(){//先来先服务/单线程
    	File file = new File("task.txt");
    	int Task_id[]=new int[100] ;//任务编号
    	
    	int []ServerTime=new int[100];//服务时间
    	
    	int []ArrivedTime=new int[100];//到达时间
    	
    	int startingTime[]=new int[100];//开始时间
    	
    	int finishingTime[]=new int[100];//完成时间=开始时间+服务时间
    	
    	int turnAroundTime[]=new int[100];//周转时间=完成时间-达到时间
    	
    	float weightTurnAround[]=new float[100] ;//带权周转时间=周转时间/服务时间
    	
    	if(file.exists()){//判断文件是否存在   	
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
               
               startingTime[0]=ArrivedTime[0];//第一个服务开始时间
               
               finishingTime[0]=ArrivedTime[0]+ServerTime[0];//第一个服务结束时间
               
               turnAroundTime[0]=finishingTime[0]-startingTime[0];//第一个服务周转时间
               
               weightTurnAround[0]=turnAroundTime[0]/ServerTime[0];//第一个服务带权周转时间
               
               for(int i=1;i<100;i++){
            	   startingTime[i]=startingTime[i-1]+ServerTime[i-1];
            	   finishingTime[i]=finishingTime[i-1]+ServerTime[i];
            	   turnAroundTime[i]=finishingTime[i]-ArrivedTime[i];
            	   weightTurnAround[i]=turnAroundTime[i]/ServerTime[i];
               }
               for(int i=0;i<100;i++){
            	   System.out.print("第"+(i+1)+"个任务的开始时间:"+startingTime[i]+"     ");
            	   System.out.print("结束时间:"+finishingTime[i]+"     ");
            	   System.out.print("周转时间:"+turnAroundTime[i]+"     ");
            	   System.out.println("带权周转时间:"+weightTurnAround[i]);
               }
    		}catch(Exception e){
    			e.printStackTrace();//输出异常信息
    		}
    	}
    	
    }

}
