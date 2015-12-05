package br.com.tabajara.crm;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import br.com.tabajara.MailSender;
import br.com.tabajara.base.CPF;
import br.com.tabajara.base.CPFInvalidoException;
import br.com.tabajara.base.CadastroDePessoa;

import br.com.tabajara.ui.GUI;

public class ClienteService {

	private GUI ui;
	private ClienteRepository clienteRepository;
	private MailSender mailSender = new MailSender();
	private Collection<ClienteService.Listener> listeners = new ArrayList<>();

	public ClienteService(GUI gui) {
		this.ui = gui;
		this.clienteRepository = new ClienteRepository();
	}

	

	private GUI getUI() {
		return ui;
	}

	public void cadastrar() {
		Cliente cliente = new Cliente();

		CadastroDePessoa cadastroDePessoa = new CadastroDePessoa(cliente);
		cadastroDePessoa.executar(getUI());

		CPF cpf = readCpf();
		cliente.setCpf(cpf);

		this.clienteRepository.adicionar(cliente);
		notificarClienteCadastrado(cliente);
	}

	private void notificarClienteCadastrado(Cliente cliente) {
		for (Listener listener : listeners) {
			listener.clienteCadastrado(cliente);
		}
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

				
			}
			
		} while (cpfInvalido);
		return cpf;
	}

	public void exibirStatusDeTodosClientes() {
		

		StringBuilder stringBuilder = new StringBuilder();
		for (Cliente cliente : this.clienteRepository.listarTodos()) {
			stringBuilder.append(cliente);
			stringBuilder.append("\n");
			this.mailSender.send(cliente.getNome());
		}
		getUI().write(stringBuilder.toString());
	}

	public void exibirStatusDoClientePorCPF() {
		
		CPF cpf = readCpf();

		Cliente cliente = this.clienteRepository.clientePorCpf(cpf);
		if (cliente != null) {
			getUI().write(cliente.getNome() + " " + cliente.getStatus());
		} else {
			getUI().write("Cliente nao encontrado");
		}
	}


	public void registrarListener(ClienteService.Listener listener) {
		this.listeners.add(listener);
	}

	public static interface Listener {
		void clienteCadastrado(Cliente cliente);
	}

}