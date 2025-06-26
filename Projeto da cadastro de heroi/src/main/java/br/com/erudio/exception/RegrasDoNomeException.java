package br.com.erudio.exception;

public class RegrasDoNomeException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public RegrasDoNomeException(String mensagem) {
		super(mensagem);
	}
	
	public RegrasDoNomeException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}

}
