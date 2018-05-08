package by.bntu.fitr.povt.cng.model.util.logging;

import java.io.*;

public class FileLogger extends AbstractLogger implements Logger {

    private String fileName;

    public FileLogger() {
        fileName = "fileLogger.txt";
    }

    public FileLogger(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void logEvent(String string) {
        var baseString = super.getBaseString();
        try (var writer = new FileWriter(new File(fileName), true)){
            writer.append(baseString).append(string).append("\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
