package chocolate;

public class chocolate {
	   private boolean empty=true;
	   private boolean boiled=false;
	   public void fill(){
		   if(isEmpty()){
			   System.out.println("�����ɿ�����");
			   empty=false;
		   }
		   else {
			   System.out.println("�����ɿ�����");
		   }
	   }
	   public void boil(){
		   if(!isBoiled()){
			   System.out.println("��ʼ���ɿ�����");
			   boiled=true;
		   }
		   else {
			   System.out.println("�Ѿ����죬��������");
		   }
	   }
	   public void drain(){
		   if(!isEmpty()&&isBoiled()){
			   empty=true;
			   boiled=false;
			   System.out.println("�ɿ��������ˣ�");
		   }
		   else System.out.println("û���ɿ�����");
	   }
	   public boolean isEmpty(){
		   return empty;   
	   }
	   public boolean isBoiled(){
		    return boiled;
		  
	   }
	   private static chocolate uniquelnstance;
	   public static chocolate getlnstance(){
		   if(uniquelnstance==null){
			   uniquelnstance=new chocolate();
		   }
		   return uniquelnstance;
	   }
	  
	}
