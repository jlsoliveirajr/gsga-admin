package br.com.gsgaadmin.receita.vo;

import java.io.Serializable;

public class DadosChaveReceitaVO implements Serializable {

	private static final long serialVersionUID = 1L;
	private String chave;
	private String linha;

	public String getChave() {
		return chave;
	}

	public void setChave(String chave) {
		this.chave = chave;
	}

	public String getLinha() {
		return linha;
	}

	public void setLinha(String linha) {
		this.linha = linha;
	}
}
