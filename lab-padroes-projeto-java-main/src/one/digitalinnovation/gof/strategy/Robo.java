package one.digitalinnovation.gof.strategy;

public class Robo {
	
	private Comportamento comportamento;

	public void setComportamento(Comportamento comportamento) {
		this.comportamento = comportamento;
	}
	
	public void mover() {
		if (comportamento == null) {
			throw new IllegalStateException("Comportamento não configurado");
		}
		comportamento.mover();
	}

	public enum Direcao {
		NORTE, LESTE, SUL, OESTE;
	}

	private int x;
	private int y;
	private Direcao direcao = Direcao.NORTE;

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public Direcao getDirecao() {
		return direcao;
	}

	public void comando(String comando) {
		if (comando == null) {
			return;
		}

		switch (comando.trim().toLowerCase()) {
			case "w":
				avancar();
				break;
			case "s":
				voltar();
				break;
			case "a":
				virarEsquerda();
				break;
			case "d":
				virarDireita();
				break;
			case "frente":
				avancar();
				break;
			case "trás":
			case "tras":
				voltar();
				break;
			case "esquerda":
				virarEsquerda();
				break;
			case "direita":
				virarDireita();
				break;
			case "parar":
				// não faz nada além do print de comportamento
				mover();
				break;
			default:
				System.out.println("Comando inválido: " + comando);
			}
	}

	private void avancar() {
		switch (direcao) {
			case NORTE:
				y++;
				break;
			case SUL:
				y--;
				break;
			case LESTE:
				x++;
				break;
			case OESTE:
				x--;
				break;
		}
		mover();
	}

	private void voltar() {
		switch (direcao) {
			case NORTE:
				y--;
				break;
			case SUL:
				y++;
				break;
			case LESTE:
				x--;
				break;
			case OESTE:
				x++;
				break;
		}
		mover();
	}

	private void virarEsquerda() {
		switch (direcao) {
			case NORTE:
				direcao = Direcao.OESTE;
				break;
			case OESTE:
				direcao = Direcao.SUL;
				break;
			case SUL:
				direcao = Direcao.LESTE;
				break;
			case LESTE:
				direcao = Direcao.NORTE;
				break;
		}
		mover();
	}

	private void virarDireita() {
		switch (direcao) {
			case NORTE:
				direcao = Direcao.LESTE;
				break;
			case LESTE:
				direcao = Direcao.SUL;
				break;
			case SUL:
				direcao = Direcao.OESTE;
				break;
			case OESTE:
				direcao = Direcao.NORTE;
				break;
		}
		mover();
	}
}

