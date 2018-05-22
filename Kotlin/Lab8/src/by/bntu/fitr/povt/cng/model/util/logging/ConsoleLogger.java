package by.bntu.fitr.povt.cng.model.util.logging;

import by.bntu.fitr.povt.cng.model.util.logging.Decorator.TextDecorator;

import java.util.Date;

public class ConsoleLogger extends AbstractLogger implements Logger {

    private TextDecorator decorator;

    public ConsoleLogger() {
    }

    public ConsoleLogger(TextDecorator decorator) {
        this.decorator = decorator;
    }

    @Override
    public void logEvent(String string) {
        var baseString = super.getBaseString();
        if (decorator != null) {
            string = decorator.change(string);
        }
        System.out.println(baseString + string);
    }
}
