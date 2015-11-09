package br.com.tabajara.crm;

import br.com.tabajara.base.CPF;
import br.com.tabajara.base.Pessoa;

public class Cliente extends Pessoa implements Comparable<Cliente> {

	// private final static int STATUS_ATIVO = 1;
	// private final static int STATUS_SUSPENSO = 2;

	private StatusCliente status = StatusCliente.ATIVO;
	private CPF cpf;

	public StatusCliente getStatus() {
		return status;
	}

	public void suspender() {
		this.status = StatusCliente.SUSPENSO;
	}

	public void ativar() {
		this.status = StatusCliente.ATIVO;
	}

	public CPF getCpf() {
		return cpf;
	}

	public void setCpf(CPF cpf) {
		this.cpf = cpf;
	}

	public boolean isAtivo() {
		// if (this.status == 1) {
		// return true;
		// } else {
		// return false;
		// }

		return (this.status == StatusCliente.ATIVO);
	}

	public boolean isSuspenso() {
		return (this.status == StatusCliente.SUSPENSO);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return super.toString() + " " + this.status;
	}

	@Override
	public int compareTo(Cliente other) {
		return this.getNome().compareTo(other.getNome());
	}
}
