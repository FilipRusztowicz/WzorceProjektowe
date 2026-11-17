package DekoratorySZyfrująceIDeszyfrujące;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Podaj tekst do zaszyfrowania: ");
        String oryginal = scanner.nextLine();

        ByteArrayOutputStream bufor = new ByteArrayOutputStream();

        try (OutputStream out = new DekoratorSzyfrujacy(bufor)) {
            out.write(oryginal.getBytes(StandardCharsets.UTF_8));
        }

        byte[] zaszyfrowaneBajty = bufor.toByteArray();
        System.out.println("Zaszyfrowane: " + new String(zaszyfrowaneBajty, StandardCharsets.UTF_8));

        System.out.print("Odszyfrowane: ");
        try (InputStream in = new DekoratorDeszyfrujacy(new ByteArrayInputStream(zaszyfrowaneBajty))) {
            int c;
            while ((c = in.read()) != -1) {
                System.out.print((char) c);
            }
        }
        System.out.println();
    }
}