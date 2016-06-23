package br.com.sulamerica.controller;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import br.com.sulamerica.susis.faturamento.entity.dto.ExtratoUtilizacaoDadosDto;
import br.com.sulamerica.susis.faturamento.factory.ExtratoUtilizacaoDadosFactory;

@Controller
@RequestMapping("/extrato")
public class ExtratoController {
	
	public static final String URL_LOCAL = "http://localhost:9090/mangani-rest/rest/controller/extrato";
	public static final String URL_DESENV = "http://sauded-intranet.sulamerica.br/faturamentoreports/rest/faturamento/extratoUtilizacao/imprimir";
	
	@RequestMapping(value="/utilizacao", method=RequestMethod.GET)
	public void imprimirExtratoUtilizacao(HttpServletRequest req, HttpServletResponse resp){
		
		try {
			ExtratoUtilizacaoDadosDto extrato = ExtratoUtilizacaoDadosFactory.load().get(0);
			
			RestTemplate restTemplate = new RestTemplate();
			HttpEntity<ExtratoUtilizacaoDadosDto> requestEntity = new HttpEntity<ExtratoUtilizacaoDadosDto>(extrato); 
			ResponseEntity<byte[]> responseEntity = restTemplate.exchange(URL_DESENV, HttpMethod.POST, requestEntity, byte[].class);
			
			resp.setContentType("application/pdf");
			resp.addHeader("Content-Disposition", "attachment; filename=extrato-utilizacao-" + extrato.getCodigoBeneficiario() + ".pdf");
			
			ServletOutputStream sos = resp.getOutputStream();
			sos.write(responseEntity.getBody());
			sos.flush();
			sos.close();
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
}
