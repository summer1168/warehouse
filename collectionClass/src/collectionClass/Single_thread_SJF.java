package collectionClass;

import java.io.File;
import java.io.FileInputStream;

public class Single_thread_SJF extends Task{
	public void Single_thread_SJF(){//短作业优先/单线程
    	File file = new File("task.txt");
    	int Task_id[]=new int[100] ;//任务编号

    	int []ServerTime=new int[100];//服务时间

    	int []ArrivedTime=new int[100];//到达时间
    	
    	int startingTime[]=new int[100];//开始时间
    	
    	int finishingTime[]=new int[100];//完成时间=开始时间+服务时间
    	
    	int turnAroundTime[]=new int[100];//周转时间=完成时间-达到时间
    	
    	float weightTurnAround[]=new float[100];//带权周转时间=周转时间/服务时间
    	
    	boolean ID[]= new boolean [100];//判断任务是否已经完成
        		
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
               
               turnAroundTime[0]=finishingTime[0]-startingTime[0];//第一个周转时间
               
               weightTurnAround[0]=turnAroundTime[0]/ServerTime[0];//第一个带权周转时间         
               
               System.out.print("第1个任务的开始时间:"+startingTime[0]+"     ");
               
        	   System.out.print("结束时间:"+finishingTime[0]+"     ");
        	   
        	   System.out.print("周转时间:"+turnAroundTime[0]+"     ");
        	   
        	   System.out.println("带权周转时间:"+weightTurnAround[0]);
        	   
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
    			   if(ServerTime[ready_id]>ServerTime[k]) {
    				   ready_id=k;
    			   }
    		   }
        	   /*此时ready_id是已到达任务中服务时间最短的任务*/
       	   
        	   startingTime[i]=finishingTime[i-1];
        	   
        	   finishingTime[i]=startingTime[i]+ServerTime[ready_id];
        	   
        	   currentTime=finishingTime[i];
        	   
        	   turnAroundTime[i]=finishingTime[i]-ArrivedTime[i];
        	   
        	   weightTurnAround[i]=turnAroundTime[i]/ServerTime[i]; 
        	   
        	   System.out.print("第"+(ready_id+1)+"个任务"+"的开始时间:"+startingTime[i]+"     ");
        	   System.out.print("结束时间:"+finishingTime[i]+"     ");
        	   System.out.print("周转时间:"+turnAroundTime[i]+"     ");
        	   System.out.println("带权周转时间:"+weightTurnAround[i]); 
               ID[ready_id]=true;//将该任务已经完成
       }
    }catch(Exception e){
    			e.printStackTrace();//输出异常信息
    		}
    }
}

 
