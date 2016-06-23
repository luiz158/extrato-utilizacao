package br.com.sulamerica.types;

public enum TiposDespesa {
	CONSULTA("1 - Consulta"),
	EXAMES_TERAPIAS("2 - Exames / Terapias"),
	INTERNACAO("3 - Internação"),
	OUTRAS_DESPESAS("4 - Outras Despesas");
	
	private String value;
	
	private TiposDespesa(String value) {
		this.value = value;
	}

	public String value() {
		return value;
	}
}
