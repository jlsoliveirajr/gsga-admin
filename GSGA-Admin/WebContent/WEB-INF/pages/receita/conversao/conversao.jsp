<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Conversões</title>
<script src="<s:url value='/includes/js/receita/receita.js'/>"></script>
</head>
<body> 
	
		<div class="row">
		    <!-- Basic Form-->
		    <div class="col-lg-12">
		        <div class="card">
		            <div class="card-header d-flex align-items-center">
		                <h3 class="h4">Conversão de documento</h3>
		            </div>
		            <div class="card-body">
		                <p></p>
		                <s:form id="form-importacao-arquivo" action="importar-arquivo" method="POST" enctype="multipart/form-data">
		                    <div class="row">
	                    		<div class="col-md-6">
	                    			<s:file style="display:none;" name="fileUpload" id="arquivo" />
	                               	<s:textfield id="nome-arquivo" disabled="true" cssClass="form-control" name="fileUploadFileName" placeholder="Informe um arquivo .txt"/>
	                            </div>	
	                            <div class="col-md-2">
	                               	<button type="button" id="importar" class="btn btn-outline-secondary">Importar<span class="caret"></span></button>
	                            </div>
		                    </div>
	                    </s:form> 
	                    <s:if test="%{receitaVO.chaveReceita != null && !receitaVO.chaveReceita.isEmpty()}">    
		                    <div class="form-group form-div-space">
		                        <div class="row">
		                        	<div class="col-md-6">
		                    			<label>Cabeçalho parametrizado</label>
		                    		</div>	
		                        </div>
		                        <div class="row">
		                        	<div class="col-md-6">
		                         		<s:select list="parametrizacao" name="indiceParametrizacao" id="tipoParametrizacao" headerKey="" headerValue="Selecione..."  listKey="codigo" listValue="descricao" cssClass="form-control"/>
		                         	</div>	
		                        </div>
		                    </div>
	                    </s:if>
						<div class="card-body">
		                      <div class="table-responsive">   
		                        <table class="table table-striped table-sm">
		                          <thead>
		                            <tr>
		                              <th>#</th>
		                              <th>Chave</th>
		                              <th>Descrição</th>
		                              <th>&nbsp;</th>
		                            </tr>
		                          </thead>
		                          <tbody>
		                          	<s:iterator value="receitaVO.chaveReceita" var="chaveReceita" status="status">
		                          		<s:form cssClass="no-loading" id="form-download-%{#status.count}" action="download-arquivo">
		                          			<s:hidden name="chave" value="%{#chaveReceita.chave}" />
		                          			<s:hidden name="indiceParametrizacao" id="indiceParametrizacao%{#status.count}"/>
				                            <s:if test="#status.odd == true">
					                            <tr class="linha-resultado no-loading" onclick="download(<s:property value="%{#status.count}"/>)" title="Clique aqui para realizar o download."> 
					                              <th scope="row"><s:property value="%{#status.count}"/></th>
					                              <td><s:property value="%{#chaveReceita.chave}"/></td>
					                              <td><s:property value="%{#chaveReceita.descricao}"/></td>
					                              <td><i class="fas fa-download action-icon"></i></td>
					                            </tr>
				                            </s:if>
				                            <s:else>
					                            <tr class="tr-even linha-resultado no-loading" onclick="download(<s:property value="%{#status.count}"/>)"  title="Clique aqui para realizar o download.">
					                              <th scope="row"><s:property value="%{#status.count}"/></th>
					                              <td><s:property value="%{#chaveReceita.chave}"/></td>
					                              <td><s:property value="%{#chaveReceita.descricao}"/></td>
					                              <td><i class="fas fa-download action-icon"></i></td>	
					                            </tr>
				                            </s:else>
			                          	</s:form>
			                        </s:iterator>
			                        </tbody> 
		                        </table>
		                      </div>
		                </div>
		            </div>
		        </div>
		    </div>
		</div>
</body>
</html>