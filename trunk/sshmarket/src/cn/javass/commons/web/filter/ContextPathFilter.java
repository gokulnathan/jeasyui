package cn.javass.commons.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import cn.javass.commons.Constants;

/**
 * 设置上下文路径，比如在页面直接使用${ctx}
 * 
 * @author Jerry
 * 
 */
public class ContextPathFilter implements Filter {

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain filterChain) throws IOException, ServletException {
		String contextPath = ((HttpServletRequest) request).getContextPath();
System.err.println("ContextPathFilter.doFilter contextPath=" + contextPath);		
		request.setAttribute(Constants.CONTEXT_PATH, contextPath);
		filterChain.doFilter(request, response);

	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

}
