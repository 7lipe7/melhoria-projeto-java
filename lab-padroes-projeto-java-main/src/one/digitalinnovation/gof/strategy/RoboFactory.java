package one.digitalinnovation.gof.strategy;

public class RoboFactory {

	public static Robo criarRobo(String tipo) {
		if (tipo == null) {
			throw new IllegalArgumentException("Tipo de comportamento não pode ser null");
		}

		Comportamento comportamento;
		switch (tipo.trim().toLowerCase()) {
			case "defensivo":
				comportamento = new ComportamentoDefensivo();
				break;
			case "agressivo":
				comportamento = new ComportamentoAgressivo();
				break;
			case "normal":
				comportamento = new ComportamentoNormal();
				break;
			default:
				throw new IllegalArgumentException(
						"Tipo de comportamento desconhecido: " + tipo + " (use: normal, defensivo, agressivo)"
				);
		}

		Robo robo = new Robo();
		robo.setComportamento(comportamento);
		return robo;
	}
}

