package chocolate;

public class chocolate {
	   private boolean empty=true;
	   private boolean boiled=false;
	   public void fill(){
		   if(isEmpty()){
			   System.out.println("加入巧克力！");
			   empty=false;
		   }
		   else {
			   System.out.println("已有巧克力！");
		   }
	   }
	   public void boil(){
		   if(!isBoiled()){
			   System.out.println("开始煮巧克力！");
			   boiled=true;
		   }
		   else {
			   System.out.println("已经煮熟，无需再煮！");
		   }
	   }
	   public void drain(){
		   if(!isEmpty()&&isBoiled()){
			   empty=true;
			   boiled=false;
			   System.out.println("巧克力做好了！");
		   }
		   else System.out.println("没有巧克力！");
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
