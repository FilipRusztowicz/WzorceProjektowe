package LowerToUpper;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class Test {
    public static void main(String[] args) {
        System.out.println("Wpisz tekst i naciśnij Enter:");

        // Opakowujemy standardowe wejście (klawiaturę) w nasz dekorator
        InputStream in = new LowerCaseInputStream(System.in);

        try {
            int c;
            while ((c = in.read()) != -1 && c != '\n') {
                System.out.print((char) c);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
