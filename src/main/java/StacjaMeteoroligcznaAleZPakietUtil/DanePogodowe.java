package StacjaMeteoroligcznaAleZPakietUtil;

import java.util.Observable;

@SuppressWarnings("deprecation")
public class DanePogodowe extends Observable {
    private float temperatura;
    private float wilgotnosc;
    private float cisnienie;

    public DanePogodowe() {
    }

    public void odczytyZmiana() {
        setChanged();
        notifyObservers();
    }

    public void ustawOdczyty(float temperatura, float wilgotnosc, float cisnienie) {
        this.temperatura = temperatura;
        this.wilgotnosc = wilgotnosc;
        this.cisnienie = cisnienie;
        odczytyZmiana();
    }

    public float getTemperatura() {
        return temperatura;
    }

    public float getWilgotnosc() {
        return wilgotnosc;
    }

    public float getCisnienie() {
        return cisnienie;
    }
}
