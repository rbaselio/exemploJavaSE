package br.com.tabajara.base;

public class CPF implements Comparable<CPF> {

	private String numero;

	/**
	 * 
	 * @param numero
	 * @throws CPFInvalidoException
	 *             Quando o numero do cpf é inválido
	 */
	public CPF(String numero) throws CPFInvalidoException {
		validar(numero);
		this.numero = numero;
	}

	private void validar(String numero) throws CPFInvalidoException {
		if (numero == null || numero.equals("") || numero.equals("0")) {
			throw new CPFInvalidoException("cpf invalido: " + numero);
		}
	}

	public String getNumero() {
		return numero;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((numero == null) ? 0 : numero.hashCode());
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
		CPF other = (CPF) obj;
		if (numero == null) {
			if (other.numero != null)
				return false;
		} else if (!numero.equals(other.numero))
			return false;
		return true;
	}

	@Override
	public int compareTo(CPF other) {
		return this.numero.compareTo(other.numero);
	}

}
