package app.sonda;

import java.util.UUID;

public interface SondaProxyInterface {
	void allerta(UUID idSonda, double latitudine, double longitudine, int livelloFumo);
}
