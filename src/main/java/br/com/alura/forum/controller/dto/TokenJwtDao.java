package br.com.alura.forum.controller.dto;

public class TokenJwtDao {

	private String tokenJwt;
	private String tipoToken;

	public TokenJwtDao(String tokenJwt, String tipoToken) {
		this.tokenJwt = tokenJwt;
		this.tipoToken = tipoToken;
	}

	public String getTokenJwt() {
		return tokenJwt;
	}

	public String getTipoToken() {
		return tipoToken;
	}

}
