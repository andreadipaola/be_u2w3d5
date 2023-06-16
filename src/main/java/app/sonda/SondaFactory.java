package app.sonda;

import java.util.UUID;

public class SondaFactory {
	public static Sonda createSonda(UUID id, double latitudine, double longitudine) {
		return new Sonda(id, latitudine, longitudine);
	}
}
