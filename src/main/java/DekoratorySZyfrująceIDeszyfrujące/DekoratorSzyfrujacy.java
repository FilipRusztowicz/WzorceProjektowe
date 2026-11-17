package DekoratorySZyfrująceIDeszyfrujące;

import java.io.FilterInputStream;
import java.io.FilterOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class DekoratorSzyfrujacy extends FilterOutputStream {
    private final int przesuniecie = 13;
    public DekoratorSzyfrujacy(OutputStream out) {
        super(out);
    }

    @Override
    public void write(int b) throws java.io.IOException {
        char znak = (char) b;

        if (znak >= 'a' && znak <= 'z') {
            znak = (char) ('a' + (znak - 'a' + przesuniecie) % 26);
        } else if (znak >= 'A' && znak <= 'Z') {
            znak = (char) ('A' + (znak - 'A' + przesuniecie) % 26);
        }

        super.write(znak);
    }

}
