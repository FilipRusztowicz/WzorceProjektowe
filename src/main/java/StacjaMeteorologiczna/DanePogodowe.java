package StacjaMeteorologiczna;

import java.util.ArrayList;
import java.util.List;

public class DanePogodowe implements Podmiot {
    private List<Obserwator> obserwatorzy;
    private float temp;
    private float wilg;
    private float cisnienie;

    public DanePogodowe() {
        obserwatorzy = new ArrayList<>();
    }

    @Override
    public void zarejestrujObserwatora(Obserwator o) {
        obserwatorzy.add(o);
    }

    @Override
    public void usunObserwatora(Obserwator o) {
        obserwatorzy.remove(o);
    }

    @Override
    public void powiadomObserwatorow() {
        for (Obserwator obserwator : obserwatorzy) {
            obserwator.aktualizacja(temp, wilg, cisnienie);
        }
    }

    public void odczytyZmiana() {
        powiadomObserwatorow();
    }

    public void ustawOdczyty(float temp, float wilg, float cisnienie) {
        this.temp = temp;
        this.wilg = wilg;
        this.cisnienie = cisnienie;
        odczytyZmiana();
    }
}
