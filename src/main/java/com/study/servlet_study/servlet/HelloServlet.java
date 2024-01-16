package com.study.servlet_study.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// 주소창에서 요청을 날리면 무조건 get 요청이 정상적인 요청이다.
	// 웹은 무조건 응답과 요청에 의해 움직인다 .
	// 요청과 응답에 대한 개념이 매우 중요하다. 
	// 요청을 날리는 대상은 클라이언트 
	// 응답은 서버가 해준다. 서버가 응답을 받은 객체가 다 리스폰스 객체 안에 들어 있다 .
	// 한글로 입력을 하렬면 contentstype에 utf-8로 바꿔야 한다.
	// 응답되기 전에 셋팅을 해야 출력이 된다. 
	// 요청이 들어올건데 요청이 들어올때마다 모든 메소드에서 실행을 하고 싶다면 
	// filtter 라는 실행문을 쓸 예정.
	// 클라이언트가 요청을 날리면 톰켓 서버에 받는다.
	// 톰캣이 리퀘스트,리스폰스 객체가 생성이 된다.
	// 이 두개를 같이 매개변수로 넘겨준다.
	// 404: 경로로 찾아 들어왔는데 응답을 해줄 프로그램이 없을때 404메세지를 뜬다.
	// 
	
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	System.out.println(request.getMethod());
	System.out.println(request.getRequestURL()); // 전체 주소 경로를 다 들고옴
	System.out.println(request.getRequestURI()); // 프로젝트 이름만 들고옴.
	System.out.println(response.getStatus());
	
	response.setContentType("text/plain");
	System.out.println(response.getContentType());
	response.getWriter().println("헬로");	
		System.out.println("요청이 들어옴!");
		
	}
	

}
