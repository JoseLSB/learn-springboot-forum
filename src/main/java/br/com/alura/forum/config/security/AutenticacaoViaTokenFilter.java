package br.com.alura.forum.config.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

public class AutenticacaoViaTokenFilter extends OncePerRequestFilter{

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		String token = validarToken(request);
		System.out.println(token);
		
		filterChain.doFilter(request, response);
	}

	private String validarToken(HttpServletRequest request) {
		String token = request.getHeader("Authorization");
		if (StringUtils.isEmpty(token) || !token.startsWith("Bearer "))
			return null;
		
		return token.substring(7, token.length());
	}

}
