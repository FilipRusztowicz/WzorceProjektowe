package StacjaMeteorologiczna;

public class PrognozaWyswietl implements Obserwator, WyswietlElement {
    private float aktualneCisnienie = 1013.25f;
    private float ostatnieCisnienie;
    private Podmiot danePogodowe;

    public PrognozaWyswietl(Podmiot danePogodowe) {
        this.danePogodowe = danePogodowe;
        danePogodowe.zarejestrujObserwatora(this);
    }

    @Override
    public void aktualizacja(float temp, float wilg, float cisnienie) {
        ostatnieCisnienie = aktualneCisnienie;
        aktualneCisnienie = cisnienie;
        wyswietl();
    }

    @Override
    public void wyswietl() {
        System.out.print("Prognoza: ");
        if (aktualneCisnienie > ostatnieCisnienie) {
            System.out.println("Nadchodzi poprawa pogody!");
        } else if (aktualneCisnienie == ostatnieCisnienie) {
            System.out.println("Pogoda bez większych zmian.");
        } else {
            System.out.println("Uwaga na ochłodzenie i możliwe opady.");
        }
    }
}
