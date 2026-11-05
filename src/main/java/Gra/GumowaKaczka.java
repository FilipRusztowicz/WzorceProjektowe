package Gra;

public class GumowaKaczka extends Kaczka{
    @Override
    public void wyswielt() {
        System.out.println("jestem gumowa kaczka");
    }
    public GumowaKaczka(){
        kwakanieInterfejs = new Piszcz();
        latanieInterfejs = new NieLatam();
    }
}
