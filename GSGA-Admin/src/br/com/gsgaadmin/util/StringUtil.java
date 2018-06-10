package br.com.gsgaadmin.util;

import java.io.Writer;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.json.JsonHierarchicalStreamDriver;
import com.thoughtworks.xstream.io.json.JsonWriter;

public final class StringUtil {

	/**
	 * Construtor privado
	 */
	private StringUtil() {
		/* empty */
	}

	/**
	 * Verifica se uma string é nula ou vazia
	 * @param str String - Objeto string
	 * @return boolean - Verdadeiro se a string passada for nula ou vazia
	 */
	public static boolean isEmpty(String str) {
		return ((str == null) || ("".equals(str.trim())));
	}

	/**
	 * Verifica se uma string não é nula ou vazia
	 * @param str String - Objeto string
	 * @return boolean - Verdadeiro se a string passada for nula ou vazia
	 */
	public static boolean isNotEmpty(String str) {
		return !isEmpty(str);
	}

   /**
	 * Faz o parse de um objeto para um JSON string
	 * @param object Object - Objeto que será parseado
	 * @return String - JSON string
	 */
	public static String parseObjectToJson(Object object) {
		final XStream xstream = new XStream(new JsonHierarchicalStreamDriver() {
			public HierarchicalStreamWriter createWriter(final Writer writer) {
				return new JsonWriter(writer, JsonWriter.DROP_ROOT_MODE);
			}
		});
		return xstream.toXML(object);
	}

	/**
	 * Insere um '%' a direita de uma string
	 * @param str String - Objeto string
	 * @return String - A nova string
	 */
	public static String likeRight(String str){
		return str.concat("%");
	}

	/**
	 * Insere um '%' a direita e a esquerda de uma string
	 * @param str String - Objeto string
	 * @return String - A nova string
	 */
	public static String likeBoth(String str){
		return "%".concat(likeRight(str));
	}

	/**
	 * Formata um número de telefone aplicando a máscara (999)9999-9999
	 * @param ddd - do tipo String
	 * @param telefone - do tipo String 
	 * @return contato - com o telefone formatado
	 */
	public static String formatarTelefone(String ddd, String telefone){
		StringBuilder contato = new StringBuilder();
		if(ddd.length() < 3){
			for (int i = 0; i < 3 - ddd.length(); i++) {
				contato.append("0");
			}
		}
		contato.append(ddd).append(telefone);
		
		return contato.toString();
	}
	
	/**
	 * Formata um número de telefone aplicando a máscara (999)9999-9999
	 * @param ddd - do tipo String
	 * @param telefone - do tipo String 
	 * @return contato - com o telefone formatado
	 */
	public static String formatarTelefoneMask(String ddd, String telefone){
		StringBuilder contato = new StringBuilder();
		String telefoneAux    = "";
		if(ddd.length() < 3){
			for (int i = 0; i < 3 - ddd.length(); i++) {
				contato.append("0");
			}
		}
		
		telefoneAux = telefone.substring(0,4).concat("-").concat(telefone.substring(4,telefone.length()));
		
		contato.insert(0,"(").append(ddd).append(") ").append(telefoneAux);
		
		return contato.toString();
	}

	/**
	 * Insere o comando where quando for necessário. Se a query ja possuir, é utilizado o comando AND
	 * @param sql  - query para ser tratada
	 * @param dado - valor para ser inserido na query
	 * @return retorno - Query com o tratamento efetuado
	 */
	public static String getWhereOrAnd(String sql, String dado){
		String retorno;
		if(sql.toLowerCase().contains(" where ")){
			retorno = " and ".concat(dado);
		}else{
			retorno = " where ".concat(dado);
		}
		return retorno;
	}

}