package br.com.sulamerica.susis.faturamento.factory;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import br.com.sulamerica.susis.faturamento.entity.dto.ExtratoUtilizacaoCategoriaDespesaDto;
import br.com.sulamerica.susis.faturamento.entity.dto.ExtratoUtilizacaoDadosDto;
import br.com.sulamerica.susis.faturamento.entity.dto.ExtratoUtilizacaoPrestadoresDto;
import br.com.sulamerica.susis.faturamento.entity.dto.ExtratoUtilizacaoProcedimentoDto;


public class ExtratoUtilizacaoDadosFactory {
	
	public static void main(String[] args) {
		load();
	}

	public static List<ExtratoUtilizacaoDadosDto> load() {
		List<ExtratoUtilizacaoDadosDto> list = new ArrayList<ExtratoUtilizacaoDadosDto>();
		
		ExtratoUtilizacaoDadosDto extrato = new ExtratoUtilizacaoDadosDto();
		extrato.setCodigoBeneficiario("123456789012345");
		extrato.setRegistroAns("123456");
		extrato.setNomeBeneficiario("Paulo Sergio Bruno");
		extrato.setCartaoNacionalSaude("45676548923");
		extrato.setCodigoPlanoAns("465573838272722");
		extrato.setNomePlanoAns("Exato");
		extrato.setDataInicial(new Date());
		extrato.setDataFinal(new Date());
		
		extrato.setCategoriaDespesas(criarListaCategoriaDespesas());

		list.add(extrato);
		
		return list;
	}
	
	private static final List<ExtratoUtilizacaoCategoriaDespesaDto> criarListaCategoriaDespesas(){
		List<ExtratoUtilizacaoCategoriaDespesaDto> categorias = new ArrayList<ExtratoUtilizacaoCategoriaDespesaDto>();
		
		ExtratoUtilizacaoCategoriaDespesaDto categoriaConsulta = new ExtratoUtilizacaoCategoriaDespesaDto();
		categoriaConsulta.setCategoriaDespesa("1 - Consulta");
		categoriaConsulta.setPrestadores(criarListaPrestadoresConsulta());
		categorias.add(categoriaConsulta);
		
		ExtratoUtilizacaoCategoriaDespesaDto categoriaExamesTerapias = new ExtratoUtilizacaoCategoriaDespesaDto();
		categoriaExamesTerapias.setCategoriaDespesa("2 - Exames / Terapias");
		categoriaExamesTerapias.setPrestadores(criarListaPrestadoresExamesTerapias());
		categorias.add(categoriaExamesTerapias);
		
		ExtratoUtilizacaoCategoriaDespesaDto categoriaInternacao = new ExtratoUtilizacaoCategoriaDespesaDto();
		categoriaInternacao.setCategoriaDespesa("3 - Internação");
		categoriaInternacao.setPrestadores(criarListaPrestadoresInternacao());
		categorias.add(categoriaInternacao);
		
		ExtratoUtilizacaoCategoriaDespesaDto categoriaOutrasDespesas = new ExtratoUtilizacaoCategoriaDespesaDto();
		categoriaOutrasDespesas.setCategoriaDespesa("4 - Outras Despesas");
		categoriaOutrasDespesas.setPrestadores(criarListaPrestadoresOutrasDespesas());
		categorias.add(categoriaOutrasDespesas);
		
		
		return categorias;
	}
	
	private static final List<ExtratoUtilizacaoPrestadoresDto> criarListaPrestadoresConsulta(){
		List<ExtratoUtilizacaoPrestadoresDto> prestadores = new ArrayList<ExtratoUtilizacaoPrestadoresDto>();
		ExtratoUtilizacaoPrestadoresDto prestador = new ExtratoUtilizacaoPrestadoresDto();
		prestador.setNomePrestador("Dr. Fulano de Tal");
		prestador.setNumCpfCnpjPrestador("12345678910");
		prestador.setMunicipioPrestador("São Paulo");
		prestador.setDescricaoOcupacao("Clínico Geral");
		prestador.setProcedimentos(criarProcedimentosConsulta());
		prestador.setTotalValorProcedimento(new BigDecimal(170.0d));
		prestador.setTotalValorCoparticipacao(new BigDecimal(45.0d));
		prestadores.add(prestador);
		
		return prestadores;
	}
	
	
	private static final List<ExtratoUtilizacaoPrestadoresDto> criarListaPrestadoresExamesTerapias(){
		List<ExtratoUtilizacaoPrestadoresDto> prestadores = new ArrayList<ExtratoUtilizacaoPrestadoresDto>();
		
		ExtratoUtilizacaoPrestadoresDto prestadorDelboni = new ExtratoUtilizacaoPrestadoresDto();
		prestadorDelboni.setNomePrestador("Laboratório Delbini Auriemo");
		prestadorDelboni.setNumCpfCnpjPrestador("23456768/0001-34");
		prestadorDelboni.setMunicipioPrestador("São Paulo");
		prestadorDelboni.setDescricaoOcupacao("Laboratório de Análises clínicas");
		prestadorDelboni.setProcedimentos(criarProcedimentosExamesTerapiasDelboni());
		prestadores.add(prestadorDelboni);
		
		ExtratoUtilizacaoPrestadoresDto prestadorFleury = new ExtratoUtilizacaoPrestadoresDto();
		prestadorFleury.setNomePrestador("Laboratório Fleury Ltda");
		prestadorFleury.setNumCpfCnpjPrestador("22556439/0001-30");
		prestadorFleury.setMunicipioPrestador("São Paulo");
		prestadorFleury.setDescricaoOcupacao("Laboratório de Análises clínicas");
		prestadorFleury.setProcedimentos(criarProcedimentosExamesTerapiasFleury());
		prestadores.add(prestadorFleury);
		
		ExtratoUtilizacaoPrestadoresDto prestadorCiclanaDeTal = new ExtratoUtilizacaoPrestadoresDto();
		prestadorCiclanaDeTal.setNomePrestador("Dr. Ciclana de Tal");
		prestadorCiclanaDeTal.setNumCpfCnpjPrestador("246123789-23");
		prestadorCiclanaDeTal.setMunicipioPrestador("São Paulo");
		prestadorCiclanaDeTal.setDescricaoOcupacao("Psicóloga");
		prestadorCiclanaDeTal.setProcedimentos(criarProcedimentosExamesCiclanaDeTal());
		prestadores.add(prestadorCiclanaDeTal);
		
		return prestadores;
	}
	
	private static List<ExtratoUtilizacaoPrestadoresDto> criarListaPrestadoresInternacao(){
		
		List<ExtratoUtilizacaoPrestadoresDto> prestadores = new ArrayList<ExtratoUtilizacaoPrestadoresDto>();
		
		ExtratoUtilizacaoPrestadoresDto prestadorSaoLuiz = new ExtratoUtilizacaoPrestadoresDto();
		prestadorSaoLuiz.setNomePrestador("Hospital São Luiz");
		prestadorSaoLuiz.setNumCpfCnpjPrestador("30345231/0001-10");
		prestadorSaoLuiz.setMunicipioPrestador("São Paulo");
		prestadorSaoLuiz.setProcedimentos(criarProcedimentosInternacaoSaoLuiz());
		prestadores.add(prestadorSaoLuiz);
		
		return prestadores;
	}
	
	private static List<ExtratoUtilizacaoPrestadoresDto> criarListaPrestadoresOutrasDespesas(){
		
		List<ExtratoUtilizacaoPrestadoresDto> prestadores = new ArrayList<ExtratoUtilizacaoPrestadoresDto>();
		
		ExtratoUtilizacaoPrestadoresDto prestadorSaoLuiz = new ExtratoUtilizacaoPrestadoresDto();
		prestadorSaoLuiz.setNomePrestador("Hospital São Luiz");
		prestadorSaoLuiz.setNumCpfCnpjPrestador("30345231/0001-10");
		prestadorSaoLuiz.setMunicipioPrestador("São Paulo");
		prestadorSaoLuiz.setProcedimentos(criarProcedimentosOutrasDespesasSaoLuiz());
		prestadores.add(prestadorSaoLuiz);
		
		ExtratoUtilizacaoPrestadoresDto prestadorHospitalDaLuz = new ExtratoUtilizacaoPrestadoresDto();
		prestadorHospitalDaLuz.setNomePrestador("Hospital da Luz");
		prestadorHospitalDaLuz.setNumCpfCnpjPrestador("32677344/0001-20");
		prestadorHospitalDaLuz.setMunicipioPrestador("Diadema");
		prestadorHospitalDaLuz.setProcedimentos(criarProcedimentosOutrasDespesasHospitalDaLuz());
		prestadores.add(prestadorHospitalDaLuz);
		
		return prestadores;
	}
	
	private static List<ExtratoUtilizacaoProcedimentoDto> criarProcedimentosOutrasDespesasHospitalDaLuz() {
		
		Calendar calendar = Calendar.getInstance();
		List<ExtratoUtilizacaoProcedimentoDto> procedimentos = new ArrayList<ExtratoUtilizacaoProcedimentoDto>();
		
		ExtratoUtilizacaoProcedimentoDto procedimento2 = new ExtratoUtilizacaoProcedimentoDto();
		calendar.set(2015, 2, 13);
		procedimento2.setDataAtendimento(calendar.getTime());
		procedimento2.setCodigoProcedimento("20105070");
		procedimento2.setDescricaoProcedimento("QT Oral");
		procedimento2.setMotivoEncerramento("");
		procedimento2.setTotalQuantidadeProcedimento(1l);
		procedimento2.setTotalValorProcedimento(new BigDecimal(970.0d));
		procedimento2.setTotalValorCoparticipacao(new BigDecimal(130.0d));
		procedimentos.add(procedimento2);
		
		return procedimentos;
	}

	private static List<ExtratoUtilizacaoProcedimentoDto> criarProcedimentosOutrasDespesasSaoLuiz() {
		
		Calendar calendar = Calendar.getInstance();
		List<ExtratoUtilizacaoProcedimentoDto> procedimentos = new ArrayList<ExtratoUtilizacaoProcedimentoDto>();
		
		ExtratoUtilizacaoProcedimentoDto procedimento1 = new ExtratoUtilizacaoProcedimentoDto();
		calendar.set(2015, 1, 23);
		procedimento1.setDataAtendimento(calendar.getTime());
		procedimento1.setCodigoProcedimento("40310353");
		procedimento1.setDescricaoProcedimento("Vacina autógena");
		procedimento1.setMotivoEncerramento("");
		procedimento1.setTotalQuantidadeProcedimento(1l);
		procedimento1.setTotalValorProcedimento(new BigDecimal(130.0d));
		procedimento1.setTotalValorCoparticipacao(new BigDecimal(20.0d));
		procedimentos.add(procedimento1);
		
		return procedimentos;
	}

	private static List<ExtratoUtilizacaoProcedimentoDto> criarProcedimentosInternacaoSaoLuiz() {
		
		Calendar calendar = Calendar.getInstance();
		List<ExtratoUtilizacaoProcedimentoDto> procedimentos = new ArrayList<ExtratoUtilizacaoProcedimentoDto>();
		
		ExtratoUtilizacaoProcedimentoDto procedimento1 = new ExtratoUtilizacaoProcedimentoDto();
		calendar.set(2015, 2, 2);
		procedimento1.setDataAtendimento(calendar.getTime());
		
		calendar.set(2015, 2, 15);
		procedimento1.setDataFimCobranca(calendar.getTime());
		
		procedimento1.setCodigoProcedimento("20203012");
		procedimento1.setDescricaoProcedimento("Assistência fisiátrica respiratória em paciente internado com ventilação mecânica");
		procedimento1.setMotivoEncerramento("18 - Alta por outros motivos");
		procedimento1.setTotalQuantidadeProcedimento(1l);
		procedimento1.setTotalValorProcedimento(new BigDecimal(17000.0d));
		procedimento1.setTotalValorCoparticipacao(new BigDecimal(3400.0d));
		procedimentos.add(procedimento1);
		
		return procedimentos;
	}

	private static List<ExtratoUtilizacaoProcedimentoDto> criarProcedimentosExamesTerapiasFleury() {
		
		Calendar calendar = Calendar.getInstance();
		List<ExtratoUtilizacaoProcedimentoDto> procedimentos = new ArrayList<ExtratoUtilizacaoProcedimentoDto>();
		
		ExtratoUtilizacaoProcedimentoDto procedimento1 = new ExtratoUtilizacaoProcedimentoDto();
		calendar.set(2015, 4, 5);
		procedimento1.setDataAtendimento(calendar.getTime());
		procedimento1.setCodigoProcedimento("40304361");
		procedimento1.setDescricaoProcedimento("Hemograma com contagem de plaquetas ou frações (eritrograma, leucograma, plaquetas)");
		procedimento1.setMotivoEncerramento("");
		procedimento1.setTotalQuantidadeProcedimento(1l);
		procedimento1.setTotalValorProcedimento(new BigDecimal(45.0d));
		procedimento1.setTotalValorCoparticipacao(new BigDecimal(7.5d));
		procedimentos.add(procedimento1);
		
		return procedimentos;
	}
	
	private static List<ExtratoUtilizacaoProcedimentoDto> criarProcedimentosExamesCiclanaDeTal() {
		
		Calendar calendar = Calendar.getInstance();
		List<ExtratoUtilizacaoProcedimentoDto> procedimentos = new ArrayList<ExtratoUtilizacaoProcedimentoDto>();
		
		ExtratoUtilizacaoProcedimentoDto procedimento1 = new ExtratoUtilizacaoProcedimentoDto();
		calendar.set(2015, 5, 21);
		procedimento1.setDataAtendimento(calendar.getTime());
		procedimento1.setCodigoProcedimento("20104014");
		procedimento1.setDescricaoProcedimento("Actinoterapia (por sessão)");
		procedimento1.setMotivoEncerramento("16 - Alta por Evasão");
		procedimento1.setTotalQuantidadeProcedimento(1l);
		procedimento1.setTotalValorProcedimento(new BigDecimal(400.0d));
		procedimento1.setTotalValorCoparticipacao(new BigDecimal(100.0d));
		
		procedimentos.add(procedimento1);
		
		return procedimentos;
	}

	private static final List<ExtratoUtilizacaoProcedimentoDto> criarProcedimentosConsulta(){
		
		Calendar calendar = Calendar.getInstance();
		List<ExtratoUtilizacaoProcedimentoDto> procedimentos = new ArrayList<ExtratoUtilizacaoProcedimentoDto>();
		
		ExtratoUtilizacaoProcedimentoDto procedimento1 = new ExtratoUtilizacaoProcedimentoDto();
		calendar.set(2015, 0, 23);
		procedimento1.setDataAtendimento(calendar.getTime());
		procedimento1.setCodigoProcedimento("1010106030");
		procedimento1.setDescricaoProcedimento("Atendimento ao familiar do adolescente");
		procedimento1.setTotalQuantidadeProcedimento(1l);
		procedimento1.setTotalValorProcedimento(new BigDecimal(85.0d));
		procedimento1.setTotalValorCoparticipacao(new BigDecimal(22.5d));
		
		ExtratoUtilizacaoProcedimentoDto procedimento2 = new ExtratoUtilizacaoProcedimentoDto();
		calendar.set(2015, 3, 12);
		procedimento2.setDataAtendimento(calendar.getTime());
		procedimento2.setCodigoProcedimento("1010106030");
		procedimento2.setDescricaoProcedimento("Atendimento ao familiar do adolescente");
		procedimento2.setTotalQuantidadeProcedimento(1l);
		procedimento2.setTotalValorProcedimento(new BigDecimal(85.0d));
		procedimento2.setTotalValorCoparticipacao(new BigDecimal(22.5d));
		
		procedimentos.add(procedimento1);
		procedimentos.add(procedimento2);
		
		return procedimentos;
	}
	
	private static final List<ExtratoUtilizacaoProcedimentoDto> criarProcedimentosExamesTerapiasDelboni(){
		
		Calendar calendar = Calendar.getInstance();
		List<ExtratoUtilizacaoProcedimentoDto> procedimentos = new ArrayList<ExtratoUtilizacaoProcedimentoDto>();
		
		ExtratoUtilizacaoProcedimentoDto procedimento1 = new ExtratoUtilizacaoProcedimentoDto();
		calendar.set(2015, 2, 23);
		procedimento1.setDataAtendimento(calendar.getTime());
		procedimento1.setCodigoProcedimento("20102020");
		procedimento1.setDescricaoProcedimento("Holter de 24 horas - 3 canais - digital");
		procedimento1.setMotivoEncerramento("");
		procedimento1.setTotalQuantidadeProcedimento(1l);
		procedimento1.setTotalValorProcedimento(new BigDecimal(195.0d));
		procedimento1.setTotalValorCoparticipacao(new BigDecimal(0.0d));
		procedimentos.add(procedimento1);
		
		return procedimentos;
	}
}

