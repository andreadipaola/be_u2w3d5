package app.centrodicontrollo;


public interface SubjectInterface {
    public void aggiungiObserver(ObserverInterface observer);
    public void rimuoviObserver(ObserverInterface observer);
    public void notificaObservers();
}
