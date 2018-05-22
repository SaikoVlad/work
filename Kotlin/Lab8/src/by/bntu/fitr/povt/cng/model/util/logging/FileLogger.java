package by.bntu.fitr.povt.cng.model.util.logging;

import by.bntu.fitr.povt.cng.model.util.logging.Decorator.TextDecorator;

import java.io.*;

public class FileLogger extends AbstractLogger implements Logger {

    private String fileName;
    private TextDecorator decorator;

    public FileLogger() {
        fileName = "fileLogger.txt";
    }

    public FileLogger(String fileName, TextDecorator decorator) {
        this.fileName = fileName;
        this.decorator = decorator;
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
