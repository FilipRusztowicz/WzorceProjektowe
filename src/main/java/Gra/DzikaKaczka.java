package Gra;

public class DzikaKaczka extends Kaczka {
    @Override
    public void wyswielt() {
        System.out.println("jestem dzika kaczka");

    }
    public DzikaKaczka(){
        kwakanieInterfejs = new Kwacz();
        latanieInterfejs = new LatamBoMamSkrzydla();
    }
}
