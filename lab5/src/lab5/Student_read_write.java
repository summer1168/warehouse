package lab5;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;


public class Student_read_write extends StudentList {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3797760677266900667L;
	public void Read_List(){	
		File file =new File("list.txt");
    	try{
    		Scanner sc =new Scanner(new FileInputStream(file));
    		StudentList[] I =new StudentList[40];
    		for(int i=0;i<40;i++){
    			I[i] = new StudentList();
    		}
    		int i=0;
    		while(sc.hasNext()){
    			I[i].StudentID=sc.nextLong();
    			I[i].Name=sc.next();
    			I[i].Sex=sc.next();
    			i=i+1;
    		}
    			sc.close();
    			write(I);
    		}catch(Exception e){
    			e.printStackTrace();//输出异常信息
    		}	    	
    	
	}
	
	public void write(StudentList I[])throws FileNotFoundException,IOException{//这个是写的函数，同时承担着序列化的责任
		int j;
		int i;
		StudentList temp=new StudentList();
		for(i=0;i<40;i++){
			for(j=i+1;j<40;j++){			 
				if(I[i].StudentID>I[j].StudentID){
					temp=I[i];
					I[i]=I[j];
					I[j]=temp;
				}
			}
		}
		write_to_bin(I);
	}
		public void write_to_bin(StudentList I[]) throws FileNotFoundException, IOException{
		File file=new File("student.bin");
		if(file.exists()){
			ObjectOutputStream WriteOb = new ObjectOutputStream(new FileOutputStream(file));
			for(int i=0;i<40;i++){
				WriteOb.writeObject(I[i]);
			}
			WriteOb.close();
        }else{
        	file.createNewFile();
        	write_to_bin(I);
        }
		try {
			read_from_bin();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void read_from_bin()throws FileNotFoundException,IOException, ClassNotFoundException{//重新的文件里面读取出每个人的数据
		ObjectInputStream ReadOb = new ObjectInputStream(new FileInputStream(new File("student.bin")));
		StudentList [] ST;
		ST=new StudentList[40];
		for(int i=0;i<40;i++){
			ST[i] = new StudentList();
		}
		for(int i=0;i<40;i++){
			ST[i]=(StudentList)ReadOb.readObject();
			System.out.print(ST[i].StudentID+"  ");
			System.out.print(ST[i].Name+"  ");
			System.out.println(ST[i].Sex);
		}
		ReadOb.close();
	}
}
