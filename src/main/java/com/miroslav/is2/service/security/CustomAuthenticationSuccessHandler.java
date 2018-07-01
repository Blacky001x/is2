package com.miroslav.is2.service.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class CustomAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

	public CustomAuthenticationSuccessHandler() {
		super();
		setRedirectStrategy(new NoRedirectStrategy());
	}

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {

		super.onAuthenticationSuccess(request, response, authentication);
		ObjectMapper mapper = new ObjectMapper();

		response.setContentType("application/json;charset=UTF-8");

		response.setHeader("JSESSIONID", request.getSession().getId());

		Cookie cookie = new Cookie("JSESSIONID", request.getSession().getId());
		response.addCookie(cookie);

		response.getWriter().print("{\"JSESSIONID\":" + mapper.writeValueAsString(request.getSession().getId()) + "}");
		response.getWriter().flush();
	}

	protected class NoRedirectStrategy implements RedirectStrategy {

		@Override
		public void sendRedirect(HttpServletRequest request, HttpServletResponse response, String url)
				throws IOException {
			// don't do anything
		}

	}
}