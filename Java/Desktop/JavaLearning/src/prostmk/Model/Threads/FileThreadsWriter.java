package prostmk.Model.Threads;

import java.io.FileWriter;
import java.io.IOException;

public class FileThreadsWriter implements Runnable {

    private String filename;
    private String text;

    public FileThreadsWriter(String filename, String text) {
        this.filename = filename;
        this.text = text;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public void run() {
        write();
    }

    private void write() {
        try {
            FileWriter fw = new FileWriter(filename);
            fw.write(text);
            fw.flush();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
