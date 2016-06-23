package br.com.sulamerica.susis.faturamento.entity.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.List;

public class ExtratoUtilizacaoCategoriaDespesaDto implements Serializable {

	private static final long serialVersionUID = 365503548920418591L;

	private String categoriaDespesa;

	private List<ExtratoUtilizacaoPrestadoresDto> prestadores;
	
	private Long quantidadeTotal;
	private BigDecimal valorTotalSinistro;
	private BigDecimal valorTotalCoparticipacao;
	
	private String valorTotalSinistroString;
	private String valorTotalCoparticipacaoString;

	public String getCategoriaDespesa() {
		return categoriaDespesa;
	}

	public void setCategoriaDespesa(String categoriaDespesa) {
		this.categoriaDespesa = categoriaDespesa;
	}

	public List<ExtratoUtilizacaoPrestadoresDto> getPrestadores() {
		return prestadores;
	}

	public void setPrestadores(List<ExtratoUtilizacaoPrestadoresDto> prestadores) {
		this.prestadores = prestadores;
	}

	public Long getQuantidadeTotal() {
		
		quantidadeTotal = null;
		if(prestadores == null || prestadores.isEmpty()){
			return quantidadeTotal;
		}
		
		quantidadeTotal = 0l;
		for (ExtratoUtilizacaoPrestadoresDto prestador : prestadores) {
			
			if(prestador.getTotalQuantidadeProcedimento() != null){
				quantidadeTotal += prestador.getTotalQuantidadeProcedimento();
			}
		}
		
		return quantidadeTotal;
	}

	public BigDecimal getValorTotalSinistro() {
		
		valorTotalSinistro = null;
		if(prestadores == null || prestadores.isEmpty()){
			return valorTotalSinistro;
		}
		
		double value = 0.0d;
		
		for (ExtratoUtilizacaoPrestadoresDto prestador : prestadores) {
			
			if(prestador.getTotalValorProcedimento() != null){
				value += prestador.getTotalValorProcedimento().doubleValue();
			}
		}
		
		valorTotalSinistro = new BigDecimal(value);
		return valorTotalSinistro;
	}

	public BigDecimal getValorTotalCoparticipacao() {
		
		valorTotalCoparticipacao = null;
		if(prestadores == null || prestadores.isEmpty()){
			return valorTotalCoparticipacao;
		}
		
		double value = 0.0d;
		
		for (ExtratoUtilizacaoPrestadoresDto prestador : prestadores) {
			
			if(prestador.getTotalValorCoparticipacao() != null){
				value += prestador.getTotalValorCoparticipacao().doubleValue();
			}
		}
		
		valorTotalCoparticipacao = new BigDecimal(value);

		return valorTotalCoparticipacao;
	}

	public String getValorTotalSinistroString() {
		
		if(valorTotalSinistro == null){
			return "";
		}
		
		valorTotalSinistroString = DecimalFormat.getCurrencyInstance().format(this.valorTotalSinistro);
		
		return valorTotalSinistroString;
	}

	public String getValorTotalCoparticipacaoString() {
		
		if(valorTotalCoparticipacao == null){
			return "";
		}
		
		valorTotalCoparticipacaoString = DecimalFormat.getCurrencyInstance().format(this.valorTotalCoparticipacao); 
		
		return valorTotalCoparticipacaoString;
	}
}
