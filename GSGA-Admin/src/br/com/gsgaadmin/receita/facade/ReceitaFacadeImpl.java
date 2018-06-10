package br.com.gsgaadmin.receita.facade;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.gsgaadmin.parametrizacao.vo.CabecalhoVO;
import br.com.gsgaadmin.parametrizacao.vo.ColunasVO;
import br.com.gsgaadmin.parametrizacao.vo.ParametrizacaoVO;
import br.com.gsgaadmin.receita.vo.ChaveReceitaVO;
import br.com.gsgaadmin.receita.vo.ImportacaoArquivoReceitaVO;
import br.com.gsgaadmin.receita.vo.ReceitaVO;
import br.com.gsgaadmin.util.FileUtils;

@Service
@Transactional(propagation=Propagation.NOT_SUPPORTED)
public class ReceitaFacadeImpl implements ReceitaFacade {

	private static final String NEW_LINE = System.getProperty("line.separator");
	private static final Logger LOGGER = LoggerFactory.getLogger(ReceitaFacadeImpl.class);
	private static final Integer POSICOES_CONTROLE_ARQUIVO_RECEITA = 6;

	@Override
	public ReceitaVO gerarChaves(ImportacaoArquivoReceitaVO importacaoArquivoReceita){
		FileReader arq = null;
        BufferedReader br = null;
        ReceitaVO receita = new ReceitaVO();
        Set<ChaveReceitaVO> listaChaveInteligente = new HashSet<ChaveReceitaVO>();
        try {
        	importacaoArquivoReceita.setArquivoReceitaIS(FileUtils.fileToInputStream(importacaoArquivoReceita.getArquivoReceita()));
            arq = new FileReader(importacaoArquivoReceita.getArquivoReceita());
            br = new BufferedReader(arq);
            String line = br.readLine();
            while (line != null) {
                if (line != null && !"".equals(line) && line.length() >= 6) {
                	ChaveReceitaVO chaveReceita = new ChaveReceitaVO();
                	chaveReceita.setChave(line.substring(0, POSICOES_CONTROLE_ARQUIVO_RECEITA).replace("|", ""));
                    listaChaveInteligente.add(chaveReceita);
                }
                line = br.readLine();
            }
            arq.close();
            List<ChaveReceitaVO> listaDadosReceitaOrdenada = new ArrayList<ChaveReceitaVO>(listaChaveInteligente);
            Collections.sort(listaDadosReceitaOrdenada);
            receita.setChaveReceita(listaDadosReceitaOrdenada);
        } catch (IOException e) {
            if (arq != null) {
                try {
                    arq.close();
                } catch (IOException ex) {
                	LOGGER.error("Erro ao realizar o carregamento das chaves", ex);
                }
            }

            if (br != null) {
                try {
                    br.close();
                } catch (IOException ex) {
                    LOGGER.error("Erro ao realizar o carregamento das chaves", ex);
                }
            }
        }
   
         
         return receita;
	}

	@Override
	public ReceitaVO gerarDadosReceita(ImportacaoArquivoReceitaVO importacaoArquivoReceita, OutputStream outputStream, ParametrizacaoVO param) {
		try {
			importacaoArquivoReceita.setArquivoReceitaIS(FileUtils.fileToInputStream(importacaoArquivoReceita.getArquivoReceita()));
			byte[] byteFile = IOUtils.toByteArray(importacaoArquivoReceita.getArquivoReceitaIS());
			BufferedReader targetReader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(byteFile)));
			
			
			if(param != null && param.getCabecalhoVO() != null && !param.getCabecalhoVO().isEmpty()) {
				String strCabecalho = "";
				for(CabecalhoVO cabecalho : param.getCabecalhoVO()) {
					strCabecalho += cabecalho.getCabecalho() + ";";
				}
				
				strCabecalho += NEW_LINE;
				outputStream.write(strCabecalho.getBytes());
			}
			
			
			String strLinha = targetReader.readLine();
            while (strLinha != null) {
                if (strLinha != null && !"".equals(strLinha) && strLinha.length() >= 6) {
                	String chaveLinha = strLinha.substring(0, 6).replace("|", "");
					strLinha = strLinha.replace("||", ";").replace("|", ";");
					if (importacaoArquivoReceita.getChaveGeracao().equalsIgnoreCase(chaveLinha)) {
						String dadosLinha = strLinha.substring(6, strLinha.length()) + NEW_LINE;
						String[] colunas = dadosLinha.split(";");
						String linhaTratada = "";
						if(param != null && param.getColunaVO() != null && !param.getColunaVO().isEmpty()) {
							try {
								for(ColunasVO coluna : param.getColunaVO()) {
									linhaTratada += colunas[Integer.valueOf(coluna.getColuna()) - 1] + ";";
								}
								linhaTratada += NEW_LINE;
								outputStream.write(linhaTratada.getBytes());
							}catch(Exception e) {
								outputStream.write(dadosLinha.getBytes());
								e.printStackTrace();
							}
						}else {
							outputStream.write(dadosLinha.getBytes());	
						}
						
						
						
					}
                }
                strLinha = targetReader.readLine();
            }
		} catch (Exception e) {
			LOGGER.error("ERRO AO EXPORTAR O CSV", e);
		}
		return null;
	}

}
