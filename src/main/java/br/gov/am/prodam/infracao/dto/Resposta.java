package br.gov.am.prodam.infracao.dto;

public class Resposta {

	private String mensagem;
	private String erro;
	private boolean sucesso;

	public Resposta(String mensagem, String erro, boolean sucesso) {
		super();
		this.mensagem = mensagem;
		this.erro = erro;
		this.sucesso = sucesso;
	}

	public Resposta(String mensagem, boolean sucesso) {
		super();
		this.mensagem = mensagem;
		this.sucesso = sucesso;
	}

	public Resposta(String mensagem) {
		super();
		this.mensagem = mensagem;
		this.sucesso = true;
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

	public boolean isSucesso() {
		return sucesso;
	}

	public void setSucesso(boolean sucesso) {
		this.sucesso = sucesso;
	}

}
