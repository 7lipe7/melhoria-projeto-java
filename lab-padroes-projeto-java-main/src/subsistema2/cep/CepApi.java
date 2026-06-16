package subsistema2.cep;

public class CepApi {

	private static CepApi instancia = new CepApi();

	private CepApi() {
		super();
	}

	public static CepApi getInstancia() {
		return instancia;
	}

	public String recuperarCidade(String cep) {
		if (!isCepValido(cep)) {
			return "Cidade não encontrada";
		}

		// Simulação (mapa fixo) para demonstrar fluxo no Facade
		if (cep.equals("14801788")) {
			return "araras";
		}
		if (cep.equals("30140071")) {
			return "Belo Horizonte";
		}
		return "Cidade não encontrada";
	}

	public String recuperarEstado(String cep) {
		if (!isCepValido(cep)) {
			return "UF não encontrada";
		}

		if (cep.equals("14801788")) {
			return "SP";
		}
		if (cep.equals("30140071")) {
			return "MG";
		}
		return "UF não encontrada";
	}

	private boolean isCepValido(String cep) {
		if (cep == null) {
			return false;
		}
		String somenteDigitos = cep.replaceAll("\\D", "");
		return somenteDigitos.length() == 8;
	}
}

