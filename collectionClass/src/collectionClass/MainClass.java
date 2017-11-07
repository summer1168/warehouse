package collectionClass;

import java.util.Scanner;

public class MainClass {
	 public static void main(String[] args){//main函数
	    	SingleFCFS a=new SingleFCFS();
	    	DoubleFCFS b=new DoubleFCFS();
	    	SingleSJF  c=new SingleSJF();
	    	DoubleSJF  d=new DoubleSJF();
          	a.InputData();//向文件中输入数据   	
          	b.InputData();//向文件中输入数据   	
          	c.InputData();//向文件中输入数据   	
          	d.InputData();//向文件中输入数据   	
	    	System.out.println("1、先到先服务(单线程)");
	    	System.out.println("2、先到先服务(双线程)");
	    	System.out.println("3、短作业优先(单线程)");
	    	System.out.println("4、短作业优先(双线程)");
	    	System.out.print("请输入你的选择:");
	    	Scanner sc = new Scanner(System.in);
	    	int input = sc.nextInt();
	    	switch(input){
	    		case 1:
	    			a.SingleFCFS();
	    			break;
	    		case 2:
	    			b.DoubleFCFS();
	    			break;
	    		case 3:
	    			c.SingleSJF();
	    			break;
	    		case 4:
	    			d.DoubleSJF();
	    			break;
	    		default:
	    			System.out.println("选择错误，结束！");
	    			break;
	    	}       
	    }
}
