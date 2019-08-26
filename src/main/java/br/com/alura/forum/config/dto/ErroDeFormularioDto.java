package br.com.alura.forum.config.dto;

public class ErroDeFormularioDto {
	
	private String field;
	private String error;
	
	public ErroDeFormularioDto(String field, String error) {
		this.field = field;
		this.error = error;
	}
	
	public String getField() {
		return field;
	}
	public void setField(String field) {
		this.field = field;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}

}
