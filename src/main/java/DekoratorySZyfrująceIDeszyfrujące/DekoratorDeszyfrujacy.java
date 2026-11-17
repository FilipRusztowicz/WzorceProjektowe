package DekoratorySZyfrująceIDeszyfrujące;

import java.io.*;

public class DekoratorDeszyfrujacy extends FilterInputStream {

    private final int przesuniecie =13;

    protected DekoratorDeszyfrujacy(InputStream in) {
        super(in);
    }

    @Override
    public int read() throws IOException {
        int b = super.read();
        if (b == -1) return -1;

        return odszyfrujZnak((char) b);
    }

    @Override
    public int read(byte[] b, int off, int len) throws IOException {
        int result = super.read(b, off, len);
        for (int i = off; i < off + result; i++) {
            b[i] = (byte) odszyfrujZnak((char) b[i]);
        }
        return result;
    }

    private char odszyfrujZnak(char znak) {
        if (znak >= 'a' && znak <= 'z') {
            return (char) ('a' + (znak - 'a' - przesuniecie + 26) % 26);
        } else if (znak >= 'A' && znak <= 'Z') {
            return (char) ('A' + (znak - 'A' - przesuniecie + 26) % 26);
        }
        return znak;
    }
}
