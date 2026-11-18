package StacjaMeteorologiczna;

public class NowyTrybWyswietl implements Obserwator, WyswietlElement {
    private double indeksCiepla;
    private Podmiot danePogodowe;

    public NowyTrybWyswietl(Podmiot danePogodowe) {
        this.danePogodowe = danePogodowe;
        danePogodowe.zarejestrujObserwatora(this);
    }

    @Override
    public void aktualizacja(float temp, float wilg, float cisnienie) {
        indeksCiepla = obliczIndeksCiepla(temp, wilg);
        wyswietl();
    }

    private double obliczIndeksCiepla(float t, float rh) {
        return t + 0.33 * (rh / 100.0 * 6.105 * Math.exp((17.27 * t) / (237.7 + t))) - 4.0;
    }

    @Override
    public void wyswietl() {
        System.out.printf("Nowy tryb (Temperatura odczuwalna): %.2f stopni C%n", indeksCiepla);
    }
}
