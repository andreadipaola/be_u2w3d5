package app.sonda;

import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Sonda {
	private UUID id;
	private double latitudine;
	private double longitudine;
	private int livelloFumo;

	public Sonda(UUID id, double latitudine, double longitudine) {
		this.id = id;
		this.latitudine = latitudine;
		this.longitudine = longitudine;
		this.livelloFumo = 0;
	}

	public void setLivelloFumo(Integer livelloFumo) {
		this.livelloFumo = livelloFumo;
		if (livelloFumo > 5) {
			System.out.println("Attenzione incendio in corso!");
		}
	}
}