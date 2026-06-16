package one.digitalinnovation.gof.facade;

public class Cliente {

	private final String nome;
	private final String cep;
	private final String cidade;
	private final String estado;

	public Cliente(String nome, String cep, String cidade, String estado) {
		this.nome = nome;
		this.cep = cep;
		this.cidade = cidade;
		this.estado = estado;
	}

	public String getNome() {
		return nome;
	}

	public String getCep() {
		return cep;
	}

	public String getCidade() {
		return cidade;
	}

	public String getEstado() {
		return estado;
	}
}

