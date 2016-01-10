package com.lxx.test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileTest
{
	public static void main(String[] args)
	{
		List<String> strList = new ArrayList<String>();
		strList.add("src/com/lxx/ttt");
		strList.add("src/com/lxx/xxx");
		strList.add("src/com/lxx/jjj");
		for(int i = 0 ;i<strList.size();i++)
		{
			File file = new File(strList.get(i));
			file.mkdirs();
		}
		
		File myFile = new File("src/com/lxx/test");
		String parentFile = myFile.getParent();
		File[] fileArr = myFile.listFiles();
		for(File file:fileArr)
		{
			if(file.isDirectory())
			{
				System.out.print("目录：");
			}else
			{
				System.out.print("文件：");
			}
			System.out.println(file);
		}
		
	}
}
