package br.com.tabajara.base;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class Pessoa {

	private String nome;
	private int idade;
	private Date dataNascimento;

	public final String getNome() {
		if (this.nome == null) {
			return "";
		}
		return this.nome;
	}

	final void setNome(String nome) {
		this.nome = nome;
	}

	public final int getIdade() {
		return idade;
	}

	public String getSaudacao() {
		String saudacao;
		if (this.getIdade() > 50) {
			saudacao = "Ola Sr(a). " + this.getNome();
		} else {
			saudacao = "Ola " + this.getNome();
		}

		return saudacao;
	}

	public final Date getDataNascimento() {
		return dataNascimento;
	}

	void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
		calcularIdade();
	}

	private void calcularIdade() {
		LocalDate hoje = LocalDate.now();
		LocalDate nascimento = this.dataNascimento.toInstant()
				.atZone(ZoneId.systemDefault()).toLocalDate();
		this.idade = (int) nascimento.until(hoje, ChronoUnit.YEARS);
	}

	@Override
	public String toString() {
		return this.nome;
	}

}
