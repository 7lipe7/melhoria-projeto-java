package one.digitalinnovation.gof.facade;

import subsistema1.crm.CrmService;
import subsistema2.cep.CepApi;

public class Facade {

	public void migrarCliente(String nome, String cep) {
		if (nome == null || nome.trim().isEmpty()) {
			throw new IllegalArgumentException("Nome do cliente não pode ser vazio");
		}
		if (cep == null || cep.trim().isEmpty()) {
			throw new InvalidCepException("CEP não pode ser vazio");
		}

		String cepNormalizado = normalizarCep(cep);
		String cidade = CepApi.getInstancia().recuperarCidade(cepNormalizado);
		String estado = CepApi.getInstancia().recuperarEstado(cepNormalizado);

		Cliente cliente = new Cliente(nome.trim(), cepNormalizado, cidade, estado);
		CrmService.gravarCliente(cliente);
	}

	private String normalizarCep(String cep) {
		String somenteDigitos = cep.replaceAll("\\D", "");
		if (somenteDigitos.length() != 8) {
			throw new InvalidCepException("CEP inválido. Esperado 8 dígitos, recebido: " + cep);
		}
		return somenteDigitos;
	}
}

