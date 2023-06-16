
package app.centrodicontrollo;

import app.sonda.Sonda;
import app.sonda.SondaProxyInterface;

public class CentroControllo implements ObserverInterface {
	private SondaProxyInterface sondaProxy;

	public CentroControllo(SondaProxyInterface sondaProxy) {
		this.sondaProxy = sondaProxy;
	}

	@Override
	public void aggiorna(Sonda sonda) {
		sondaProxy.allerta(sonda.getIdSonda(), sonda.getLatitudine(), sonda.getLongitudine(), sonda.getLivelloFumo());
	}
}