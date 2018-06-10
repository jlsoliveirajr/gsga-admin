<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
	prefix="decorator"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login - GSGA Admin</title>
</head>
<body>
	<s:form action="autenticar">
		<div class="page login-page">
	      <div class="container d-flex align-items-center">
	        <div class="form-holder has-shadow">
	          <div class="row">
	            <!-- Logo & Information Panel-->
	            <div class="col-lg-6">
	              <div class="info d-flex align-items-center">
	                <div class="content">
	                  <div class="logo">
	                    <h1>GSGA Admin</h1>
	                  </div>
	                  <p>A ferramenta para otimizar seu trabalho.</p>
	                </div>
	              </div>
	            </div>
	            <!-- Form Panel    -->
	            <div class="col-lg-6 bg-white">
	              <div class="form d-flex align-items-center">
	                <div class="content">
	                  	<s:if test="actionErrors != null && !actionErrors.isEmpty()">
							<div class="alert alert-danger" role="alert">
								<s:iterator value="actionErrors">
									<li class="lista-msg"><s:property /></li>
								</s:iterator>	
							</div>						
						</s:if>	
						<s:if test="actionMessages != null && !actionMessages.isEmpty()">
							<div class="alert alert-primary" role="alert">
								<s:iterator value="actionMessages">
									<li class="lista-msg"><s:property /></li>
								</s:iterator>	
							</div>						
						</s:if>	
	                    <div class="form-group">
	                      <s:textfield id="login-username" name="usuario.usuario" cssClass="input-material"/>
	                      <label for="login-username" class="label-material">Usuário</label>
	                    </div>
	                    <div class="form-group">
	                      <s:password id="login-password" name="usuario.senha" cssClass="input-material"/>
	                      <label for="login-password" class="label-material">Senha</label>
	                    </div><s:submit cssClass="btn btn-primary" label="Entrar" value="Entrar" action="autenticar"/>
	                  <a href="#" class="forgot-pass">Esqueceu a senha?</a><br><small>Não possui uma conta? </small><a href="register.html" class="signup">Crie agora!</a>
	                </div>
	              </div>
	            </div>
	          </div>
	        </div>
	      </div>
	    </div>
	</s:form>
</body>
</html>