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
		                <div class="card-body">
		                      <div class="table-responsive">   
		                        <table class="table table-striped table-sm">
		                          <thead>
		                            <tr>
		                              <th>#</th>
		                              <th>Descrioção</th>
		                            </tr>
		                          </thead>
		                          <tbody>
		                          	<s:if test="%{parametrizacoes != null && !parametrizacoes.isEmpty()}">
			                          	<s:iterator value="parametrizacoes" var="parametrizacao" status="status">
				                            <s:if test="#status.odd == true">
					                            <tr class="linha-resultado" onclick="editar(<s:property value='%{#status.index}'/>);"> 
					                              <th scope="row"><s:property value="%{#status.count}"/></th>
					                              <td><s:property value="%{#parametrizacao.descricao}"/></td>
					                            </tr>
				                            </s:if>
				                            <s:else>
					                            <tr class="tr-even linha-resultado" onclick="editar(<s:property value='%{#status.index}'/>);">
					                              <th scope="row"><s:property value="%{#status.count}"/></th>
					                              <td><s:property value="%{#parametrizacao.descricao}"/></td>	
					                            </tr>
				                            </s:else>
				                        </s:iterator>
				                      </s:if>
				                      <s:else>
				                      	<tr>
				                      		<td colspan="2">
				                      			Sem resultados
				                      		</td>
				                      	</tr>
				                      </s:else>  
			                        </tbody> 
		                        </table>
		                      </div>
		                </div>
		                <div class="row">
		                	<div class="col-md-12 text-right">
		                		<s:form action="iniciarCadastro">
		                			<s:submit value="Cadastrar" cssClass="btn btn-primary" label="Cadastrar" action="iniciarCadastro" />
		                		</s:form>
		                	</div>
		                </div>
		            </div>
		        </div>
		    </div>
		</div>
</body>
</html>