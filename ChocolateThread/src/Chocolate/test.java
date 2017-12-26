package Chocolate;

public class test {
	private static Thread []Chocolateboilere = new Thread[4];
	public static void main(String[] args) throws InterruptedException{
		ChocolateBoiler chocolate =ChocolateBoiler.getI();
		for(int i=0;i<Chocolateboilere.length;i++){
			System.out.println();
			Chocolateboilere[i]=new Thread(chocolate);
			Chocolateboilere[i].run();			
		}
	}
}