package subsistema1.crm;

import one.digitalinnovation.gof.facade.Cliente;

public class CrmService {

	private CrmService() {
		super();
	}
	
	public static void gravarCliente(String nome, String cep, String cidade, String estado) {
		System.out.println("Cliente salvo no sistema de CRM:");
		System.out.println(nome);
		System.out.println(cep);
		System.out.println(cidade);
		System.out.println(estado);
	}

	public static void gravarCliente(Cliente cliente) {
		if (cliente == null) {
			throw new IllegalArgumentException("Cliente não pode ser null");
		}
		System.out.println("Cliente salvo no sistema de CRM (via DTO):");
		System.out.println(cliente.getNome());
		System.out.println(cliente.getCep());
		System.out.println(cliente.getCidade());
		System.out.println(cliente.getEstado());
	}
}


