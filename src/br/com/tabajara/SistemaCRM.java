package br.com.tabajara;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

import br.com.tabajara.crm.ClienteService;
import br.com.tabajara.ui.GUI;

public class SistemaCRM {

	private static final int OPCAO_CADASTRAR_CLIENTE = 1;
	private static final int OPCAO_EXIBIR_STATUS_DE_TODOS_CLIENTES = 2;
	private static final int OPCAO_EXIBIR_STATUS_CLIENTE_POR_CPF = 3;
	private static final int OPCAO_SAIR = 0;

	
	public static void main(String[] args) {
		
		GUI gui = new GUI();

		
		Locale locale = new Locale("en", "US");
		ResourceBundle bundle = ResourceBundle.getBundle(
				"br.com.tabajara.crm.messages", locale);
		String message = bundle.getString("mensagemInicial");
		gui.write(MessageFormat.format(message, "Mula"));

		ClienteService service = new ClienteService(gui);
		int opcao;

		do {
			
			opcao = gui.readInt(OPCAO_CADASTRAR_CLIENTE
					+ " - Cadastrar cliente",
					OPCAO_EXIBIR_STATUS_DE_TODOS_CLIENTES
							+ " - Exibir status (todos)",
					OPCAO_EXIBIR_STATUS_CLIENTE_POR_CPF
							+ " - Exibir status por cpf", OPCAO_SAIR
							+ " - Sair", "Digite a opcao");

			if (opcao == OPCAO_CADASTRAR_CLIENTE) {
				service.cadastrar();
			} else if (opcao == OPCAO_EXIBIR_STATUS_DE_TODOS_CLIENTES) {
				service.exibirStatusDeTodosClientes();
			} else if (opcao == OPCAO_EXIBIR_STATUS_CLIENTE_POR_CPF) {
				service.exibirStatusDoClientePorCPF();
			}

		} while (opcao != OPCAO_SAIR);

	}
}
