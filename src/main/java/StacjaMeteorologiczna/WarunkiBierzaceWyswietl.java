package StacjaMeteorologiczna;

public class WarunkiBierzaceWyswietl implements Obserwator, WyswietlElement {
    private float temp;
    private float wilg;
    private Podmiot danePogodowe;

    public WarunkiBierzaceWyswietl(Podmiot danePogodowe) {
        this.danePogodowe = danePogodowe;
        danePogodowe.zarejestrujObserwatora(this);
    }

    @Override
    public void aktualizacja(float temp, float wilg, float cisnienie) {
        this.temp = temp;
        this.wilg = wilg;
        wyswietl();
    }

    @Override
    public void wyswietl() {
        System.out.println("Warunki bieżące: " + temp + " stopni C oraz " + wilg + "% wilgotności");
    }
}
