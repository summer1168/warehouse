package exercise;

import java.util.Scanner; 
public class exercise {
	public static void run(){//�ж��Ƿ�������
	   int num=0;
	   for(int age=1990;age<=2007;age++){
	   if(age%4==0&&age%100!=0){
		   System.out.print(age+" ");
		   num++;
		   if(num%2==0){System.out.println();}
	   }
	   else if(age%400==0){
		   System.out.print(age+" ");
		   num++;
		   if(num%2==0){System.out.println();}
	   }
	}
}
	public static void ToGradeScore(){//�ٷ��Ƴɼ�ת��Ϊ�ȼ��ɼ�
		Scanner sc = new Scanner(System.in); 
		System.out.println("������5���ɼ�:");
		   int Grade[]=new int[5];
		   int i;
		   for(i=0;i<5;i++){
			Grade[i]= sc.nextInt();    //��ȡ��������
		   }
		   for(i=0;i<5;i++){
			   if(90<=Grade[i]&&Grade[i]<=100) System.out.println("��");
			   if(80<=Grade[i]&&Grade[i]<=89) System.out.println("��");
			   if(70<=Grade[i]&&Grade[i]<=79) System.out.println("��");
			   if(60<=Grade[i]&&Grade[i]<=69) System.out.println("����");
			   if(0<=Grade[i]&&Grade[i]<=59) System.out.println("������");
		   }
	}
	public static void printpicture(){
		String a=" ";
		String b="*";
		int h=7;
		for(int i = 1;i <= h;i++){  
		    if(i <= h/2 + 1){  
		        for(int k = 1;k <= h/2 + 1- i;k++){  
		            System.out.print(a);  
		        }  
		        for(int k = 1;k <= 2*i-1;k++){  
		            System.out.print(b);  
		        }  
		            System.out.println();  
		    }else{  
		        for(int k =1;k <= (i -(h/2 + 1));k++){  
		            System.out.print(a);  
		        }  
		        for(int k = 1;k <= 2*(2 *(h/2 + 1) - i)-1;k++){  
		            System.out.print(b);  
		        }  
		        System.out.println();  
		    }     
		
		}
		
	}
	public static void flower(){
		int a;
		int b;
		int c;
		for(int i=100;i<=999;i++){
			a=i/100;
			b=(i%100)/10;
			c=i%10;
			if(a*a*a+b*b*b+c*c*c==i){
				System.out.println(i);
			}
		}
	}
   public static void main(String[] args){
	   System.out.println("������ҵ���1-4");
	   Scanner sc = new Scanner(System.in); 
	   int x=sc.nextInt(); 
		   switch(x){
		   case 1:run();break;
		   case 2:ToGradeScore();break;
		   case 3:printpicture();break;
		   case 4:flower();break;
	   }
   }
}