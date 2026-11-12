package SingletonZBaza;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PolaczenieZBaza {
    private static PolaczenieZBaza uniqInstancja;
    private Connection polaczenie;

    private static final String url="jdbc:mysql://localhost:3306/bar";
    private static final String uz="root";
    private static final String  ps="";

    private PolaczenieZBaza(){
        try{
            polaczenie= DriverManager.getConnection(url,uz,ps);
            System.out.println("Polaczono!");
        } catch (SQLException e) {
            System.out.println("Nie Polaczono!");
        }
    }

    public static PolaczenieZBaza pobierzUniqInstancje(){
        try{
            if(uniqInstancja==null || uniqInstancja.pobierzPolaczenie()==null||uniqInstancja.pobierzPolaczenie().isClosed()){
                uniqInstancja=new PolaczenieZBaza();
            }
        }catch(SQLException e){
            System.out.println("BLAD" + e.getMessage());
        }
        return uniqInstancja;
    }
    public Connection pobierzPolaczenie() {
        return polaczenie;
    }
}
