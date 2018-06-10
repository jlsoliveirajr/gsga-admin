package br.com.gsgaadmin.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.StrutsStatics;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

import br.com.gsgaadmin.login.action.LoginAction;

public class LoginInterceptor extends AbstractInterceptor implements StrutsStatics {

	private static final long serialVersionUID = 1L;

	public void init() {
	}

	public void destroy() {
	}

	public String intercept(ActionInvocation invocation) throws Exception {

		final ActionContext context = invocation.getInvocationContext();
		HttpServletRequest request = (HttpServletRequest) context.get(HTTP_REQUEST);
		HttpSession session = request.getSession(true);
		Object user = session.getAttribute("USUARIO_SESSAO");
		if (user == null) {
			if (invocation.getAction().getClass().equals(LoginAction.class)) {
				return invocation.invoke();
			}
			return "login-redirect"; 
		} else {
			return invocation.invoke();
		}
	}

}