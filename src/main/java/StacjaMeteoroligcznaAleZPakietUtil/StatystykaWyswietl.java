package StacjaMeteoroligcznaAleZPakietUtil;

import java.util.Observable;
import java.util.Observer;

@SuppressWarnings("deprecation")
public class StatystykaWyswietl implements Observer, WyswietlElement {
    private Observable observable;
    private float maxTemp = Float.NEGATIVE_INFINITY;
    private float minTemp = Float.POSITIVE_INFINITY;
    private float sumaTemp = 0.0f;
    private int liczbaOdczytow = 0;

    public StatystykaWyswietl(Observable observable) {
        this.observable = observable;
        observable.addObserver(this);
    }

    @Override
    public void update(Observable obs, Object arg) {
        if (obs instanceof DanePogodowe) {
            DanePogodowe danePogodowe = (DanePogodowe) obs;
            float temp = danePogodowe.getTemperatura();

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
    }

    @Override
    public void wyswietl() {
        System.out.printf("Statystyka temperatury (Śr/Max/Min): %.1f / %.1f / %.1f%n",
                (sumaTemp / liczbaOdczytow), maxTemp, minTemp);
    }
}
