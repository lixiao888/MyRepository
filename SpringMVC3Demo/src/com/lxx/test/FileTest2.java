package com.lxx.test;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Scanner;

public class FileTest2
{
	static class SuffixFilter implements FilenameFilter
	{
		private String suffix;
		
		public SuffixFilter(String suffix)
		{
			this.suffix = suffix;
		}
		
		@Override
		public boolean accept(File dir,String name)
		{
			return name.endsWith(suffix);
		}
	}
	
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		String path = scanner.next();
		File file = new File(path);
		if(file.exists())
		{
			list(file);
		}else
		{
			System.out.println("目录或文件不存在！");
		}
	}

	private static void list(File file)
	{
		if(file.isDirectory())
		{
			SuffixFilter sf = new SuffixFilter("java");  //采用过滤器(静态内部类)寻找所有指定目录下后缀名为java的文件
			File[] fileArr = file.listFiles(sf);
			for(File subFile:fileArr)
			{
				list(subFile);
			}
			System.out.println("【目录】："+file);
		}else
		{
			System.out.println("【文件】："+file);
		}
	}
}
