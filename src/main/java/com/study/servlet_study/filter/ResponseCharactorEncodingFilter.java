package com.study.servlet_study.filter;

import java.io.IOException;
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


@WebFilter("/*") // 모든 경로.
public class ResponseCharactorEncodingFilter extends HttpFilter implements Filter {

// 서브 리퀘스트 들어오면 http와 관련된건 전부 사라진체로 들어온다.
	// 필터에 다운캐스팅이 가능한건 애초에 업캐스팅이 되서 들어온것이다.
	
	public void destroy() {
		
	}
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		 // 전처리 시작 ======
		
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		
		
		
		httpResponse.setCharacterEncoding("utf-8");
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
