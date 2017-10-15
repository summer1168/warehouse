package publictest;

import java.awt.print.Printable;

public class Publictest {
   public double screen=15.6;
   private String memory="8G";
   protected String cpu="i7";
   String card="1050Ti";
   public void printscreen(){
	   System.out.println(screen);
   }
   private void printmemory(){
	   System.out.println(memory);
   }
   protected void printcpu(){
	   System.out.println(cpu);
   }
   void printcard(){
	   System.out.println(card);
   }
   public void print(){
	   System.out.println("screen:"+screen+",memory:"+memory+",cpu:"+cpu+",card:"+card);
   }
   public static void main(String arg[]){
	   Publictest a=new Publictest();
	   a.printscreen();
	   a.printmemory();
	   a.printcpu();
	   a.printcard();
	   a.print();
   }
}
