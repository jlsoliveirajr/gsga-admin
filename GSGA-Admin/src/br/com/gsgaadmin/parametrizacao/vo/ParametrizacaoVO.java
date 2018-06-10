package br.com.gsgaadmin.parametrizacao.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ParametrizacaoVO implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer codigo;
	private String descricao;
	private List<CabecalhoVO> cabecalhoVO = new ArrayList<CabecalhoVO>();
	private List<ColunasVO> colunaVO = new ArrayList<ColunasVO>();

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<CabecalhoVO> getCabecalhoVO() {
		return cabecalhoVO;
	}

	public void setCabecalhoVO(List<CabecalhoVO> cabecalhoVO) {
		this.cabecalhoVO = cabecalhoVO;
	}

	public List<ColunasVO> getColunaVO() {
		return colunaVO;
	}

	public void setColunaVO(List<ColunasVO> colunaVO) {
		this.colunaVO = colunaVO;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
}