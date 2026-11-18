package GuruObserwator;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LogOpenListener implements EventListener {
    private File log;

    public LogOpenListener(String fileName) {
        this.log = new File(fileName);
    }

    @Override
    public void update(String eventType, File file) {
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        String entry = "[" + timestamp + "] Operacja: " + eventType + " | Plik: " + file.getName();

        try (PrintWriter out = new PrintWriter(new FileWriter(log, true))) {
            out.println(entry);
            System.out.println("[LOG] Dopisano wpis do pliku: " + log.getName());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}