package br.com.gsgaadmin.util;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.joda.time.DateTime;


public class DateUtil {
	
	static final SimpleDateFormat formatUTIL = new SimpleDateFormat("dd/MM/yyyy");
	static final SimpleDateFormat formatSQL  = new SimpleDateFormat("yyyy-MM-dd");

	public static Timestamp truncate(Date data) {
		return new Timestamp(new DateTime(data).plusHours(23).plusMinutes(59).plusMinutes(59).plusSeconds(59).toDate().getTime());
	}
	
	public static String formataDataParaString(java.sql.Date data){
		return formatUTIL.format(data);
	}
	
	public static java.sql.Date formataStringParaSqlDate(String data){
		java.sql.Date dataSQL = null;
		try{
			dataSQL = new java.sql.Date(formatUTIL.parse(data).getTime());
		}catch(Throwable cause){
			cause.printStackTrace();
		}
		
		return dataSQL;
	}
	
	public static java.util.Date formataStringParaUtilDate(String data){
		java.util.Date dataUtil = null;
		try{
			dataUtil = formatUTIL.parse(data);
		}catch(Throwable cause){
			cause.printStackTrace();
		}
		
		return dataUtil;
	}
	
	
	public static String getAnoAtual(){
		Calendar calendar = GregorianCalendar.getInstance();  
		return Integer.toString(calendar.get(Calendar.YEAR)); 
	}
}
