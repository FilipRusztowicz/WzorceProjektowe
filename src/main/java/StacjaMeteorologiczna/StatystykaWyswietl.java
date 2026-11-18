package StacjaMeteorologiczna;

public class StatystykaWyswietl implements Obserwator, WyswietlElement {
    private float maxTemp = Float.NEGATIVE_INFINITY;
    private float minTemp = Float.POSITIVE_INFINITY;
    private float sumaTemp = 0.0f;
    private int liczbaOdczytow = 0;
    private Podmiot danePogodowe;

    public StatystykaWyswietl(Podmiot danePogodowe) {
        this.danePogodowe = danePogodowe;
        danePogodowe.zarejestrujObserwatora(this);
    }

    @Override
    public void aktualizacja(float temp, float wilg, float cisnienie) {
        sumaTemp += temp;
        liczbaOdczytow++;

        if (temp > maxTemp) {
            maxTemp = temp;
        }
        if (temp < minTemp) {
            minTemp = temp;
        }

        wyswietl();
    }

    @Override
    public void wyswietl() {
        System.out.printf("Statystyka temperatury (Śr/Max/Min): %.1f / %.1f / %.1f%n",
                (sumaTemp / liczbaOdczytow), maxTemp, minTemp);
    }
}
