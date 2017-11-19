package lab5;

import java.io.FileNotFoundException;
import java.io.IOException;

public class MainClass {
	public static void main(String[]args) throws FileNotFoundException, ClassNotFoundException, IOException{
		Student_read_write A = new Student_read_write();
		A.Read_List();
	}
}
