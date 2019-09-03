package br.com.alura.forum.config.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import br.com.alura.forum.service.TokenService;

public class AutenticacaoViaTokenFilter extends OncePerRequestFilter{
	
	private TokenService tokenService;
	
	public AutenticacaoViaTokenFilter(TokenService tokenService) {
		this.tokenService = tokenService;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		String token = validarToken(request);
		boolean valido = tokenService.isTokenValido(token);
		System.out.println(token);
		System.out.println(valido);
		
		filterChain.doFilter(request, response);
	}

	private String validarToken(HttpServletRequest request) {
		String token = request.getHeader("Authorization");
		if (StringUtils.isEmpty(token) || !token.startsWith("Bearer "))
			return null;
		
		return token.substring(7, token.length());
	}

}
