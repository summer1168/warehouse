package lab5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Compare {
    public static void main(String[] args) throws IOException, ParseException  
    {  
    	SimpleDateFormat time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SS");//闹钟
    	String start =time.format(new Date());//获取有缓冲区的开始时间
    	File readFile=new File("read.txt");
		File writeFile=new File("write.txt");
		FileReader in=new FileReader(readFile);
		FileWriter out=new FileWriter(writeFile);		
		BufferedReader read =new BufferedReader(in);
		BufferedWriter write=new BufferedWriter(out);
		String s=null;
		while((s=read.readLine())!=null){
			write.write(s);
		}
		read.close();
		write.close();
		String finish=time.format(new Date());//获取无缓冲区的结束时间
		System.out.println("有缓冲文件读取输入花费的时间："+(time.parse(finish).getTime() - time.parse(start).getTime())+" ms");
		
		String begin=time.format(new Date());//获取无缓冲区的开始时间
        FileInputStream inn=new FileInputStream(readFile);//读取文件信息
		FileOutputStream outt =new FileOutputStream(writeFile);//写入文件信息
		int i;
		while((i=inn.read())!=-1){
			outt.write(i);
		}
		inn.close();
		outt.close();
		String end=time.format(new Date());//获取缓冲区的结束时间
		System.out.println("没有缓冲文件读取输入花费的时间："+(time.parse(end).getTime() - time.parse(begin).getTime())+" ms");	
    }
  }    


