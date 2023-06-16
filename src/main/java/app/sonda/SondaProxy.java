package app.sonda;

import java.util.UUID;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SondaProxy implements SondaProxyInterface {
	private String baseUrl;

	@Override
	public void allerta(UUID idSonda, double latitudine, double longitudine, int livelloFumo) {
		String url = String.format("%s?idsonda=%s&lat=%f&lon=%f&smokelevel=%d", baseUrl, idSonda.toString(), latitudine,
				longitudine, livelloFumo);
		System.out.println(url);
	}
}
