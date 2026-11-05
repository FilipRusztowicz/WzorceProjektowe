package com.example;

import Gra.*;
import Servlet.*;

public class Main {
    public static void main(String[] args) {

/*
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

*/
        Response response = new Response();

        System.out.println("--- KLASYCZNY MINISERVLET ---");
        PseudoHttpServlet servlet = new MyServlet();
        Request getRequest = new Request("GET", "fetch users");
        Request postRequest = new Request("POST", "new user data");
        Request deleteRequest = new Request("DELETE", "user = 5");

        servlet.service(getRequest, response);
        servlet.service(postRequest, response);
        servlet.service(deleteRequest, response);


        System.out.println("\n--- SERWER NA LAMBDACH ---");
        LambdaHttpServer server = new LambdaHttpServer();

        // Rejestracja strategii (lambdy) w locie
        server.register("GET", (req, res) ->
                res.write("Handling GET for: " + req.getBody())
        );

        server.register("POST", (req, res) ->
                res.write("Handling POST with: " + req.getBody())
        );

        server.register("DELETE", (req, res) ->
                res.write("Deleted resource: " + req.getBody())
        );

        // Dodatkowy przykład dynamicznej zmiany (ze slajdu 54)
        server.register("PATCH", (req, res) ->
                res.write("Patched resource: " + req.getBody())
        );

        // Obsługa żądań
        server.service(new Request("GET", "list users"), response);
        server.service(new Request("POST", "new user data"), response);
        server.service(new Request("PUT", "update user data"), response); // Brak obsługi -> błąd 405
        server.service(new Request("PATCH", "update email"), response);
    }
}