package app.sonda;

import java.util.UUID;

public class SondaFactory {
	public static Sonda createSonda(UUID idSonda, double latitudine, double longitudine, SondaProxy sondaProxy) {
		return new Sonda(idSonda, latitudine, longitudine, sondaProxy);
	}
}
