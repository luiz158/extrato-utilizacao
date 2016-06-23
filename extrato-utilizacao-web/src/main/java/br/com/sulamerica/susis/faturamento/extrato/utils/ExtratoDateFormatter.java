package br.com.sulamerica.susis.faturamento.extrato.utils;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

public class ExtratoDateFormatter {
	
	private static final String[] meses = {"Jan", "Fev", "Mar", "Abr", "Mai", "Jun", "Jul", "Ago", "Set", "Out", "Nov", "Dez"};
	private static final String TEMPLATE = "%s/%d";
	
	public static final String formatMesAno(Date date){
		
		Calendar calendar = Calendar.getInstance();
		
		String format = null;
		
		try {
			calendar.setTime(date);
			int mes = calendar.get(Calendar.MONTH);
			int ano = calendar.get(Calendar.YEAR);
			format = String.format(TEMPLATE, meses[mes], ano);
		} catch (Exception e) {
			format = "";
		} 
		
		return format;
	}
	
	public static final String formatDDMMYYYY(Date date){
		
		String dt = null;
		
		try {
			DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM);
			dt = df.format(date);
		} catch (Exception e) {

		}
		
		return dt;
	}
}
