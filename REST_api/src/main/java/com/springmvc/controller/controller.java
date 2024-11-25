package com.springmvc.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Date;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller("/REST_api")
public class controller 
{
	@GetMapping
	public String home()
	{
		return "home";
	}
	
	@GetMapping("/project05")
	public String project05()
	{
		String client_id = "ywb8f46qc5";
		String client_secret = "atsoCvT2sygF1M9TP4DGz8oVJsN7oL7AyxaA9R81";
		
		/* 키보드를 통하여 InputStreamReader 클래스를 통해 바이트 단위로 입력받고 라인단위로 읽기
		 * 위해서 버퍼리더를 연결함.
		 */
		
		try 
		{
			//step1: 파라미터 확보하기 (검색할 주소 정보를 콘솔로 확보)
			BufferedReader io = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("주소를 입력하세요");
			String address = io.readLine();
			/* 입력받는 문자열의 공백으로 인해서
			 * 데이터를 끝으로 인식하므로
			 * UTF-8로 변경하면 %20으로 변환됨
			 * 즉, 데이터 토큰이 공백을 통해서 판단됨.
			 */
			String addr = URLEncoder.encode(address, "UTF-8");
			
			//Step2 : URL 작성하기
			//https://naveropenapi.apigw.ntruss.com/map-geocode/v2/geocode?query=
			String reqUrl = "https://naveropenapi.apigw.ntruss.com/map-geocode/v2/geocode?query="+addr;
			
			//Step3 : 작성된 URL을 이용하여 커넥션을 생성
			URL url = new URL(reqUrl);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("x-ncp-apigw-api-key-id", client_id);
			con.setRequestProperty("x-ncp-apigw-api-key", client_secret);
			
			//Step4 : 요청후 응답데이터 수신하기
			int responseCode = con.getResponseCode();
			
			BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
			
			//Step 5 : 수신한 데이터 문자열
			String line;
			StringBuffer data = new StringBuffer();
			//JSON을 한 줄씩 읽어서 응답클래스 안에 한줄 씩 입력함.
			while((line = br.readLine()) != null)
			{
				data.append(line);
			}
			br.close();
			System.out.println(data);
			// 문자열로 저장된 json 파일 콘솔로 출력
			
			// Step 6. JSON 객체로 변환하기
			JSONTokener tok = new JSONTokener(data.toString());
			JSONObject obj = new JSONObject(tok);
//			System.out.println(obj.get("status"));
			JSONObject meta = obj.getJSONObject("meta");
			int totalCount = meta.getInt("totalCount");
//			System.out.println(totalCount);
			
			JSONArray addresses = obj.getJSONArray("addresses");
			JSONObject first = (JSONObject)addresses.get(0);
			String x = first.getString("x");
			String y = first.getString("y");
						
			System.out.println(x);
			System.out.println(y);
			
			JSONArray seconds = first.getJSONArray("addressElements");
			JSONObject thred = seconds.getJSONObject(7);
			String shortName = thred.getString("shortName");
			System.out.println(shortName);
			
			getImage(x, y, addr);
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return "redirect:/";
	}
	
	public void getImage(String x, String y, String addr)
	{
		try 
		{
			System.out.println("getImage() 함수 입장");
			String client_id = "ywb8f46qc5";
			String client_secret = "atsoCvT2sygF1M9TP4DGz8oVJsN7oL7AyxaA9R81";
	
			//step1. URL 작성
			// https://naveropenapi.apigw.ntruss.com/map-static/v2/raster?
			// w=300&
			//h=300&
			//center=127.1054221,37.3591614&
			//level=16
			// x-ncp-apigw-api-key-id: {API Key ID}
			//x-ncp-apigw-api-key: {API Key}
			String url = "https://naveropenapi.apigw.ntruss.com/map-static/v2/raster?";
			url += "w=300&h=300&";
			url += "level=16&";
			url += "center="+x+","+y+"&";
			String pos = URLEncoder.encode(x+" "+y,"UTF-8");
			url += "&markers=type:t|size:mid|pos:"+pos+"|label:"+addr;
			System.out.println(url);
	        //step2 : 요청발생
			System.out.println("step 2 : 요청발생");
	        URL ur = new URL(url);
			HttpURLConnection con = (HttpURLConnection) ur.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("x-ncp-apigw-api-key-id", client_id);
			con.setRequestProperty("x-ncp-apigw-api-key", client_secret);
			
			//step3 : 데이터 수신
			System.out.println("step 3 : 데이터수신");
			InputStream is = con.getInputStream();
			//이미지는 바이트 단위이기 때문에 바이트 배열을 사용한다.
			byte[] bytes = new byte[1024];
			
			//파일 이름짓기
			/*
			Date dt = new Date();
			Long lt = dt.getTime();
			String img = lt.toString();
			*/
			
			String imgName = Long.valueOf(new Date().getTime()).toString();
			
			//파일 생성
			System.out.println("파일생성");
			// 파일 생성 전에 경로 확인
			// 사용자의 홈 디렉토리 사용
			String userHome = "c://users/user/desktop";
			File file = new File(userHome, imgName + ".jpg");
			System.out.println("생성 시도할 파일 경로: " + file.getAbsolutePath());
			file.createNewFile();
			
			//파일에 내용쓰기
			System.out.println("파일에 내용쓰기");
			OutputStream outputstream = new FileOutputStream(file);
			int read=0;
			while((read=is.read(bytes)) != -1)
			{
				outputstream.write(bytes,0,read);
			}
			is.close();
			outputstream.close();
			
		}		
		catch (Exception e) 
		{
			e.printStackTrace();
		}

    }
}
