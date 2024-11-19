package com.springmvc.chapter09;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.springmvc.DTO.Member;

@Controller
public class Example01Controller 
{
	@GetMapping("/")
	public String backHome()
	{
		return "home";
	}
	
	@GetMapping("/form")
	public String requestForm()
	{
		System.out.println("Controller.requestFrom() 입장");
		return "webpage09_01";
	}
	
	@PostMapping("/form")
	public String submitForm(@RequestParam("name") String name, 
							 @RequestParam("fileImage") MultipartFile file,
							 HttpServletRequest req)
	{
		System.out.println("Controller.submitFrom() 입장 파라미터 잘 가져왔어? : " + name);
		String filename = file.getOriginalFilename();
		String save = req.getServletContext().getRealPath("/resources/image");
		System.out.println("내가 받은 변수의 값 : "+save);
		File f = new File(save+"\\"+name+"_"+filename);
		try 
		{
			file.transferTo(f);
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		return "webpage09_submit";
	}
	
	@GetMapping("/exam03/form")
	public String requestForm03(Member member)
	{
		System.out.println("exam/form 연결");
		return "webpage09_02";
	}

	@PostMapping("/exam03/form")
	public String submitForm03(@ModelAttribute Member member, HttpServletRequest req, HttpSession session)
	{
		System.out.println("exam/form 연결 : " + member.getName());
		//step1 : 파일이름생성
		String name = member.getName();
		long milisec = System.currentTimeMillis();
		String filename = member.getImageFile().getOriginalFilename();
		String save = req.getServletContext().getRealPath("resources/image");
		//step2 : 비어있는 파일 생성
		File file = new File(save+"/"+name+milisec+filename);
		//step3 : 파일 작성
		try 
		{
			member.getImageFile().transferTo(file);
		}
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "webpage09_submit";
	}

}
