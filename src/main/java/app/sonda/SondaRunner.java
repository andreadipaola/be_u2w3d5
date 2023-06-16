package app.sonda;

import java.util.Random;
import java.util.UUID;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import app.centrodicontrollo.CentroControllo;
import app.utils.ANSI;

@Component
public class SondaRunner implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {

		Random random = new Random();
		SondaProxy sondaProxy = new SondaProxy("http://host/alarm");
		CentroControllo centroControllo = new CentroControllo(sondaProxy);

		Sonda sonda1 = SondaFactory.createSonda(UUID.randomUUID(), random.nextLong(), random.nextLong(), sondaProxy);
		Sonda sonda2 = SondaFactory.createSonda(UUID.randomUUID(), random.nextLong(), random.nextLong(), sondaProxy);
		Sonda sonda3 = SondaFactory.createSonda(UUID.randomUUID(), random.nextLong(), random.nextLong(), sondaProxy);

		sonda1.aggiungiObserver(centroControllo);
		sonda2.aggiungiObserver(centroControllo);
		sonda3.aggiungiObserver(centroControllo);

		System.out.println();
		System.out.println(ANSI.BG_RED + " ALLARMI IN CORSO " + ANSI.RESET);
//		System.out.println(ANSI.TEXT_BLACK + ANSI.BG_RED + " ALLARMI IN CORSO " + ANSI.RESET);
		sonda1.setLivelloFumo(3);
		sonda2.setLivelloFumo(6);
		sonda3.setLivelloFumo(7);

		sonda3.rimuoviObserver(centroControllo);
		System.out.println();
		System.out.println(ANSI.BG_RED + " ALLARMI IN CORSO DOPO LA RIMOZIONE DI UN OBSERVER " + ANSI.RESET);

		sonda1.setLivelloFumo(3);
		sonda2.setLivelloFumo(6);
		sonda3.setLivelloFumo(7);

	}
}
