package br.com.gsgaadmin.parametrizacao.action;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.Action;

import br.com.gsgaadmin.action.GsgaBaseAction;
import br.com.gsgaadmin.parametrizacao.vo.CabecalhoVO;
import br.com.gsgaadmin.parametrizacao.vo.ColunasVO;
import br.com.gsgaadmin.parametrizacao.vo.ParametrizacaoVO;

@Controller
public class ParametrizacaoAction extends GsgaBaseAction {

	private static final long serialVersionUID = 1L;
	private List<ParametrizacaoVO> parametrizacoes;
	private ParametrizacaoVO parametrizacao;
	private String addColuna;
	private String addCabecalho;
	
	private Integer indiceParametrizacao;
	private Integer indiceCabecalho;
	private Integer indiceColuna;

	public String iniciarParametrizacao() {
		limparMensagens();
		parametrizacoes = new ArrayList<ParametrizacaoVO>();
		try {
			parametrizacoes = getParametrizacoesSession();
		} catch (Exception e) {
			setParametrizacoesSession(new ArrayList<ParametrizacaoVO>());
			e.printStackTrace();
		}
		return Action.SUCCESS;
	}

	public String iniciarCadastro() {
		limparMensagens();
		addColuna = "";
		addCabecalho = "";
		parametrizacao = new ParametrizacaoVO();
		return Action.SUCCESS;
	}
	
	public String adicionarCabecalho() {
		if(addCabecalho != null && !"".equals(addCabecalho.trim())) {
			parametrizacao.getCabecalhoVO().add(new CabecalhoVO(addCabecalho));
			addCabecalho = "";
		}
		return Action.SUCCESS;
	}
	
	public String adicionarColuna() {
		if(addColuna != null && !"".equals(addColuna.trim())) {
			parametrizacao.getColunaVO().add(new ColunasVO(addColuna));
			addColuna = "";
		}
		return Action.SUCCESS;
	}

	
	public String salvar() {
		List<ParametrizacaoVO> lista = getParametrizacoesSession();
		if(lista == null) {
			lista = new ArrayList<ParametrizacaoVO>();
		}
		if(indiceParametrizacao == null) {
			parametrizacao.setCodigo(lista.size());
			lista.add(parametrizacao);
		}else {
			lista.set(indiceParametrizacao.intValue(), parametrizacao);
		}
		setParametrizacoesSession(lista);
		parametrizacao = new ParametrizacaoVO();
		mensagemSucesso("msg.gravado.sucesso");
		return Action.SUCCESS;
	}
	
	public String editar() {
		if(indiceParametrizacao != null) {
			try {
				parametrizacao = getParametrizacoesSession().get(indiceParametrizacao.intValue());
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return Action.SUCCESS;
	}
	
	public String removerCabecalho() {
		try {
			parametrizacao.getCabecalhoVO().remove(indiceCabecalho.intValue());
		}catch(Exception e) {
			e.printStackTrace();
		}
		return Action.SUCCESS;
	}

	public String removerColuna() {
		try {
			parametrizacao.getColunaVO().remove(indiceColuna.intValue());
		}catch(Exception e) {
			e.printStackTrace();
		}
		return Action.SUCCESS;
	}
	
	private void setParametrizacoesSession(List<ParametrizacaoVO>  parametrizacoes) {
		getSession().setAttribute("parametrizacoes-session-id", parametrizacoes);
	}

	private ArrayList<ParametrizacaoVO> getParametrizacoesSession() {
		return (ArrayList<ParametrizacaoVO>) getSession().getAttribute("parametrizacoes-session-id");
	}

	public ParametrizacaoVO getParametrizacao() {
		return parametrizacao;
	}

	public void setParametrizacao(ParametrizacaoVO parametrizacao) {
		this.parametrizacao = parametrizacao;
	}

	public String getAddColuna() {
		return addColuna;
	}

	public void setAddColuna(String addColuna) {
		this.addColuna = addColuna;
	}

	public String getAddCabecalho() {
		return addCabecalho;
	}

	public void setAddCabecalho(String addCabecalho) {
		this.addCabecalho = addCabecalho;
	}

	public List<ParametrizacaoVO> getParametrizacoes() {
		return parametrizacoes;
	}

	public void setParametrizacoes(List<ParametrizacaoVO> parametrizacoes) {
		this.parametrizacoes = parametrizacoes;
	}

	public Integer getIndiceParametrizacao() {
		return indiceParametrizacao;
	}

	public void setIndiceParametrizacao(Integer indiceParametrizacao) {
		this.indiceParametrizacao = indiceParametrizacao;
	}

	public Integer getIndiceCabecalho() {
		return indiceCabecalho;
	}

	public void setIndiceCabecalho(Integer indiceCabecalho) {
		this.indiceCabecalho = indiceCabecalho;
	}

	public Integer getIndiceColuna() {
		return indiceColuna;
	}

	public void setIndiceColuna(Integer indiceColuna) {
		this.indiceColuna = indiceColuna;
	}
}