package by.bntu.fitr.povt.prostrmk.model.loggers;

import by.bntu.fitr.povt.prostrmk.model.Event;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class FileEventLogger implements EventLogger {

    private String fileName;
    private File file;

    public FileEventLogger(String fileName) {
        this.fileName = fileName;
        file = new File(fileName);

    }

    private void init() throws IOException {
        file = new File(fileName);
        if (!file.canWrite()){
            throw new IOException();
        }
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void logEvent(Event event) {
        try {
            FileUtils.writeStringToFile(file,event.toString(),"UTF-8",true);
            System.out.println("Successfully added to a file");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
