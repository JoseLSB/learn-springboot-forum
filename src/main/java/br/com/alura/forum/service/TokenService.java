package br.com.alura.forum.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import br.com.alura.forum.modelo.Usuario;
import io.jsonwebtoken.Jwts;

@Service
public class TokenService {
	
	@Value("${forum.jwt.expiration}")
	private String tempoExpiracao;
	
	@Value("${forum.jwt.secret}")
	private String secret;
	
	public String gerarToken(Authentication authentication) {
		Usuario usuario = (Usuario) authentication.getPrincipal();
		Date hoje = new Date();
		Date dataExpiracao = new Date(hoje.getTime() + Long.parseLong(tempoExpiracao));
		
		String jwt = Jwts.builder()
					 .setIssuer("Gerando JWT para Fórum Alura")
					 .setSubject(usuario.getEmail())
					 .setIssuedAt(hoje)
					 .setExpiration(dataExpiracao)
					 .compact();
		return jwt;
	}
}
