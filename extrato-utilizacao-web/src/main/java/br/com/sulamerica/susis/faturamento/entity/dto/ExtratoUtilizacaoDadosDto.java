package br.com.sulamerica.susis.faturamento.entity.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.sulamerica.susis.faturamento.extrato.utils.ExtratoDateFormatter;
import br.com.sulamerica.types.TiposDespesa;

public class ExtratoUtilizacaoDadosDto implements Serializable {

	private static final long serialVersionUID = 5388416647291877277L;
	private String codigoBeneficiario;
	private String registroAns;
	private String nomeBeneficiario;
	private String cartaoNacionalSaude;
	private String codigoPlanoAns;
	private String nomePlanoAns;

	private Date dataInicial;
	private Date dataFinal;
	
	private String mesAnoInicioApresentacao;
	private String mesAnoFimApresentacao;
	
	private List<ExtratoUtilizacaoCategoriaDespesaDto> categoriaDespesas;
	
	private List<ExtratoUtilizacaoCategoriaDespesaDto> consultas;
	private List<ExtratoUtilizacaoCategoriaDespesaDto> examesTerapias;
	private List<ExtratoUtilizacaoCategoriaDespesaDto> internacoes;
	private List<ExtratoUtilizacaoCategoriaDespesaDto> outrasDespesas;

	public ExtratoUtilizacaoDadosDto(){
		categoriaDespesas = new ArrayList<ExtratoUtilizacaoCategoriaDespesaDto>();
		consultas = new ArrayList<ExtratoUtilizacaoCategoriaDespesaDto>();
		examesTerapias = new ArrayList<ExtratoUtilizacaoCategoriaDespesaDto>();
		internacoes = new ArrayList<ExtratoUtilizacaoCategoriaDespesaDto>();
		outrasDespesas = new ArrayList<ExtratoUtilizacaoCategoriaDespesaDto>();
	}
	
	public String getCodigoBeneficiario() {
		return codigoBeneficiario;
	}

	public void setCodigoBeneficiario(String codigoBeneficiario) {
		this.codigoBeneficiario = codigoBeneficiario;
	}

	public String getRegistroAns() {
		return registroAns;
	}

	public void setRegistroAns(String registroAns) {
		this.registroAns = registroAns;
	}

	public String getNomeBeneficiario() {
		return nomeBeneficiario;
	}

	public void setNomeBeneficiario(String nomeBeneficiario) {
		this.nomeBeneficiario = nomeBeneficiario;
	}

	public String getCartaoNacionalSaude() {
		return cartaoNacionalSaude;
	}

	public void setCartaoNacionalSaude(String cartaoNacionalSaude) {
		this.cartaoNacionalSaude = cartaoNacionalSaude;
	}

	public String getCodigoPlanoAns() {
		return codigoPlanoAns;
	}

	public void setCodigoPlanoAns(String codigoPlanoAns) {
		this.codigoPlanoAns = codigoPlanoAns;
	}

	public String getNomePlanoAns() {
		return nomePlanoAns;
	}

	public void setNomePlanoAns(String nomePlanoAns) {
		this.nomePlanoAns = nomePlanoAns;
	}

	public Date getDataInicial() {
		return dataInicial;
	}

	public void setDataInicial(Date dataInicial) {
		this.dataInicial = dataInicial;
		this.setMesAnoInicioApresentacao(ExtratoDateFormatter.formatMesAno(this.dataInicial));
	}

	public Date getDataFinal() {
		return dataFinal;
	}

	public void setDataFinal(Date dataFinal) {
		this.dataFinal = dataFinal;
		this.setMesAnoFimApresentacao(ExtratoDateFormatter.formatMesAno(this.dataFinal));
	}

	public List<ExtratoUtilizacaoCategoriaDespesaDto> getCategoriaDespesas() {
		
		return categoriaDespesas;
	}

	public void setCategoriaDespesas(List<ExtratoUtilizacaoCategoriaDespesaDto> categoriaDespesas) {
		this.categoriaDespesas = categoriaDespesas;
	}

	public List<ExtratoUtilizacaoCategoriaDespesaDto> getConsultas() {
		
		for (ExtratoUtilizacaoCategoriaDespesaDto despesa : categoriaDespesas) {
			if(TiposDespesa.CONSULTA.value().equalsIgnoreCase(despesa.getCategoriaDespesa())){
				consultas.add(despesa);
			}
		}
		
		return consultas;
	}

	public List<ExtratoUtilizacaoCategoriaDespesaDto> getExamesTerapias() {
		
		for (ExtratoUtilizacaoCategoriaDespesaDto despesa : categoriaDespesas) {
			
			if(TiposDespesa.EXAMES_TERAPIAS.value().equalsIgnoreCase(despesa.getCategoriaDespesa())){
				examesTerapias.add(despesa);
			}
		}
		
		return examesTerapias;
	}

	public List<ExtratoUtilizacaoCategoriaDespesaDto> getInternacoes() {
		
		for (ExtratoUtilizacaoCategoriaDespesaDto despesa : categoriaDespesas) {
			if(TiposDespesa.INTERNACAO.value().equalsIgnoreCase(despesa.getCategoriaDespesa())){
				internacoes.add(despesa);
			}
		}
		
		return internacoes;
	}

	public List<ExtratoUtilizacaoCategoriaDespesaDto> getOutrasDespesas() {
		
		for (ExtratoUtilizacaoCategoriaDespesaDto despesa : categoriaDespesas) {
			if(TiposDespesa.OUTRAS_DESPESAS.value().equalsIgnoreCase(despesa.getCategoriaDespesa())){
				outrasDespesas.add(despesa);
			}
		}
		
		return outrasDespesas;
	}

	public String getMesAnoInicioApresentacao() {
		return mesAnoInicioApresentacao;
	}

	public void setMesAnoInicioApresentacao(String mesAnoInicioApresentacao) {
		this.mesAnoInicioApresentacao = mesAnoInicioApresentacao;
	}

	public String getMesAnoFimApresentacao() {
		return mesAnoFimApresentacao;
	}

	public void setMesAnoFimApresentacao(String mesAnoFimApresentacao) {
		this.mesAnoFimApresentacao = mesAnoFimApresentacao;
	}

	public void setConsultas(List<ExtratoUtilizacaoCategoriaDespesaDto> consultas) {
		this.consultas = consultas;
	}

	public void setExamesTerapias(List<ExtratoUtilizacaoCategoriaDespesaDto> examesTerapias) {
		this.examesTerapias = examesTerapias;
	}

	public void setInternacoes(List<ExtratoUtilizacaoCategoriaDespesaDto> internacoes) {
		this.internacoes = internacoes;
	}

	public void setOutrasDespesas(List<ExtratoUtilizacaoCategoriaDespesaDto> outrasDespesas) {
		this.outrasDespesas = outrasDespesas;
	}
}

