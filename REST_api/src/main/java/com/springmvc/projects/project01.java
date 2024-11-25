package com.springmvc.projects;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.springmvc.dto.BookDTO;

public class project01 
{
	public static void main(String[] args)
	{
		// 1. Object(bookDTO) -> JSON(String) : 객체를 JSON으로 변환하기
		BookDTO dto = new BookDTO("자바", 21000, "에이콘", 670);
		Gson g = new Gson();
		String json = g.toJson(dto);
		System.out.println("g.toJson(dto) : "+json);
		
		// 2. JSON(String) -> Object(bookDTO) : JSON을 객체로 변경하기
		BookDTO dto1 = g.fromJson(json, BookDTO.class);
		System.out.println("g.fromJson"+dto1);
		
		//3. Object(List<bookDTO>) -> JSON(String) : [{}. {} ...] : 배열을 JSON으로 바꾸기
		List<BookDTO> lst = new ArrayList<BookDTO>();
		lst.add(new BookDTO("자바1", 21000, "에이콘1", 570));
		lst.add(new BookDTO("자바2", 31000, "에이콘2", 670));
		lst.add(new BookDTO("자바3", 11000, "에이콘3", 370));
		
		String lstJson = g.toJson(lst);
		System.out.println("g.toJson(lst) : " + lstJson);
		
		//4. JSON(String) -> Object(List<bookDTO)
		List<BookDTO> lst1 = g.fromJson(lstJson, new TypeToken<List<BookDTO>>() {}.getType());
		int i = 1;
		for(BookDTO vo : lst1) 
		{
			System.out.println("g.fromJson(lstJson, new TypeToken<List<bookDTO>>() {}.getType())(" + i + ") : "+vo);
			i++;
		}
	}
}
