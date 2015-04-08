package fr.ms.resource.tracer;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class TracerFilter implements Filter {

  /**
   * Request dispatcher path.
   */
  private static final String DISPATCHER_REQUEST_PATH_ATTR = "org.apache.catalina.core.DISPATCHER_REQUEST_PATH";

  public void init(final FilterConfig filterConfig) throws ServletException {

  }

  public void doFilter(final ServletRequest servletRequest, final ServletResponse servletResponse,
      final FilterChain filterChain) throws IOException, ServletException {
    final HttpServletRequest req = (HttpServletRequest) servletRequest;

    final String contextPath = req.getContextPath();
    final String requestDispatcherPath = (String) req.getAttribute(DISPATCHER_REQUEST_PATH_ATTR);

    System.out.println("path : " + contextPath + requestDispatcherPath);

    filterChain.doFilter(servletRequest, servletResponse);
  }

  public void destroy() {

  }
}
