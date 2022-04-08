package com.fastcampus.ch2;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

// 필터를 적용할 요청의 패턴 지정 - 모든 요청에 필터를 적용.
@WebFilter(urlPatterns="/*")
public class PerformanceFilter implements Filter {
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// 초기화 작업
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// 1. 전처리 작업
		long startTime = System.currentTimeMillis();

		// 2. 서블릿 또는 다음 필터를 호출
		chain.doFilter(request, response); 
		
		// 3. 후처리 작업
		System.out.print("["+((HttpServletRequest)request).getRequestURI()+"]");
		System.out.println(" 소요시간="+(System.currentTimeMillis()-startTime)+"ms");
		
			/*
		 	[/ch2/] 소요시간=890ms
			[/ch2/el.jsp] 소요시간=279ms
			[/ch2/el.jsp] 소요시간=3ms
			[/ch2/el.jsp] 소요시간=1ms 
			el.jsp 페이지를 실행하면 log에 위와 같이 출력된다.
			jsp를 자바로 컴파일하는 초반에는 시간이 오래걸렸지만,
			그 다음부터는 소요시간이 훨신 짧아짐을 알수 있다.	  
		   */
	}

	@Override
	public void destroy() {
		// 정리 작업
	}

}