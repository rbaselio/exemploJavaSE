package br.com.tabajara.sistemaacademico;

import java.text.DecimalFormat;

import br.com.tabajara.base.PessoaService;
import br.com.tabajara.ui.Console;

public class AlunoService extends PessoaService<Aluno> {

	public AlunoService(Console console) {
		super(console);
	}

	@Override
	protected void cadastrarDadosEspecificos(Aluno aluno) {
		for (int i = 0; i < Aluno.QTD_NOTAS; i++) {
			double nota = getUI()
					.readDouble("Digite a " + (i + 1) + "a nota :");
			aluno.addNota(i, nota);
		}
	}

	public void exibirBoletim(Aluno aluno) {
		DecimalFormat decimalFormat = new DecimalFormat("#0.00");
		
		for (int i = 0; i < Aluno.QTD_NOTAS; i++) {
			double nota = aluno.getNotas()[i];
			getUI().write((i + 1) + "a nota " + decimalFormat.format(nota));
		}
	}

	public void exibirAprovacao(Aluno aluno) {
		getUI().write("\n\nmedia final: " + aluno.getMedia());
		getUI().write(aluno.getSaudacao());

		if (aluno.isAprovado()) {
			getUI().write("aprovado");
			getUI().write("Meus paraabeeenss...");
		} else {
			getUI().write("reprovado");
		}
	}

}
