package app.sonda;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import app.centrodicontrollo.ObserverInterface;
import app.centrodicontrollo.SubjectInterface;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Sonda implements SubjectInterface {
	private UUID idSonda;
	private double latitudine;
	private double longitudine;
	private int livelloFumo;
	private SondaProxyInterface sondaProxy;
	private List<ObserverInterface> observers = new ArrayList<>();

	public Sonda(UUID idSonda, double latitudine, double longitudine, SondaProxyInterface sondaProxy) {
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
			notificaObservers();
		}
	}

	@Override
	public void aggiungiObserver(ObserverInterface observer) {
		observers.add(observer);
	}

	@Override
	public void rimuoviObserver(ObserverInterface observer) {
		observers.remove(observer);
	}

	@Override
	public void notificaObservers() {
		for (ObserverInterface observer : observers) {
			observer.aggiorna(this);
		}
	}
}