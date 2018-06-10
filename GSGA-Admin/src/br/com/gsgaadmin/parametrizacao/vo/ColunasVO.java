package br.com.gsgaadmin.parametrizacao.vo;

import java.io.Serializable;

public class ColunasVO implements Serializable {

	private static final long serialVersionUID = 1L;
	private String coluna;
	
	public ColunasVO() {
		
	}

	public ColunasVO(String coluna) {
		super();
		this.coluna = coluna;
	}

	public String getColuna() {
		return coluna;
	}

	public void setColuna(String coluna) {
		this.coluna = coluna;
	}
}
