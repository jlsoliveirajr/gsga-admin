package br.com.gsgaadmin.util;

import java.io.IOException;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.json.JSONObject;

public final class AjaxUtil {

	private static final String TYPE_JSON = "application/json; charset=UTF-8";
	private static final String TYPE_TEXT = "text/plain; charset=UTF-8";
	private static final String TYPE_HTML = "text/html; charset=UTF-8";

	/**
	 * Construtor privado
	 */
	private AjaxUtil() {
		/* empty */
	}

	/**
	 * Escreve o retorno de uma solicitação Ajax no formato JSON
	 * @param object Objeto que será convertido em JSON
	 */
	public static void writeJsonResponse(Object object) {
		writeResponse(StringUtil.parseObjectToJson(object), TYPE_JSON);
	}

	/**
	 * Escreve o retorno de uma solicitação Ajax no formato JSON
	 * @param json JSONObject que será escrito no retorno
	 */
	public static void writeJsonResponse(JSONObject json) {
		writeResponse(json.toString(), TYPE_JSON);
	}

	/**
	 * Escreve o retorno de uma solicitação Ajax no formato texto puro
	 * @param message Mensagem que será escrita no retorno
	 */
	public static void writePlainTextResponse(String message) {
		writeResponse(message, TYPE_TEXT);
	}

	/**
	 * Escreve o retorno de uma solicitação Ajax no formato HTML
	 * @param html HTML que será escrito no retorno
	 */
	public static void writeHtmlResponse(String html) {
		writeResponse(html, TYPE_HTML);
	}

	/**
	 * Escreve o retorno de uma solicitação Ajax
	 * @param message Mensagem que será escrita no retorno
	 * @param contentType Tipo do retorno
	 */
	private static void writeResponse(String message, String contentType) {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setHeader("Content-Type", contentType);
		try {
			ServletOutputStream out = response.getOutputStream();
			out.write(message.getBytes("UTF-8"));
			out.flush();
			out.close();
			response.setStatus(HttpServletResponse.SC_OK);
		} catch (IOException e) {
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		}
	}

}
