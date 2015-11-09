package br.com.tabajara.crm;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import br.com.tabajara.base.CPF;

class ClienteRepository {

	private Set<Cliente> clientes = new HashSet<>();
	private Map<CPF, Cliente> clientesPorCpf = new HashMap<>();

	void adicionar(Cliente cliente) {
		if (this.clientes.add(cliente)) {
			this.clientesPorCpf.put(cliente.getCpf(), cliente);
		}
	}

	// Ordenacao default
	Collection<Cliente> listarTodos() {
		List<Cliente> clientesOrdenados = new ArrayList<>(this.clientes);
		Collections.sort(clientesOrdenados);

		return clientesOrdenados;
	}

	// Ordenacao por classe anonima
	Collection<Cliente> listarTodosOrdenadosPorIdade() {
		List<Cliente> clientesOrdenados = new ArrayList<>(this.clientes);
		Collections.sort(clientesOrdenados, new Comparator<Cliente>() {

			@Override
			public int compare(Cliente cliente1, Cliente cliente2) {
				return Integer.compare(cliente1.getIdade(), cliente2.getIdade());
			}
		});

		return clientesOrdenados;
	}

	// Ordenacao por classe interna (inner class)
	Collection<Cliente> listarTodosOrdenadosPorCpf() {
		List<Cliente> clientesOrdenados = new ArrayList<>(this.clientes);
		Collections.sort(clientesOrdenados, new OrdenarPorCPF());

		return clientesOrdenados;
	}

	Cliente clientePorCpf(CPF cpf) {
		return this.clientesPorCpf.get(cpf);
	}

	private void iterarMapaZuado() {
		this.clientesPorCpf.keySet();
		this.clientesPorCpf.values();

		for (CPF cpf : clientesPorCpf.keySet()) {
			System.out.println(cpf);
			System.out.println(clientesPorCpf.get(cpf));
		}
	}

	private void iterarMapaJoia() {
		clientesPorCpf.entrySet();
		for (Map.Entry<CPF, Cliente> clientePorCpf : clientesPorCpf.entrySet()) {
			System.out.println(clientePorCpf.getKey());
			System.out.println(clientePorCpf.getValue());
		}

	}

	private class OrdenarPorCPF implements Comparator<Cliente> {

		@Override
		public int compare(Cliente cliente1, Cliente cliente2) {
			return cliente1.getCpf().compareTo(cliente2.getCpf());
		}

	}

}
