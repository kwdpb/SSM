package com.kw.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Scanner;

import org.apache.commons.io.FileDeleteStrategy;

public class run2 {
	
	public static void main(String[] args) {
		
		
		/*System.out.println("请输入一个具体路径");  //File的基本操作
		Scanner scanner=new Scanner(System.in);
		String pathName=scanner.next();
		File file=new File(pathName);
		if(!file.exists()){
			try {
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("文件是否存在:"+file.exists()+"文件名称:"+file.getName()+"绝对路径:"+file.getAbsolutePath());*/
		
		String pathname="E:\\Web\\2.txt";  //FileinputStream和FileoutputStream
		FileInputStream fStream=null;
		FileOutputStream oStream=null;
		try {
			fStream=new FileInputStream(pathname);
			int value=fStream.read();
			System.out.println("文件中的内容是:"+(char)value);
			oStream=new FileOutputStream("E:\\Web\\1.txt");
			for(int i=0;i<10;i++)
			oStream.write(65);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				fStream.close();
				oStream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
	
	
}
