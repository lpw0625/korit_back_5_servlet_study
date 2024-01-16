package com.study.servlet_study.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class RequestCharactorEncodingFilter
 */
@WebFilter("/*")
public class RequestCharactorEncodingFilter extends HttpFilter implements Filter {
       
   
    public RequestCharactorEncodingFilter() {
        super();
        
    }

	
	public void destroy() {
		
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
	
	
		HttpServletRequest httpRequest = (HttpServletRequest) request;
	//	HttpServletResponse httpResponse = (HttpServletResponse) response;
		
		String[] methods = new String[] {"POST" , "PUT" };
		
		System.out.println(httpRequest.getMethod());
		
		if(Arrays.asList(methods). contains(httpRequest.getMethod().toUpperCase())) { // .toUpperCase : 무조건 대문자로만 넣늗나.
			// 이 리스트(post,put)에 contain(요청때 포함한 메소드)를 포함하고 있냐는 의미이다.
		}
		httpRequest.setCharacterEncoding("utf-8");
		// 전처리 끝 ==============
		// 필터는 http 뿐만 아니라 다른곳에서 쓸 수 있고 다만 지금은 상용이 되서 들어오기에 http를 쓰는 것이다.
		
		chain.doFilter(request, response); 
		// 다운 캐스팅 되서 들어옴. 
		// 다음 필터로 넘어가라. 제일 마지막 필터는 servlet으로 호출함
		// 이 주소 그대로 가지고 헬로서클릿의 주소로 다시 들고 간다 .
				
		// 후처리 영역 =====================================
//		httpResponse.getWriter().println("무조건 후처리함 ");		
		
	}

	public void init(FilterConfig fConfig) throws ServletException {
	
	}

}