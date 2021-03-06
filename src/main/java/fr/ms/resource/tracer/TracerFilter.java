/*
 * Copyright 2015 Marco Semiao
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
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

    final String contextPath = req.getContextPath() != null ? req.getContextPath() : "";
    final String requestDispatcherPath = req.getAttribute(DISPATCHER_REQUEST_PATH_ATTR) != null ? (String) req
        .getAttribute(DISPATCHER_REQUEST_PATH_ATTR) : req.getRequestURI();

    final String path = contextPath + requestDispatcherPath;
    System.out.println("path : " + path);

    filterChain.doFilter(servletRequest, servletResponse);
  }

  public void destroy() {

  }
}
