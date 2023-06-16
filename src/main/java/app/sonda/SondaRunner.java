package app.sonda;

import java.util.Random;
import java.util.UUID;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class SondaRunner implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {

		Random random = new Random();

		Sonda sonda1 = SondaFactory.createSonda(UUID.randomUUID(), random.nextLong(), random.nextLong());
		Sonda sonda2 = SondaFactory.createSonda(UUID.randomUUID(), random.nextLong(), random.nextLong());
		Sonda sonda3 = SondaFactory.createSonda(UUID.randomUUID(), random.nextLong(), random.nextLong());
	}
}
