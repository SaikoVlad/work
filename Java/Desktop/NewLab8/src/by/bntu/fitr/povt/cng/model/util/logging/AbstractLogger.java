package by.bntu.fitr.povt.cng.model.util.logging;

import by.bntu.fitr.povt.cng.model.util.logging.Decorator.TextDecorator;

import java.util.Date;

public abstract class AbstractLogger implements Logger {

    public AbstractLogger(TextDecorator textDecorator){

    }

    public AbstractLogger() {
    }

    @Override
    public String getBaseString() {
        return new Date().toString() + ": ";
    }

    @Override
    public abstract void logEvent(String string);
}
