package StacjaMeteorologiczna;

public class StacjaMeteo {
    public static void main(String[] args) {
        DanePogodowe danePogodowe = new DanePogodowe();

        WarunkiBierzaceWyswietl warunkiBiezace = new WarunkiBierzaceWyswietl(danePogodowe);
        StatystykaWyswietl statystyka = new StatystykaWyswietl(danePogodowe);
        PrognozaWyswietl prognoza = new PrognozaWyswietl(danePogodowe);
        NowyTrybWyswietl nowyTryb = new NowyTrybWyswietl(danePogodowe);

        System.out.println("--- Pomiar 1 ---");
        danePogodowe.ustawOdczyty(26.6f, 65.0f, 1013.1f);

        System.out.println("\n--- Pomiar 2 ---");
        danePogodowe.ustawOdczyty(27.7f, 70.0f, 997.0f);

        System.out.println("\n--- Usunięcie obserwatora PrognozaWyswietl i Pomiar 3 ---");
        danePogodowe.usunObserwatora(prognoza);
        danePogodowe.ustawOdczyty(25.5f, 90.0f, 997.0f);
    }
}
