package br.com.tabajara.sistemaacademico;

import br.com.tabajara.base.Pessoa;

public class Aluno extends Pessoa {

	public static final int QTD_NOTAS = 3;
	private double[] notas = new double[QTD_NOTAS];
	private double media;
	private boolean atualizarMedia = true;

	public boolean isAprovado() {
		return (this.getMedia() > 6);
	}

	public double[] getNotas() {
		return notas;
	}

	void addNota(int numero, double nota) {
		// TODO Lancar erro quando a nota for invalida
		// TODO Lancar erro quando o numero for invalido
		this.notas[numero] = nota;
		this.atualizarMedia = true;
	}

	public double getMedia() {
		if (this.atualizarMedia) {
			this.calcularMedia();
			this.atualizarMedia = false;
		}
		return media;
	}

	private void calcularMedia() {
		double somaDasNotas = 0;

		for (int i = 0; i < this.notas.length; i++) {
			somaDasNotas += this.notas[i];
		}
		this.media = somaDasNotas / this.notas.length;
	}

	@Override
	public String getSaudacao() {
		String saudacao = super.getSaudacao();

		if ("gus".equals(this.getNome())) {
			saudacao += "\nVai curintia";
		}

		return saudacao;
	}

}
