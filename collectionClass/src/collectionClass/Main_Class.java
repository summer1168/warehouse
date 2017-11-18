package collectionClass;

import java.util.Scanner;

public class Main_Class {
	 public static void main(String[] args){//main函数	  	
	    	System.out.println("请选择:1、先到先服务/单线程  2、先到先服务/双线程  3、短作业优先/单线程 4、短作业优先/双线程");
	    	Scanner in = new Scanner(System.in);
	    	int input = in.nextInt();
	    	switch(input){
	    		case 1:
	    			Single_thread_FCFS F1=new Single_thread_FCFS();
	    			F1.InputData(); //初始化任务列表
	    			F1.Single_thread_FCFS();
	    			break;
	    		case 2:
	    			Both_threaded_FCFS F2=new Both_threaded_FCFS();
	    			F2.InputData();//初始化任务列表
	    			F2.Both_threaded_FCFS();
	    			break;
	    		case 3:
	    			Single_thread_SJF  S1=new Single_thread_SJF();
	    			S1.InputData(); //初始化任务列表
	    			S1.Single_thread_SJF();
	    			break;
	    		case 4:
	    			Both_threaded_SJF  S2=new Both_threaded_SJF(); 
	    			S2.InputData(); //初始化任务列表
	    			S2.Both_threaded_SJF();
	    			break;
	    		default:
	    			System.out.println("选择错误，结束！");
	    			break;
	    	}       
	    }
}
