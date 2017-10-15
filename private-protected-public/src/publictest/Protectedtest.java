package publictest;

public class Protectedtest extends Publictest{
   public void print(){
	   //System.out.println("memory"+memory+",cpu"+cpu);同一包下子类无法访问父类私有成员
	   System.out.println("cpu:"+cpu);//可以访问protected类型数据成员
   }
   public static void main(String arg[]){
	   Protectedtest a=new Protectedtest();
	   //a.printmemory();//同一个包中的子类不可视private类型
	   a.printcard();
	   a.print();
   }
}
