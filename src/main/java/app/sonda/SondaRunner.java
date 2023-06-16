package app.sonda;

import java.util.Random;
import java.util.UUID;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import app.utils.ANSI;

@Component
public class SondaRunner implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {

		SondaProxy sondaProxy = new SondaProxy("http://host/alarm");
		Random random = new Random();

		Sonda sonda1 = SondaFactory.createSonda(UUID.randomUUID(), random.nextLong(), random.nextLong(), sondaProxy);
		Sonda sonda2 = SondaFactory.createSonda(UUID.randomUUID(), random.nextLong(), random.nextLong(), sondaProxy);
		Sonda sonda3 = SondaFactory.createSonda(UUID.randomUUID(), random.nextLong(), random.nextLong(), sondaProxy);

		System.out.println();
		System.out.println(ANSI.BG_RED + " ALLARMI IN CORSO " + ANSI.RESET);
//		System.out.println(ANSI.TEXT_BLACK + ANSI.BG_RED + " ALLARMI IN CORSO " + ANSI.RESET);
		sonda1.setLivelloFumo(3);
		sonda2.setLivelloFumo(6);
		sonda3.setLivelloFumo(7);
	}
}
