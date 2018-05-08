package by.bntu.fitr.povt.cng.model.util.logging;

import java.util.Date;

public class ConsoleLogger extends AbstractLogger implements Logger{


    @Override
    public void logEvent(String string) {
        var baseString = super.getBaseString();
        System.out.println(baseString + string);
    }
}
