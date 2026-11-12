package SingletonZBaza;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        // Pobieramy połączenie w dwóch różnych miejscach programu
        Connection conn1 = PolaczenieZBaza.pobierzUniqInstancje().pobierzPolaczenie();
        Connection conn2 = PolaczenieZBaza.pobierzUniqInstancje().pobierzPolaczenie();

        // Sprawdzenie, czy to dokładnie ten sam obiekt połączenia
        if (conn1 == conn2) {
            System.out.println("Sukces! Obie zmienne korzystają z tego samego połączenia.");
        }

        // Przykładowe wykonanie prostego zapytania SQL
        if (conn1 != null) {
            try (Statement stmt = conn1.createStatement();
                 ResultSet rs = stmt.executeQuery("SELECT * FROM drinki")) {

                while (rs.next()) {
                    System.out.println("Produkt: " + rs.getString("nazwa") +" cena: "+ rs.getString("cena"));
                }
            } catch (Exception e) {
                System.out.println("Błąd zapytania SQL: " + e.getMessage());
            }
        }
    }
}
