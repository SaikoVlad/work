package by.bntu.fitr.povt.cng.model.util.logging;

import java.util.Date;

public abstract class AbstractLogger implements Logger {
    @Override
    public String getBaseString() {
        return new Date().toString() + ": ";
    }

    @Override
    public abstract void logEvent(String string);
}
