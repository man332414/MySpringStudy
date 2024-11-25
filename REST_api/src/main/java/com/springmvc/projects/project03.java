package com.springmvc.projects;

import java.io.InputStream;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

public class project03 {

	public static void main(String[] args) 
	{
		String src = "info.json";
		//IO-Stream(스트림) : 읽어오기 위해서 InputStream을 사용함
		InputStream is=project03.class.getResourceAsStream(src);
		// Project03과 같은 폴더에 위치해 있으므로 해당 위치에서 src 파일을 inputstream으로 읽어온다.
		if(is==null)
		{
			throw new NullPointerException("Connot find resource file");
		}
		
		// InputStream으로 받은 문자영ㄹ을 JSON 형태로 메모리에 로딩한다.
		JSONTokener tokener = new JSONTokener(is);
		//JSONObject 타입으로 변환한다. 이제 key:value 형태로 사용가능하다
		JSONObject object = new JSONObject(tokener);
		//JSON 객체 안에 students Array를 Students에 옮겨담는다.
		JSONArray students = object.getJSONArray("students");
		
		for(int i=0; i<students.length(); i++)
		{
			JSONObject student = (JSONObject)students.getJSONObject(i);
			System.out.print(student.get("name")+"\t");
			System.out.print(student.get("address")+"\t");
			System.out.println(student.get("phone"));
		}
	}

}
