package br.com.tabajara.base;

import br.com.tabajara.ui.UI;

public final class CadastroDePessoa {

	private Pessoa pessoa;

	public CadastroDePessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public void executar(UI ui) {
		pessoa.setNome(ui.readString("Digite o nome"));
		pessoa.setDataNascimento(ui.readDate("Digite a data de nascimento"));
	}

}
