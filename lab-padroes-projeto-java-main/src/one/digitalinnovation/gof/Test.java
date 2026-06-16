package one.digitalinnovation.gof;

import one.digitalinnovation.gof.facade.Facade;
import one.digitalinnovation.gof.singleton.SingletonEager;
import one.digitalinnovation.gof.singleton.SingletonLazy;
import one.digitalinnovation.gof.singleton.SingletonLazyHolder;
import one.digitalinnovation.gof.strategy.Robo;
import one.digitalinnovation.gof.strategy.RoboFactory;

public class Test {

	public static void main(String[] args) {
		// Singleton
		SingletonLazy lazy = SingletonLazy.getInstancia();
		System.out.println(lazy);
		lazy = SingletonLazy.getInstancia();
		System.out.println(lazy);

		SingletonEager eager = SingletonEager.getInstancia();
		System.out.println(eager);
		eager = SingletonEager.getInstancia();
		System.out.println(eager);

		SingletonLazyHolder lazyHolder = SingletonLazyHolder.getInstancia();
		System.out.println(lazyHolder);
		lazyHolder = SingletonLazyHolder.getInstancia();
		System.out.println(lazyHolder);

		// Strategy
		Robo roboNormal = RoboFactory.criarRobo("normal");
		roboNormal.mover();
		roboNormal.mover();

		Robo roboDefensivo = RoboFactory.criarRobo("defensivo");
		roboDefensivo.mover();

		// Facade
		Facade facade = new Facade();
		facade.migrarCliente("felipe", "14801788");

		try {
			facade.migrarCliente("João", "123");
		} catch (Exception e) {
			System.out.println("Falha no fluxo do Facade: " + e.getMessage());
		}

		
	}

}

