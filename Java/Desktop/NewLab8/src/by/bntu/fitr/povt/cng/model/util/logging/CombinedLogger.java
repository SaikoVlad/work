package by.bntu.fitr.povt.cng.model.util.logging;

public class CombinedLogger extends AbstractLogger implements Logger {

    String fileName;

    public CombinedLogger() {
        fileName = "fileLogger.txt";
    }

    public CombinedLogger(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void logEvent(String string) {
        new FileLogger(fileName).logEvent(string);
        new ConsoleLogger().logEvent(string);
    }
}
