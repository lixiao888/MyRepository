package com.lxx.util;

/**
 * 获取项目相对路径工具类
 * @author lxx
 */
public class ProjectPathUtil
{

	/**
	 * 获取项目相对路径
	 * 截取之后的结果为：盘符/工作空间/项目名/
	 * @return
	 */
	public static String getProjectPath()
	{
		String str=new ProjectPathUtil().getClass().getResource("/").toString(); 
		String path=str.substring(str.indexOf("/")+1);
		return path;
	}
	
}
