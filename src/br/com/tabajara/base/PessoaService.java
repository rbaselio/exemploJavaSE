package br.com.tabajara.base;

import br.com.tabajara.ui.UI;

/**
 * @deprecated Utilize a classe CadastroPessoa via composição.
 */
@Deprecated
public abstract class PessoaService<TipoEspecifico extends Pessoa> {

	private UI ui;

	public PessoaService(UI console) {
		this.ui = console;
	}

	public final void cadastrar(TipoEspecifico pessoa) {
		CadastroDePessoa cadastroDePessoa = new CadastroDePessoa(pessoa);
		cadastroDePessoa.executar(getUI());
		this.cadastrarDadosEspecificos(pessoa);
	}

	protected abstract void cadastrarDadosEspecificos(TipoEspecifico pessoa);

	protected final UI getUI() {
		return ui;
	}

}
