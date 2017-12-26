public class Sum extends Thread{
	private static Thread []Add = new Thread[4];//创建四个线程
	static int Sum=0;
		int num;
		public Sum(int number){
			num=number;
		}
		
		public void run(){//重写run()方法
			int count=0;
			for(int i=0;i<25;i++){
				count=count+num;
				if(i==24)
					System.out.print(num);
				else
					System.out.print(num+"+");
				num++;
				
			}
			Sum=Sum+count;
			System.out.print("="+count);
}
		
		public static void main(String []args) throws InterruptedException{
			for(int i=0;i<Add.length;i++){//i是线程数量
				int number=i*25+1;
				Add[i]= new Thread (new Sum(number));
				System.out.print("线程"+(i+1)+":");
				Add[i].start();
				Add[i].join();
				System.out.println();
			}
			System.out.println("总和："+Sum);
		}
	}
