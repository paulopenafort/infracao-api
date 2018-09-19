package br.gov.am.prodam.infracao.exception;

public class AppException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String mensagem;

	private String erro;

	public AppException(String mensagem, String erro) {

		this.mensagem = mensagem;
		this.erro = erro;
	}

	public AppException(String mensagem) {
		this.mensagem = mensagem;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public String getErro() {
		return erro;
	}

	public void setErro(String erro) {
		this.erro = erro;
	}

}
