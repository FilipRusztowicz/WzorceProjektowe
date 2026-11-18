package StacjaMeteoroligcznaAleZPakietUtil;

import java.util.Observable;
import java.util.Observer;

@SuppressWarnings("deprecation")
public class WarunkiBierzaceWyswietl implements Observer, WyswietlElement {
    private Observable observable;
    private float temperatura;
    private float wilgotnosc;

    public WarunkiBierzaceWyswietl(Observable observable) {
        this.observable = observable;
        observable.addObserver(this);
    }

    @Override
    public void update(Observable obs, Object arg) {
        if (obs instanceof DanePogodowe) {
            DanePogodowe danePogodowe = (DanePogodowe) obs;
            this.temperatura = danePogodowe.getTemperatura();
            this.wilgotnosc = danePogodowe.getWilgotnosc();
            wyswietl();
        }
    }

    @Override
    public void wyswietl() {
        System.out.println("Warunki bieżące: " + temperatura + " stopni C oraz " + wilgotnosc + "% wilgotności");
    }
}
