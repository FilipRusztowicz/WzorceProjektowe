package SklepZKoszulkami;

public abstract class AtrybutyDekorator extends Koszulka{
    public abstract String getOpis();

    abstract double cena();
}

class KolorCzerwony extends AtrybutyDekorator{
    private Koszulka koszulka;
    public KolorCzerwony(Koszulka koszulka){
        this.koszulka = koszulka;
    }

    @Override
    public String getOpis() {
        return koszulka.getOpis() + " kolor czerwony";
    }

    @Override
    double cena() {
        return koszulka.cena() + 10;
    }
}

class NumerNaPlecach extends AtrybutyDekorator{
    private Koszulka koszulka;
    public NumerNaPlecach(Koszulka koszulka){
        this.koszulka = koszulka;
    }

    @Override
    public String getOpis() {
        return koszulka.getOpis() + " numer na plecach: 20";
    }

    @Override
    double cena() {
        return koszulka.cena() + 20;
    }
}

class Bawelna extends AtrybutyDekorator{
    private Koszulka koszulka;
    public Bawelna(Koszulka koszulka){
        this.koszulka = koszulka;
    }

    @Override
    public String getOpis() {
        return koszulka.getOpis() + " z bawelny";
    }

    @Override
    double cena() {
        return koszulka.cena() + 6;
    }
}

