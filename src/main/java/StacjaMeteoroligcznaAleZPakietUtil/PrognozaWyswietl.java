package StacjaMeteoroligcznaAleZPakietUtil;

import java.util.Observable;
import java.util.Observer;

@SuppressWarnings("deprecation")
public class PrognozaWyswietl implements Observer, WyswietlElement {
    private Observable observable;
    private float aktualneCisnienie = 1013.25f;
    private float ostatnieCisnienie;

    public PrognozaWyswietl(Observable observable) {
        this.observable = observable;
        observable.addObserver(this);
    }

    @Override
    public void update(Observable obs, Object arg) {
        if (obs instanceof DanePogodowe) {
            DanePogodowe danePogodowe = (DanePogodowe) obs;
            ostatnieCisnienie = aktualneCisnienie;
            aktualneCisnienie = danePogodowe.getCisnienie();
            wyswietl();
        }
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
