package Gra;

public class WabikKaczka extends Kaczka{
    @Override
    public void wyswielt() {
        System.out.println("jestem wabikiem kaczka");
    }
    public WabikKaczka(){
        kwakanieInterfejs = new Piszcz();
        latanieInterfejs = new NieLatam();
    }
}
