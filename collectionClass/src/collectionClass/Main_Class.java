package collectionClass;

import java.util.Scanner;

public class Main_Class {
	 public static void main(String[] args){//main����	  	
	    	System.out.println("��ѡ��:1���ȵ��ȷ���/���߳�  2���ȵ��ȷ���/˫�߳�  3������ҵ����/���߳� 4������ҵ����/˫�߳�");
	    	Scanner in = new Scanner(System.in);
	    	int input = in.nextInt();
	    	switch(input){
	    		case 1:
	    			Single_thread_FCFS F1=new Single_thread_FCFS();
	    			F1.InputData(); //��ʼ�������б�
	    			F1.Single_thread_FCFS();
	    			break;
	    		case 2:
	    			Both_threaded_FCFS F2=new Both_threaded_FCFS();
	    			F2.InputData();//��ʼ�������б�
	    			F2.Both_threaded_FCFS();
	    			break;
	    		case 3:
	    			Single_thread_SJF  S1=new Single_thread_SJF();
	    			S1.InputData(); //��ʼ�������б�
	    			S1.Single_thread_SJF();
	    			break;
	    		case 4:
	    			Both_threaded_SJF  S2=new Both_threaded_SJF(); 
	    			S2.InputData(); //��ʼ�������б�
	    			S2.Both_threaded_SJF();
	    			break;
	    		default:
	    			System.out.println("ѡ����󣬽�����");
	    			break;
	    	}       
	    }
}
