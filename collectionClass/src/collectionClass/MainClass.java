package collectionClass;

import java.util.Scanner;

public class MainClass {
	 public static void main(String[] args){//main����
	    	SingleFCFS a=new SingleFCFS();
	    	DoubleFCFS b=new DoubleFCFS();
	    	SingleSJF  c=new SingleSJF();
	    	DoubleSJF  d=new DoubleSJF();
          	a.InputData();//���ļ�����������   	
          	b.InputData();//���ļ�����������   	
          	c.InputData();//���ļ�����������   	
          	d.InputData();//���ļ�����������   	
	    	System.out.println("1���ȵ��ȷ���(���߳�)");
	    	System.out.println("2���ȵ��ȷ���(˫�߳�)");
	    	System.out.println("3������ҵ����(���߳�)");
	    	System.out.println("4������ҵ����(˫�߳�)");
	    	System.out.print("���������ѡ��:");
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
	    			System.out.println("ѡ����󣬽�����");
	    			break;
	    	}       
	    }
}
