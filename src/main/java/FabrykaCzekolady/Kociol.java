package FabrykaCzekolady;

public class Kociol{
    private boolean pusty;
    private boolean ugotowany;

    private static Kociol uniqKociol;

   private Kociol() {pusty= true; ugotowany= false; }

    public static Kociol pobierzUniqKociol(){
       if(uniqKociol==null){
           uniqKociol=new Kociol();
       }
       return uniqKociol;
    }

    public void wypelnij() {
        if (jestPusty()) {
            pusty= false;
            ugotowany= false;
//napełnić kocioł mieszanką mleczno-czekoladową
            System.out.println("wypełniamy kocioł");
        }else{
            System.out.println("Kociol juz pelny!");}
    }

    public void wylej() {
        if (!jestPusty() && jestUgotowany()) {
//wylej ugotowane mleko i czekoladę
            pusty = true;
            System.out.println("opróżniamy kocioł");
        }
    else if(jestPusty()){
            System.out.println("Kociol pusty");
    }else{
            System.out.println("Kociol jeszce nie ugotowany!");
        }
    }

    public void ugotuj() {
        if (!jestPusty() && !jestUgotowany()) {
//doprowadzić zawartość do wrzenia
            ugotowany= true;
            System.out.println("gotujemy zawartość kotła"); }
   else if(jestPusty()){
            System.out.println("nie ma co gotowac!");
        }else{
            System.out.println("juz ugotowany");
        }
   }

    public boolean jestPusty() { return pusty; }
    public boolean jestUgotowany() { return ugotowany; }

}