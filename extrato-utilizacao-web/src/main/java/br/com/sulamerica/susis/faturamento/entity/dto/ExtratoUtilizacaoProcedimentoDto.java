package br.com.sulamerica.susis.faturamento.entity.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Date;

import br.com.sulamerica.susis.faturamento.extrato.utils.ExtratoDateFormatter;

public class ExtratoUtilizacaoProcedimentoDto implements Serializable {

	private static final long serialVersionUID = -3855805964071703123L;
	private Date dataAtendimento;
	private Date dataFimCobranca;
	private String dataAtendimentoString;
	private String dataFimCobrancaString;
	private String codigoProcedimento;
	private String descricaoProcedimento;
	private String codigoGuia;
	private Long totalQuantidadeProcedimento;
	private BigDecimal totalValorProcedimento;
	private BigDecimal totalValorCoparticipacao;
	
	private String totalValorProcedimentoString;
	private String totalValorCoparticipacaoString;

	private String motivoEncerramento;

	public Date getDataAtendimento() {
		return dataAtendimento;
	}

	public Date getDataFimCobranca() {
		return dataFimCobranca;
	}

	public String getDataAtendimentoString() {
		dataAtendimentoString = ExtratoDateFormatter.formatDDMMYYYY(this.dataAtendimento);
		return dataAtendimentoString;
	}

	public void setDataAtendimento(Date dataAtendimento) {
		this.dataAtendimento = dataAtendimento;
	}

	public String getDataFimCobrancaString() {
		dataFimCobrancaString = ExtratoDateFormatter.formatDDMMYYYY(this.dataFimCobranca);
		return dataFimCobrancaString;
	}

	public void setDataFimCobranca(Date dataFimCobranca) {
		this.dataFimCobranca = dataFimCobranca;
	}

	public String getCodigoProcedimento() {
		return codigoProcedimento;
	}

	public void setCodigoProcedimento(String codigoProcedimento) {
		this.codigoProcedimento = codigoProcedimento;
	}

	public String getDescricaoProcedimento() {
		return descricaoProcedimento;
	}

	public void setDescricaoProcedimento(String descricaoProcedimento) {
		this.descricaoProcedimento = descricaoProcedimento;
	}

	public String getCodigoGuia() {
		return codigoGuia;
	}

	public void setCodigoGuia(String codigoGuia) {
		this.codigoGuia = codigoGuia;
	}

	public Long getTotalQuantidadeProcedimento() {
		return totalQuantidadeProcedimento;
	}

	public void setTotalQuantidadeProcedimento(Long totalQuantidadeProcedimento) {
		this.totalQuantidadeProcedimento = totalQuantidadeProcedimento;
	}

	public BigDecimal getTotalValorProcedimento() {
		return totalValorProcedimento;
	}

	public void setTotalValorProcedimento(BigDecimal totalValorProcedimento) {
		this.totalValorProcedimento = totalValorProcedimento;

		if(this.totalValorProcedimento == null){
			return;
		}
		
		this.setTotalValorProcedimentoString(DecimalFormat.getCurrencyInstance().format(this.totalValorProcedimento));
	}

	public String getMotivoEncerramento() {
		return motivoEncerramento;
	}

	public void setMotivoEncerramento(String motivoEncerramento) {
		this.motivoEncerramento = motivoEncerramento;
	}

	public BigDecimal getTotalValorCoparticipacao() {
		return totalValorCoparticipacao;
	}

	public void setTotalValorCoparticipacao(BigDecimal totalValorCoparticipacao) {
		this.totalValorCoparticipacao = totalValorCoparticipacao;
		
		if(this.totalValorCoparticipacao == null){
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

	public void setDataAtendimentoString(String dataAtendimentoString) {
		this.dataAtendimentoString = dataAtendimentoString;
	}

	public void setDataFimCobrancaString(String dataFimCobrancaString) {
		this.dataFimCobrancaString = dataFimCobrancaString;
	}
}
