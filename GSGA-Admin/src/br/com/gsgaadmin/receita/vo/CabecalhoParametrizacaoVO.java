package br.com.gsgaadmin.receita.vo;

import java.io.Serializable;

public class CabecalhoParametrizacaoVO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String cabecalho;

	public String getCabecalho() {
		return cabecalho;
	}

	public void setCabecalho(String cabecalho) {
		this.cabecalho = cabecalho;
	}
}
