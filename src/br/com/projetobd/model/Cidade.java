package br.com.projetobd.model;

public class Cidade {
	private Long id;
	
	private String nomeCidade;
	private String siglaEstado;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNomeCidade() {
		return nomeCidade;
	}

	public void setNomeCidade(String nomeCidade) {
		this.nomeCidade = nomeCidade;
	}
	
	public String getSiglaEstado() {
		return siglaEstado;
	}
	
	public void setSiglaEstado(String siglaEstado) {
		this.siglaEstado = siglaEstado;
	}
}
