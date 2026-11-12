package FabrykaCzekolady;

public class Main {
    public static void main(String[] args) {
        Kociol kociol1 = Kociol.pobierzUniqKociol();
        Kociol kociol2 = Kociol.pobierzUniqKociol();
        kociol1.ugotuj();
        kociol1.wypelnij();
        kociol2.wypelnij();
        kociol1.wylej();
        kociol1.ugotuj();
        kociol2.wylej();
    }
}




