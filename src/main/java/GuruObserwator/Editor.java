package GuruObserwator;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Editor {
    public EventManager events;
    private File file;
    private String content = "";

    public Editor() {
        this.events = new EventManager("open", "save");
    }

    public void openFile(String filePath) throws IOException {
        this.file = new File(filePath);
        if (!this.file.exists()) {
            this.file.createNewFile();
        }
        events.notify("open", file);
    }

    public void writeContent(String text) {
        this.content = text;
    }

    public void saveFile() throws Exception {
        if (this.file != null) {
            try (FileWriter writer = new FileWriter(this.file)) {
                writer.write(this.content);
            }
            events.notify("save", file);
        } else {
            throw new Exception("Please open a file first.");
        }
    }
}