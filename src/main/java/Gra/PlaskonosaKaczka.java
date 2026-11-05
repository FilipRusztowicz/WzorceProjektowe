package Gra;

public class PlaskonosaKaczka extends Kaczka
{
    @Override
    public void wyswielt() {
        System.out.println("jestem plaskonosa kaczka");
    }
    public PlaskonosaKaczka(){
        kwakanieInterfejs = new Kwacz();
        latanieInterfejs = new LatamBoMamSkrzydla();
    }
}
