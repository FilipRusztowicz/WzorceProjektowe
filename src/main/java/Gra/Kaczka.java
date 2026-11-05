package Gra;

public abstract class Kaczka {
    LatanieInterfejs latanieInterfejs;
    KwakanieInterfejs kwakanieInterfejs;
    public void plywaj(){
        System.out.println("bulbulbul");
    }
    public abstract void wyswielt();
    public void wykonajKwacz(){
        kwakanieInterfejs.kwacz();
    }
    public void wykonajLec(){
        latanieInterfejs.lec();
    }
    public void ustawLatanieInterfejs(LatanieInterfejs latanie){
        latanieInterfejs=latanie;
    }
    void ustawKwakanieInterfejs(KwakanieInterfejs kwakanie){
        kwakanieInterfejs=kwakanie;
    }



}
