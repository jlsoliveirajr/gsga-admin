package br.com.gsgaadmin.action;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

@Controller
public class GsgaBaseAction extends ActionSupport implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public void limparMensagens(){
		if(hasActionErrors()) {
			setActionErrors(new ArrayList<String>());
		}
		if(hasActionMessages()) {
			setActionMessages(new ArrayList<String>());
		}
	}
		
	public String iniciarRotina() {
		return Action.SUCCESS;
	}
	
	public String logout() {
		getSession().invalidate();
		return Action.SUCCESS;
	}
	
	public void mensagemSucesso(String msg){
		setActionMessages(Arrays.asList(new String[] {getText(msg)}));
	}
	
	public void mensagemError(String msg) {
		setActionErrors(Arrays.asList(new String[] {getText(msg)}));
	}

	public HttpServletRequest getRequest() {
		return ServletActionContext.getRequest();
	}

	public HttpServletResponse getResponse() {
		return ServletActionContext.getResponse();
	}

	public HttpSession getSession() {
		return getRequest().getSession();
	}
}