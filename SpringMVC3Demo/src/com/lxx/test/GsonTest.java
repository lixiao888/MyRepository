package com.lxx.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.google.gson.Gson;

public class GsonTest
{
	public static void main(String[] args)
	{
		List<String> strList = new ArrayList<String>();
		Person person = new Person();
		for(int i = 0;i < 10;i++)
		{
			Random rand = new Random();
			int randCount = rand.nextInt(10);
			person.setList(strList);
			strList.add("list_"+randCount);
		}
		
		for(int i = 0;i < 10;i++)
		{
			
			Random rand = new Random();
			int randCount = rand.nextInt(10);
			
		
			
			person.setUsername("zs"+randCount);
			person.setPassword("abc"+randCount);
			person.setAge(randCount);
			person.setAddress("beijing"+randCount);
			
			Gson gson = new Gson();
			String personJson = gson.toJson(person);
			System.out.println(personJson);
		}
		
	}
}
