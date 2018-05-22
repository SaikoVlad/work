package by.bntu.fitr.povt.cng.model.util.logging;

import by.bntu.fitr.povt.cng.model.util.logging.Decorator.TextDecorator;

public class CombinedLogger extends AbstractLogger implements Logger {

    private String fileName;
    private TextDecorator decorator = null;

    public CombinedLogger() {
        fileName = "fileLogger.txt";
    }

    public CombinedLogger(String fileName, TextDecorator decorator) {
        this.fileName = fileName;
        this.decorator = decorator;
    }

    public CombinedLogger(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void logEvent(String string) {
        if (decorator != null){
            new FileLogger(fileName).logEvent(decorator.change(string));
            new ConsoleLogger().logEvent(decorator.change(string));
        }else{
            new FileLogger(fileName).logEvent(string);
            new ConsoleLogger().logEvent(string);
        }

    }
}
