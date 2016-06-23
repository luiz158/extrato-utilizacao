package br.com.sulamerica.susis.faturamento.extrato.utils;

import java.io.File;

import javax.servlet.ServletContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ExtratoReportUtil {
	
	private static Log log = LogFactory.getLog(ExtratoReportUtil.class);

	/**
	 * Caminho para a imagem logoSulamerica.png
	 * @param context - {@link ServletContext}
	 * @return String - caminho completo do arquivo logoSulamerica.png
	 */
	public static String caminhoLogoSulamerica(ServletContext context){
		
		StringBuilder path = new StringBuilder();

		path.append(context.getRealPath(".")).append(File.separator);
		path.append("images").append(File.separator).append("logoSulamerica.png");
		
		log.info(String.format("logoSulamerica.png: %s", path.toString()));
		
		return path.toString();
	}
	
	/**
	 * Retorna o caminho completo para o arquivo jrxml correspondente
	 * @param context - {@link ServletContext}
	 * @return - A string com o caminho completo para o arquivo extrato-utilizacao.jrxml
	 */
	public static String caminhoJrxml(ServletContext context){

		String jrxml = "extrato-utilizacao.jrxml";
		
		StringBuilder path = new StringBuilder();
		path.append(context.getRealPath(".")).append(File.separator);
		path.append("report").append(File.separator);
		path.append(jrxml);

		log.info(String.format("Caminho do jrxml: %s", path.toString()));
		
		return path.toString();
	}
}