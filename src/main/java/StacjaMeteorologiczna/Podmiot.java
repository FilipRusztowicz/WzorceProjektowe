package StacjaMeteorologiczna;

public interface Podmiot {
    void zarejestrujObserwatora(Obserwator o);
    void usunObserwatora(Obserwator o);
    void powiadomObserwatorow();
}
