package br.com.gsgaadmin.receita.action;

import java.io.File;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.Action;

import br.com.gsgaadmin.action.GsgaBaseAction;
import br.com.gsgaadmin.parametrizacao.vo.ParametrizacaoVO;
import br.com.gsgaadmin.receita.facade.ReceitaFacade;
import br.com.gsgaadmin.receita.vo.ImportacaoArquivoReceitaVO;
import br.com.gsgaadmin.receita.vo.ReceitaVO;

@Controller
public class ReceitaAction extends GsgaBaseAction {

	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = LoggerFactory.getLogger(ReceitaAction.class);
	@Autowired
	private transient ReceitaFacade receitaFacade;

	private ReceitaVO receitaVO;
	private ImportacaoArquivoReceitaVO importacaoVO;
	private File fileUpload;
	private String fileUploadContentType;
	private String fileUploadFileName;
	private List<ParametrizacaoVO> parametrizacao;
	private String chave;
	private Integer indiceParametrizacao;

	public String iniciarConvercao() {
		removeReceitaSession();
		removeImportacaoSession();
		limparDados();
		limparMensagens();
		return Action.SUCCESS;
	}

	public String carregarArquivo() {
		limparMensagens();
		importacaoVO = new ImportacaoArquivoReceitaVO();
		importacaoVO.setArquivoReceita(fileUpload);
		receitaVO = receitaFacade.gerarChaves(importacaoVO);
		setImportacaoSession(importacaoVO);
		setReceitaSession(receitaVO);
		mensagemSucesso("msg.importacao.arquivo");
		return Action.SUCCESS;
	}

	private void limparDados() {
		importacaoVO = new ImportacaoArquivoReceitaVO();
		receitaVO = new ReceitaVO();
		fileUpload = null;
		fileUploadContentType = null;
		fileUploadFileName = null;
	}

	public void download() {
		try {
			HttpServletResponse response = getResponse();
			response.setContentType("text/csv");
			response.setHeader("Content-Disposition", "attachment; filename=\""+gerarPadraoNomeArquivo()+".csv\"");
			OutputStream outputStream = response.getOutputStream();
			ImportacaoArquivoReceitaVO importacao = getImportacaoSession();
			importacao.setChaveGeracao(chave);
			receitaFacade.gerarDadosReceita(importacao, outputStream, recuperarParametrizacao());
			outputStream.flush();
			outputStream.close();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
	
	private ParametrizacaoVO recuperarParametrizacao() {
		ParametrizacaoVO param = null;
		try{
			param = getParametrizacoesSession().get(indiceParametrizacao.intValue());
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return param;
	}
	
	private String gerarPadraoNomeArquivo() {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyy HH-mm-ss");
			if(chave != null && !"".equals(chave.trim())) {
				return "EXPORTACAO-"+chave.toUpperCase()+"-" + sdf.format(new Date());
			}
			return "EXPORTACAO-LAYOUT-" + sdf.format(new Date());
		}catch(Exception e) {
			LOGGER.error("ERRO AO GERAR O PADRAO DO ARQUIVO", e);
		}
		
		return "EXPORTACAO-LAYOUT";
	}

	private void setReceitaSession(ReceitaVO receita) {
		getSession().setAttribute("receita-session-id", receita);
	}

	private ReceitaVO getReceitaSession(ReceitaVO receita) {
		return (ReceitaVO) getSession().getAttribute("receita-session-id");
	}

	private void removeReceitaSession() {
		try {
			getSession().removeAttribute("receita-session-id");
		} catch (Exception e) {
			LOGGER.error("ERRO AO REMOVER RECEITAVO DA SESSAO", e);
		}

	}
	
	private void setImportacaoSession(ImportacaoArquivoReceitaVO importacao) {
		getSession().setAttribute("Importacao-session-id", importacao);
	}

	private ImportacaoArquivoReceitaVO getImportacaoSession() {
		return (ImportacaoArquivoReceitaVO) getSession().getAttribute("Importacao-session-id");
	}

	private void removeImportacaoSession() {
		try {
			getSession().removeAttribute("Importacao-session-id");
		} catch (Exception e) {
			LOGGER.error("ERRO AO REMOVER Importacao DA SESSAO", e);
		}

	}
	

	private ArrayList<ParametrizacaoVO> getParametrizacoesSession() {
		ArrayList<ParametrizacaoVO> parametrizacoes = null;
		try{
			parametrizacoes = (ArrayList<ParametrizacaoVO>) getSession().getAttribute("parametrizacoes-session-id");		
		}catch(Exception e) {
			e.printStackTrace();
		}
		if(parametrizacoes == null) {
			parametrizacoes = new ArrayList<ParametrizacaoVO>();
		}
		
		return parametrizacoes;		
	}


	/* Gets and Sets */

	public ReceitaFacade getReceitaFacade() {
		return receitaFacade;
	}

	public void setReceitaFacade(ReceitaFacade receitaFacade) {
		this.receitaFacade = receitaFacade;
	}

	public ReceitaVO getReceitaVO() {
		return receitaVO;
	}

	public void setReceitaVO(ReceitaVO receitaVO) {
		this.receitaVO = receitaVO;
	}

	public ImportacaoArquivoReceitaVO getImportacaoVO() {
		return importacaoVO;
	}

	public void setImportacaoVO(ImportacaoArquivoReceitaVO importacaoVO) {
		this.importacaoVO = importacaoVO;
	}

	public File getFileUpload() {
		return fileUpload;
	}

	public void setFileUpload(File fileUpload) {
		this.fileUpload = fileUpload;
	}

	public String getFileUploadContentType() {
		return fileUploadContentType;
	}

	public void setFileUploadContentType(String fileUploadContentType) {
		this.fileUploadContentType = fileUploadContentType;
	}

	public String getFileUploadFileName() {
		return fileUploadFileName;
	}

	public void setFileUploadFileName(String fileUploadFileName) {
		this.fileUploadFileName = fileUploadFileName;
	}

	public String getChave() {
		return chave;
	}

	public void setChave(String chave) {
		this.chave = chave;
	}

	public List<ParametrizacaoVO> getParametrizacao() {
		parametrizacao = getParametrizacoesSession();
		return parametrizacao;
	}

	public void setParametrizacao(List<ParametrizacaoVO> parametrizacao) {
		this.parametrizacao = parametrizacao;
	}

	public Integer getIndiceParametrizacao() {
		return indiceParametrizacao;
	}

	public void setIndiceParametrizacao(Integer indiceParametrizacao) {
		this.indiceParametrizacao = indiceParametrizacao;
	}
}