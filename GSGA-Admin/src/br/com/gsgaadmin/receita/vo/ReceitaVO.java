package br.com.gsgaadmin.receita.vo;

import java.io.Serializable;
import java.util.List;

public class ReceitaVO implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<ChaveReceitaVO> chaveReceita;
	private List<DadosChaveReceitaVO> dadosChave;

	public List<ChaveReceitaVO> getChaveReceita() {
		return chaveReceita;
	}

	public void setChaveReceita(List<ChaveReceitaVO> chaveReceita) {
		this.chaveReceita = chaveReceita;
	}

	public List<DadosChaveReceitaVO> getDadosChave() {
		return dadosChave;
	}

	public void setDadosChave(List<DadosChaveReceitaVO> dadosChave) {
		this.dadosChave = dadosChave;
	}
}