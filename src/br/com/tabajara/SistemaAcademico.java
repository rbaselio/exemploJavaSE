package br.com.tabajara;

import br.com.tabajara.sistemaacademico.Aluno;
import br.com.tabajara.sistemaacademico.AlunoService;
import br.com.tabajara.ui.Console;

public class SistemaAcademico {

	// ok pedir o nome e a idade do aluno
	// ok pedir tres notas do aluno
	// ok calcular a media das notas
	// ok * exibir a media
	// ok exibir cada nota do aluno
	// ok se a media for maior que 6
	// ok .. aluno aprovado
	// ok .. * parabens
	// ok senao
	// ok .. aluno reprovado

	// ok construa um menu com as opcoes
	// ok cadastrar aluno e notas
	// ok exibir boletim
	// ok exibir aprovacao
	// ok sair

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		Console console = new Console();
		AlunoService alunoService = new AlunoService(console);

		int opcao;
		Aluno aluno = new Aluno();

		final int OPCAO_CADASTRAR_ALUNO = 1;
		final int OPCAO_EXIBIR_BOLETIM = 2;
		final int OPCAO_EXIBIR_APROVACAO = 3;
		final int OPCAO_SAIR = 0;

		do {
			console.write("======================");
			console.write("menu");
			console.write("======================");
			console.write("1 - Cadastrar aluno");
			console.write("2 - Exibir boletim");
			console.write("3 - Exibir aprovacao");
			console.write("======================");
			console.write("0 - Sair");

			opcao = console.readInt("Digite a opcao desejada");

			switch (opcao) {
			case OPCAO_CADASTRAR_ALUNO:
				alunoService.cadastrar(aluno);
				break;

			case OPCAO_EXIBIR_BOLETIM:
				alunoService.exibirBoletim(aluno);

				break;
			case OPCAO_EXIBIR_APROVACAO:
				alunoService.exibirAprovacao(aluno);
				break;
			case OPCAO_SAIR:
				console.write("xau");

				break;
			default:
				console.write("Opcao invalida");

				break;
			}

			console.pause("Pressione qualquer tecla para continuar... #fashion");

		} while (opcao != OPCAO_SAIR);

		console.close();
	}
}
