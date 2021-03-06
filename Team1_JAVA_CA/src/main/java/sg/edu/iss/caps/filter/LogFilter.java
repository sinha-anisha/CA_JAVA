package sg.edu.iss.caps.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;



@Component
public class LogFilter  implements Filter
{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(LogFilter.class);

	

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException
	{
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;

		LOGGER.info("My FILTER: Logging Request  {} : {}", req.getMethod(), req.getRequestURI());

		// Call next filter in the filter chain
		chain.doFilter(req, res);

		LOGGER.info("Logging Response :{}", res.getContentType());
		
	}

}
