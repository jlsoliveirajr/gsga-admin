package br.com.gsgaadmin.receita.facade;

import java.io.OutputStream;

import br.com.gsgaadmin.parametrizacao.vo.ParametrizacaoVO;
import br.com.gsgaadmin.receita.vo.ImportacaoArquivoReceitaVO;
import br.com.gsgaadmin.receita.vo.ReceitaVO;

public interface ReceitaFacade {
	
	ReceitaVO gerarChaves(ImportacaoArquivoReceitaVO importacaoArquivoReceita);

	ReceitaVO gerarDadosReceita(ImportacaoArquivoReceitaVO importacaoArquivoReceita, OutputStream outputStream, ParametrizacaoVO param);

}
