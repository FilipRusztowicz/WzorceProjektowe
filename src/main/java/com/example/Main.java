package com.example;

import Gra.*;

public class Main {
    public static void main(String[] args) {


        Kaczka dzika = new DzikaKaczka();
        Kaczka gumowa = new GumowaKaczka();
        Kaczka wabik = new WabikKaczka();

        System.out.println("--- DZIKA KACZKA ---");
        dzika.wyswielt();
        dzika.plywaj();
        dzika.wykonajKwacz();
        dzika.wykonajLec();

        System.out.println("\n--- GUMOWA KACZKA ---");
        gumowa.wyswielt();
        gumowa.plywaj();
        gumowa.wykonajKwacz();
        gumowa.wykonajLec();

        System.out.println("\n--- WABIK KACZKA ---");
        wabik.wyswielt();
        wabik.plywaj();
        wabik.wykonajKwacz();
        wabik.wykonajLec();


        System.out.println("\n--- ZMIANA ZACHOWANIA ---");
        System.out.println("Gumowa kaczka zostaje ulepszona i teraz potrafi latać!");


        gumowa.ustawLatanieInterfejs(new LatamBoMamSkrzydla());


        gumowa.wykonajLec();


    }
}