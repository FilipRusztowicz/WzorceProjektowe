package SingletonZBazaAleEnum;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public enum PolaczenieZBaza {
    INSTANCJA;

    private Connection polaczenie;

    private static final String URL = "jdbc:mysql://localhost:3306/bar";
    private static final String UZYTKOWNIK = "root";
    private static final String HASLO = "";


    PolaczenieZBaza() {
        try {
            polaczenie = DriverManager.getConnection(URL, UZYTKOWNIK, HASLO);
            System.out.println("Połączono z bazą danych!");
        } catch (SQLException e) {
            System.out.println("BŁĄD połączenia z bazą: " + e.getMessage());
        }
    }

    public Connection pobierzPolaczenie() {
        return polaczenie;
    }
}
