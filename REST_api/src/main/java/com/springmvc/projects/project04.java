package com.springmvc.projects;

import java.lang.reflect.*;

public class project04 {

	public static void main(String[] args) throws ClassNotFoundException
	{
		Class<?> user = Class.forName("projects.User");
		System.out.println("======= 필드목록 ======");
		for(Field field : user.getFields())
		{
			System.out.println(field.getName());
		}
		
		System.out.println("");
		System.out.println("==== 생성자 목록 ====");
		for(Constructor<?> constructor : user.getConstructors())
		{
			System.out.print("개수 " + constructor.getParameterCount() + " = ");
			for(Class<?> parameter : constructor.getParameterTypes())
			{
				System.out.print(parameter.getName() + " / ");
			}
			System.out.println();
		}
		
		System.out.println("\n ==== 메서드 목록 ====");
		for(Method method : user.getMethods())
		{
			System.out.println(method.getName());
		}
	}
		
	

}
