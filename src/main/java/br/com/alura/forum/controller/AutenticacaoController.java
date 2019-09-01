package br.com.alura.forum.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.forum.config.security.AutenticacaoForm;
import br.com.alura.forum.service.AutenticacaoService;
import br.com.alura.forum.service.TokenService;

@RestController
@RequestMapping("/auth")
public class AutenticacaoController {

	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private AutenticacaoService autenticacaoService;
	
	@Autowired
	private TokenService tokenService;
	
	@PostMapping
	public ResponseEntity<?> autenticar(@RequestBody @Valid AutenticacaoForm dadosUsuario) {
		UsernamePasswordAuthenticationToken dadosToken = autenticacaoService.usuarioSenhaParaUserPassAuthToken(dadosUsuario);
		
		try {
			Authentication authentication = authenticationManager.authenticate(dadosToken);
			System.out.println(tokenService.gerarToken(authentication));
			return ResponseEntity.ok().build();	
		} catch (AuthenticationException e) {
			return ResponseEntity.badRequest().build();
		}
	}
}
