package SklepZKoszulkami;

public class SklepAdiadas {
    public static void main(String[] args) {
        Koszulka koszulka1 = new Polo();
        System.out.println(koszulka1.getOpis() + " | Cena: " + koszulka1.cena() + " zł");

        Koszulka koszulka2 = new Sportowa();
        koszulka2 = new KolorCzerwony(koszulka2);
        koszulka2 = new NumerNaPlecach(koszulka2);
        koszulka2 = new Bawelna(koszulka2);
        System.out.println(koszulka2.getOpis() + " | Cena: " + koszulka2.cena() + " zł");

        Koszulka koszulka3 = new Bawelna(new Bawelna(new Galowa()));
        System.out.println(koszulka3.getOpis() + " | Cena: " + koszulka3.cena() + " zł");
    }
}
