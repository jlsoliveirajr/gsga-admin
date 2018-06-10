package br.com.gsgaadmin.receita.vo;

import java.io.File;
import java.io.InputStream;
import java.io.Serializable;
import java.util.List;

public class ImportacaoArquivoReceitaVO implements Serializable {

	private static final long serialVersionUID = 1L;

	private File arquivoReceita;
	private String chaveGeracao;
	private InputStream arquivoReceitaIS;
	private List<CabecalhoParametrizacaoVO> cabecalhoParametrizacao;

	public File getArquivoReceita() {
		return arquivoReceita;
	}

	public void setArquivoReceita(File arquivoReceita) {
		this.arquivoReceita = arquivoReceita;
	}

	public List<CabecalhoParametrizacaoVO> getCabecalhoParametrizacao() {
		return cabecalhoParametrizacao;
	}

	public void setCabecalhoParametrizacao(List<CabecalhoParametrizacaoVO> cabecalhoParametrizacao) {
		this.cabecalhoParametrizacao = cabecalhoParametrizacao;
	}

	public String getChaveGeracao() {
		return chaveGeracao;
	}

	public void setChaveGeracao(String chaveGeracao) {
		this.chaveGeracao = chaveGeracao;
	}

	public InputStream getArquivoReceitaIS() {
		return arquivoReceitaIS;
	}

	public void setArquivoReceitaIS(InputStream arquivoReceitaIS) {
		this.arquivoReceitaIS = arquivoReceitaIS;
	}
}