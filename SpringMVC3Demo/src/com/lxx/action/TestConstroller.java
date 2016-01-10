package com.lxx.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.google.gson.Gson;

@Controller
public class TestConstroller
{
	@RequestMapping(value = "/login/{user}", method = RequestMethod.GET)
	public ModelAndView myMethod(HttpServletRequest request, HttpServletResponse response,
			@PathVariable("user") String user, ModelMap modelMap) throws Exception
	{
		modelMap.put("loginUser", user);
		return new ModelAndView("login/hello", modelMap);
	}

	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public String registPost(HttpServletRequest request)
	{
        List<Object> strList = new ArrayList<Object>();
        strList.add("test");
        strList.add(true);
        strList.add(new Date());
        strList.add(123);
        request.setAttribute("strList", strList);
		
		return "welcome";
	}
	
	@RequestMapping(value = "/myInput", method = RequestMethod.POST)
	public void ajaxCheck(String inputStr,HttpServletResponse response)
	{
		response.setContentType("application/json;charset=utf-8");  
        response.setHeader("Cache-Control", "no-cache");  
		try {  
            PrintWriter pw = response.getWriter();  
           
            Map<String,String> map = new HashMap<String,String>();
            map.put("test", inputStr);
            map.put("ka", "123");
            
            //将Java对象转换为JSON字符串  
            String gsonStr = new Gson().toJson(map);  
            
            System.out.println(gsonStr);
            
            //输出JSON字符串  
            pw.print(gsonStr);  
            pw.flush();  
            pw.close();  
              
        } catch (IOException e) {  
            System.out.println("输出GSON出错：" + e);  
        }   
	}

}
