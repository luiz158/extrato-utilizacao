package br.com.sulamerica.susis.faturamento.entity.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.List;

public class ExtratoUtilizacaoPrestadoresDto implements Serializable {

	private static final long serialVersionUID = 736203686660939372L;
	private String nomePrestador;
	private String numCpfCnpjPrestador;
	private String municipioPrestador;

	private List<ExtratoUtilizacaoProcedimentoDto> procedimentos;

	private Long totalQuantidadeProcedimento;
	private BigDecimal totalValorProcedimento;
	private BigDecimal totalValorCoparticipacao;
	
	private String totalValorProcedimentoString;
	private String totalValorCoparticipacaoString;

	private String descricaoOcupacao;

	public String getNomePrestador() {
		return nomePrestador;
	}

	public void setNomePrestador(String nomePrestador) {
		this.nomePrestador = nomePrestador;
	}

	public String getNumCpfCnpjPrestador() {
		return numCpfCnpjPrestador;
	}

	public void setNumCpfCnpjPrestador(String numCpfCnpjPrestador) {
		this.numCpfCnpjPrestador = numCpfCnpjPrestador;
	}

	public String getMunicipioPrestador() {
		return municipioPrestador;
	}

	public void setMunicipioPrestador(String municipioPrestador) {
		this.municipioPrestador = municipioPrestador;
	}

	public List<ExtratoUtilizacaoProcedimentoDto> getProcedimentos() {
		return procedimentos;
	}

	public void setProcedimentos(List<ExtratoUtilizacaoProcedimentoDto> procedimentos) {
		this.procedimentos = procedimentos;
	}

	public Long getTotalQuantidadeProcedimento() {
		
		totalQuantidadeProcedimento = null;
		if(procedimentos == null || procedimentos.isEmpty()){
			return totalQuantidadeProcedimento;
		}
		
		totalQuantidadeProcedimento = 0l;
		for (ExtratoUtilizacaoProcedimentoDto procedimento : procedimentos) {
			
			if(procedimento.getTotalQuantidadeProcedimento() != null){
				totalQuantidadeProcedimento += procedimento.getTotalQuantidadeProcedimento();
			}
		}
		
		return totalQuantidadeProcedimento;
	}

	public void setTotalQuantidadeProcedimento(Long totalQuantidadeProcedimento) {
		this.totalQuantidadeProcedimento = totalQuantidadeProcedimento;
	}

	public BigDecimal getTotalValorProcedimento() {
		
		totalValorProcedimento = null;
		if(procedimentos == null || procedimentos.isEmpty()){
			return totalValorProcedimento;
		}
		
		double value = 0.0d;
		for (ExtratoUtilizacaoProcedimentoDto procedimento : procedimentos) {
			
			if(procedimento.getTotalValorProcedimento() != null){
				value += procedimento.getTotalValorProcedimento().doubleValue();
			}
		}
		
		this.setTotalValorProcedimento(new BigDecimal(value));
		return totalValorProcedimento;
	}

	public void setTotalValorProcedimento(BigDecimal totalValorProcedimento) {
		this.totalValorProcedimento = totalValorProcedimento;
		
		if(this.totalValorProcedimento == null){
			return;
		}
		
		this.setTotalValorProcedimentoString(DecimalFormat.getCurrencyInstance().format(this.totalValorProcedimento));
	}

	public String getDescricaoOcupacao() {
		return descricaoOcupacao;
	}

	public void setDescricaoOcupacao(String descricaoOcupacao) {
		this.descricaoOcupacao = descricaoOcupacao;
	}

	public BigDecimal getTotalValorCoparticipacao() {
		
		totalValorCoparticipacao = null; 
		if(procedimentos == null || procedimentos.isEmpty()){
			return totalValorCoparticipacao;
		}
		
		double value = 0.0d;
		for (ExtratoUtilizacaoProcedimentoDto procedimento : procedimentos) {
			if(procedimento.getTotalValorCoparticipacao() != null){
				value += procedimento.getTotalValorCoparticipacao().doubleValue();
			}
		}
		
		this.setTotalValorCoparticipacao(new BigDecimal(value));
		return totalValorCoparticipacao; 
	}

	public void setTotalValorCoparticipacao(BigDecimal totalValorCoparticipacao) {
		this.totalValorCoparticipacao = totalValorCoparticipacao;
		
		if(totalValorCoparticipacao == null){
			return;
		}
		
		this.setTotalValorCoparticipacaoString((DecimalFormat.getCurrencyInstance().format(this.totalValorCoparticipacao)));
	}

	public String getTotalValorProcedimentoString() {
		return totalValorProcedimentoString;
	}

	public void setTotalValorProcedimentoString(String totalValorProcedimentoString) {
		this.totalValorProcedimentoString = totalValorProcedimentoString;
	}

	public String getTotalValorCoparticipacaoString() {
		return totalValorCoparticipacaoString;
	}

	public void setTotalValorCoparticipacaoString(String totalValorCoparticipacaoString) {
		this.totalValorCoparticipacaoString = totalValorCoparticipacaoString;
	}
}
