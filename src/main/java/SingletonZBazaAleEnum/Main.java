package SingletonZBazaAleEnum;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        Connection conn1 = PolaczenieZBaza.INSTANCJA.pobierzPolaczenie();
        Connection conn2 = PolaczenieZBaza.INSTANCJA.pobierzPolaczenie();
        try (Statement stmt = conn1.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM drinki")) {
            while (rs.next()) {
                System.out.println("Produkt: " + rs.getString("nazwa") +" cena: "+ rs.getString("cena"));
            }
        } catch (Exception e) {
            System.out.println("Błąd podczas wykonywania zapytania testowego: " + e.getMessage());
        }
    }
}
