package GuruObserwator;

public class Main {
    public static void main(String[] args) {
        Editor editor = new Editor();
        editor.events.subscribe("open", new LogOpenListener("log.txt"));
        editor.events.subscribe("save", new EmailNotificationListener("admin@example.com"));

        try {
            editor.openFile("test.txt");
            editor.writeContent("Jakaś przykładowa zawartość pliku.");
            editor.saveFile();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}