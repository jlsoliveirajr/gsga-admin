package br.com.gsgaadmin.parametrizacao.vo;

import java.io.Serializable;

public class CabecalhoVO implements Serializable {

	private static final long serialVersionUID = 1L;
	private String cabecalho;

	public CabecalhoVO() {
		
	}
	
	public CabecalhoVO(String cabecalho) {
		super();
		this.cabecalho = cabecalho;
	}

	public String getCabecalho() {
		return cabecalho;
	}

	public void setCabecalho(String cabecalho) {
		this.cabecalho = cabecalho;
	}
}