package SklepZKoszulkami;

public abstract class Koszulka {
    protected String opis;

    public String getOpis(){
        return opis;
    };
    abstract double cena();
}

class Polo extends Koszulka{
public Polo(){
    opis = "Polo";
}
    @Override
    double cena() {
        return 22.00;
    }
}

class Sportowa extends Koszulka{
    public Sportowa(){
        opis = "Sportowa";
    }

    @Override
    double cena() {
        return 33.00;
    }
}

class Galowa extends Koszulka{
    public Galowa(){
        opis = "Galowa";
    }

    @Override
    double cena() {
        return 44.00;
    }
}