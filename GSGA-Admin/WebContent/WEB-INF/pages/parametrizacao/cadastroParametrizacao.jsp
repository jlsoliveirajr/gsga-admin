<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Parametrização</title>
<script src="<s:url value='/includes/js/parametrizacao/parametrizacao.js'/>"></script>
</head>
<body> 
	
		<div class="row">
		    <!-- Basic Form-->
		    <div class="col-lg-12">
		        <div class="card">
		            <div class="card-header d-flex align-items-center">
		                <h3 class="h4">Parametrização</h3>
		            </div>
		            <div class="card-body">
		                <p></p>
		                
		                    <div class="row">
	                    		<div class="col-md-6">
	                    			<label>Descrição</label>
	                            </div>
	                        </div>    
	                        <div class="row"> 	
	                            <div class="col-md-6">
	                            	<s:form action="salvar" id="form-cadastro-parametrizacao">
	                            		<s:hidden name="indiceParametrizacao" value="%{indiceParametrizacao}" />
	                               		<s:textfield name="parametrizacao.descricao" cssClass="form-control" value="%{parametrizacao.descricao}" />
	                               	</s:form>
	                            </div>
		                    </div>
	                         
	                    <div class="form-group form-div-space">
	                        <div class="row">
	                        	<div class="col-md-6">
	                    			<label>Cabeçalho*</label>
	                    		</div>	
	                    		<div class="col-md-6">
	                    			<label>Coluna*</label>
	                    		</div>	
	                        </div>
	                        <div class="row">
	                        	<div class="col-md-6">
	                        		<s:form cssClass="form-inline">
		                        		<div class="col-md-4">	
		                         			<s:textfield name="addCabecalho" cssClass="form-control"/>
		                         		</div>
		                         		<div class="col-md-4">	
		                         			<s:submit action="adicionarCabecalho" title="Add" value="Add" cssClass="btn btn-primary" />
		                         		</div>
		                         	</s:form>
	                         	</div>	
	                         	<div class="col-md-6">
	                         		<s:form cssClass="form-inline">
		                         		<div class="col-md-4">	
		                         			<s:textfield name="addColuna" cssClass="form-control somenteNumero" required="required"/>
		                         		</div>
		                         		<div class="col-md-4">	
		                         			<s:submit action="adicionarColuna" title="Add" value="Add" cssClass="btn btn-primary" />
		                         		</div>
		                         	</s:form>	
	                         	</div>
	                        </div>
	                        <div class="row form-div-space">
	                        	<div class="col-md-6">
	                        		<div class="table-responsive">   
				                        <table class="table table-striped table-sm">
				                          <thead>
				                            <tr>
				                              <th>#</th>
				                              <th>Descrição</th>
				                              <th>&nbsp;</th>
				                            </tr>
				                          </thead>
				                          <tbody>
				                          	<s:iterator value="parametrizacao.cabecalhoVO" var="cabecalhoVo" status="status">
				                          		<s:form  id="form-remover-cabecalho-%{#status.count}" action="removerCabecalho">
						                            <s:if test="#status.odd == true">
							                            <tr class="linha-resultado no-loading"> 
							                              <th scope="row"><s:property value="%{#status.count}"/></th>
							                              <td><s:property value="%{#cabecalhoVo.cabecalho}"/></td>
							                              <td><i class="fas fa fa-times action-icon" onclick="removerCabecalho(<s:property value="%{#status.index}"/>)"></i></td>
							                            </tr>
						                            </s:if>
						                            <s:else>
							                            <tr class="tr-even linha-resultado no-loading">
 														  <th scope="row"><s:property value="%{#status.count}"/></th>
							                              <td><s:property value="%{#cabecalhoVo.cabecalho}"/></td>
							                              <td><i class="fas fa fa-times action-icon" onclick="removerCabecalho(<s:property value="%{#status.index}"/>)"></i></td>	
							                            </tr>
						                            </s:else>
					                          	</s:form>
					                        </s:iterator>
					                        </tbody> 
				                        </table>
				                      </div>
	                        	</div>
	                        	<div class="col-md-6">
	                        		<div class="table-responsive">   
				                        <table class="table table-striped table-sm">
				                          <thead>
				                            <tr>
				                              <th>#</th>
				                              <th>Descrição</th>
				                              <th>&nbsp;</th>
				                            </tr>
				                          </thead>
				                          <tbody>
				                          	<s:iterator value="parametrizacao.colunaVO" var="colunaVo" status="status">
				                          		<s:form  id="form-remover-coluna-%{#status.count}" action="removerColuna">
						                            <s:if test="#status.odd == true">
							                            <tr class="linha-resultado no-loading"> 
							                              <th scope="row"><s:property value="%{#status.count}"/></th>
							                              <td><s:property value="%{#colunaVo.coluna}"/></td>
							                              <td><i class="fas fa fa-times action-icon" onclick="removerColuna(<s:property value="%{#status.index}"/>)"></i></td>
							                            </tr>
						                            </s:if>
						                            <s:else>
							                            <tr class="tr-even linha-resultado no-loading">
 														  <th scope="row"><s:property value="%{#status.count}"/></th>
							                              <td><s:property value="%{#colunaVo.coluna}"/></td>
							                              <td><i class="fas fa fa-times action-icon" onclick="removerColuna(<s:property value="%{#status.index}"/>)"></i></td>	
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
	                    <div class="row">
	                    	<div class="col-md-12 text-right">
                       			<button type="button" class="btn btn-primary" id="btn-salvar">Salvar</button>                			
                       		</div>
	                    </div>
		            </div>
		        </div>
		    </div>
		</div>
</body>
</html>