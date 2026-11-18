package GuruObserwator;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class EmailNotificationListener implements EventListener {
    private String email;

    public EmailNotificationListener(String email) {
        this.email = email;
    }

    @Override
    public void update(String eventType, File file) {
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        System.out.println("=========================================");
        System.out.println("[SMTP] Łączenie z serwerem pocztowym...");
        System.out.println("[SMTP] Wysłano wiadomość do: " + email);
        System.out.println("[SMTP] Temat: Powiadomienie o operacji '" + eventType + "'");
        System.out.println("[SMTP] Treść: Wykonano operację '" + eventType + "' na pliku: " + file.getName());
        System.out.println("=========================================");

        // Zapisujemy też atrapę wysłanego maila do pliku, żeby był ślad na dysku
        try (PrintWriter out = new PrintWriter(new FileWriter("sent_emails.txt", true))) {
            out.println("[" + timestamp + "] DO: " + email + " | OPERACJA: " + eventType + " | PLIK: " + file.getName());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}