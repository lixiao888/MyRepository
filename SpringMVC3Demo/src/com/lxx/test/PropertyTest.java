package com.lxx.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;
import com.lxx.util.ProjectPathUtil;

public class PropertyTest
{
	public static void main(String[] args) throws Exception
	{
		String classPath = ProjectPathUtil.getProjectPath();
		String propertiesPath = classPath + "test.properties";
		File file = new File(propertiesPath);
		Properties properties = new Properties();
		properties.load(new FileInputStream(file));  //也可用properties.load(PropertyTest.class.getClassLoader().getResourceAsStream("test.properties"))直接获取classpath下的文件
		System.out.println(properties.getProperty("ls"));
		
		properties.store(new FileOutputStream(new File("test.properties")), "This is good!");
		
		Properties systemProperties = System.getProperties();
		systemProperties.storeToXML(new FileOutputStream("system.xml"),null);
	}
}
