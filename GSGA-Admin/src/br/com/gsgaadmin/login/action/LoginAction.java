package br.com.gsgaadmin.login.action;

import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.Action;

import br.com.gsgaadmin.action.GsgaBaseAction;
import br.com.gsgaadmin.receita.vo.UsuarioVO;

@Controller()
public class LoginAction extends GsgaBaseAction {

	private static final long serialVersionUID = 1L;
	private UsuarioVO usuario;

	public String iniciarRotina() {
		limparMensagens();
		usuario = new UsuarioVO();
		return Action.SUCCESS;
	}

	@Override
	public String execute() throws Exception {
		super.execute();
		return autenticar();
	}

	public String autenticar() {
		limparMensagens();
		if (usuario != null) {
			//if ("deiwson".equalsIgnoreCase(usuario.getUsuario()) && "deiwson".equalsIgnoreCase(usuario.getSenha())) {
				getSession().setAttribute("USUARIO_SESSAO", usuario);
				return Action.SUCCESS;
			//}
			//mensagemError("msg.erro.autenticacao");
		}
		return Action.INPUT;
	}

	public void limparMensagens() {
		if (hasActionErrors()) {
			setActionErrors(new ArrayList<String>());
		}
		if (hasActionMessages()) {
			setActionMessages(new ArrayList<String>());
		}
	}

	public String logout() {
		getSession().invalidate();
		return Action.SUCCESS;
	}

	public void mensagemSucesso(String msg) {
		setActionMessages(Arrays.asList(new String[] { getText(msg) }));
	}

	public void mensagemError(String msg) {
		setActionErrors(Arrays.asList(new String[] { getText(msg) }));
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

	public UsuarioVO getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioVO usuario) {
		this.usuario = usuario;
	}
}