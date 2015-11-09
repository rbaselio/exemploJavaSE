package br.com.tabajara.crm;

import br.com.tabajara.base.CPF;
import br.com.tabajara.base.CPFInvalidoException;
import br.com.tabajara.base.CadastroDePessoa;
import br.com.tabajara.ui.GUI;

public class ClienteService {

	private GUI ui;
	private ClienteRepository clienteRepository = new ClienteRepository();

	public ClienteService(GUI gui) {
		this.ui = gui;
		// this.clientes = new ArrayList<>();
	}

	// @Override
	// public void cadastrar(Pessoa pessoa) {
	// super.cadastrar(pessoa);
	// // Cliente eh necessariamente pessoa
	// // mas pessoa nao eh necessariamente cliente
	// cadastrarCliente(pessoa);
	// }

	// public void cadastrarCliente(Cliente cliente) {
	// super.cadastrar(cliente);
	// // nao da pra acessar o atributo privado
	// // da classe paAhi
	// // this.console = null;
	// }

	private GUI getUI() {
		return ui;
	}

	public void cadastrar() {
		Cliente cliente = new Cliente();

		CadastroDePessoa cadastroDePessoa = new CadastroDePessoa(cliente);
		cadastroDePessoa.executar(getUI());

		CPF cpf = readCpf();
		cliente.setCpf(cpf);

		// cliente.setStatus(getUI().readInt("Digite o status"));
		this.clienteRepository.adicionar(cliente);
	}

	private CPF readCpf() {
		CPF cpf = null;
		boolean cpfInvalido;
		do {
			try {
				cpf = new CPF(getUI().readString("Digite o CPF"));
				cpfInvalido = false;
			} catch (CPFInvalidoException | IllegalArgumentException e) {
				getUI().write(e.getMessage() + ", amigao");
				cpfInvalido = true;

				// Ja era a checked exception
				// throw new RuntimeException(e);
			}
			// catch (IllegalArgumentException e) {
			// getUI().write(e.getMessage() + ", amigao");
			// cpfInvalido = true;
			// }
		} while (cpfInvalido);
		return cpf;
	}

	public void exibirStatusDeTodosClientes() {
		// Relatorio com muita instanciacao de strings
		// String relatorio = "";
		// for (Cliente cliente : this.clienteRepository.listarTodos()) {
		//
		// ..if (cliente.isAtivo()) {
		// ....relatorio += cliente.getNome() + " - Ativo\n";
		// ..} else {
		// ....relatorio += cliente.getNome() + " - Inativo\n";
		// ..}
		// }

		StringBuilder stringBuilder = new StringBuilder();
		for (Cliente cliente : this.clienteRepository.listarTodos()) {
			stringBuilder.append(cliente);
			stringBuilder.append("\n");
		}
		getUI().write(stringBuilder.toString());
	}

	public void exibirStatusDoClientePorCPF() {
		// Implementacao sem mapa
		// Ineficiente porque chama equals a dar com pau
		// String cpf = this.ui.readString("Digite o cpf");
		// for (Cliente cliente : this.clienteRepository.listarTodos()) {
		// ..if (cpf.equals(cliente.getCpf().getNumero())) {
		// ....getUI().write(cliente.getNome() + " " + cliente.getStatus());
		// ....break;
		// ..}
		// }

		CPF cpf = readCpf();

		Cliente cliente = this.clienteRepository.clientePorCpf(cpf);
		if (cliente != null) {
			getUI().write(cliente.getNome() + " " + cliente.getStatus());
		} else {
			getUI().write("Cliente nao encontrado");
		}
	}

	// @Override
	// protected Console getConsole() {
	// // #vidaloka2
	// return null;
	// }

}
