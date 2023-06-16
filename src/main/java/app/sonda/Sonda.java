package app.sonda;

import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Sonda {
	private UUID idSonda;
	private double latitudine;
	private double longitudine;
	private int livelloFumo;
	private SondaProxy sondaProxy;

	public Sonda(UUID idSonda, double latitudine, double longitudine, SondaProxy sondaProxy) {
		this.idSonda = idSonda;
		this.latitudine = latitudine;
		this.longitudine = longitudine;
		this.livelloFumo = 0;
		this.sondaProxy = sondaProxy;
	}

	public void setLivelloFumo(int livelloFumo) {
		this.livelloFumo = livelloFumo;
		if (livelloFumo > 5) {
//			System.out.println("Attenzione incendio in corso!");
			sondaProxy.allerta(idSonda, latitudine, longitudine, livelloFumo);
		}
	}
}