package br.com.tabajara.crm;

public enum StatusCliente {
	// TODO messageKey
	ATIVO("A", "Ativo"), SUSPENSO("S", "Suspenso"), INADIMPLENTE("I",
			"Inadimplente");

	private String sigla;
	private String nomeParaExibicao;

	private StatusCliente(String sigla, String nomeParaExibicao) {
		this.sigla = sigla;
		this.nomeParaExibicao = nomeParaExibicao;
	}

	public String getSigla() {
		return sigla;
	}

	public static StatusCliente porSigla(String sigla) {
		if (sigla != null) {
			for (StatusCliente status : StatusCliente.values()) {
				if (sigla.equalsIgnoreCase(status.getSigla())) {
					return status;
				}
			}
		}
		throw new IllegalArgumentException("sigla invalida: " + sigla);
		// return null;
	}

	@Override
	public String toString() {
		return this.nomeParaExibicao;
	}

}
