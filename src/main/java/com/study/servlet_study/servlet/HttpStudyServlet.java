package com.study.servlet_study.servlet;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utils.ParamsConverter;


@WebServlet("/http")
public class HttpStudyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public HttpStudyServlet() { // 생성자 생성 
        super();
       
    }

	// 오버라이드 생성.
    
	// Http 메소드 
	// Post요청 >> C reate 추가
	// Get 요청 >> R ead 조회
	/// Put 요청 >> U pdate 수정
	// Delete요청 >> D elete 삭제 
	
    
	

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 요청때도 인코딩을 해줘야한다.
		// 
		Map<String, String> paramsMap = new HashMap<>();
		
		request.getParameterMap().forEach((k,v) -> {
			// name = [ 0,1,0,9,9,8,8,....] / k: name v: 배열값
			StringBuilder builder = new StringBuilder();
			// StringBuilder : 비어있는 문자열을 담을 수 있는 공간을 만들어줌. 
			
			Arrays.asList(v).forEach(value -> builder.append(value));
//			배열을 넣어줌 : StringList가 됨. // value에 들어간 값을 하나씩 출력 
			paramsMap.put(k,builder.toString());
			// toString을 하면 나오는 값들이 문자열로 하나로 합쳐진다.
//			어떠한 배열이든 간에 List로 바꾸어줌. 
		

			}); // 배열을 반복으로 돌릴수 있다.
		System.out.println(paramsMap);
		System.out.println(request.getParameter("name"));
		
		Map<String, String> paramsMap2 = new HashMap<>();
		
		Iterator<String> ir = request.getParameterNames().asIterator();
		while(ir.hasNext()) {
			String key = ir.next();
			paramsMap2.put(key, request.getParameter(key));
		}
	}
		
	
		
		// request에서 요청함 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map<String, String> paramsMap = ParamsConverter.convertParamsMapToMap(request.getParameterMap());
		
		System.out.println(paramsMap);
	}
	
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
	}
  
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	
    }
		
	}


