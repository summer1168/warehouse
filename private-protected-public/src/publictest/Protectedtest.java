package publictest;

public class Protectedtest extends Publictest{
   public void print(){
	   //System.out.println("memory"+memory+",cpu"+cpu);ͬһ���������޷����ʸ���˽�г�Ա
	   System.out.println("cpu:"+cpu);//���Է���protected�������ݳ�Ա
   }
   public static void main(String arg[]){
	   Protectedtest a=new Protectedtest();
	   //a.printmemory();//ͬһ�����е����಻����private����
	   a.printcard();
	   a.print();
   }
}
