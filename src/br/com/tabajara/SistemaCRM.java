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

	// ok cadastrar cliente
	// ok .. nome
	// ok .. idade
	// ok .. status (Ativo ou inativo)
	// ok .. cpf
	// ok exibir o status do cliente

	// ok Cadastrar clientes em uma lista e nao mais em uma variavel só
	// ok Exibir status deve listar todos os clientes
	// exibir o staus de um cliente específico (por cpf)
	public static void main(String[] args) {
		// ArrayList<String> lista = new ArrayList<>(3);
		//
		// lista.add("Meu texto");
		// lista.add("Vai curintia");
		// lista.add("E nois");
		//
		// for (String string : lista) {
		// ..// iteracao
		// }
		// Nao deixa adicionar gui porque nao eh string!
		// lista.add(gui);
		// lista.clear();

		// Map<String, Cliente> mapa = new HashMap<>();
		// mapa.put("123", new Cliente());
		// mapa.get("123");
		//
		// Cliente outro = new Cliente();
		// mapa.put("123", outro);
		//
		// int[] codigos = { 1, 2, 3 };
		//
		// Map<Integer, Cliente> clientesPorCodigo;
		//
		// Integer variavel = new Integer(10);
		// // AutoBoxing
		// variavel = 20;
		// // Fortemente tipado
		// Double x = 20d;
		//
		// // AutoUnBoxing
		// variavel = null;
		// int y = variavel.intValue();

		GUI gui = new GUI();

		// TODO encapsular aspecto de I18N
		Locale locale = new Locale("en", "US");
		ResourceBundle bundle = ResourceBundle.getBundle(
				"br.com.tabajara.crm.messages", locale);
		String message = bundle.getString("mensagemInicial");
		gui.write(MessageFormat.format(message, "Mula"));

		ClienteService service = new ClienteService(gui);
		int opcao;

		do {
			// TODO pensar em um menu dinamico
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
