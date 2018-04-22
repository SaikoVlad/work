package by.bntu.fitr.povt.prostrmk.model.loggers;

import by.bntu.fitr.povt.prostrmk.model.Event;

public class ConsoleEventLogger implements EventLogger{


    public void logEvent(Event event) {
        System.out.println(event.toString());
    }
}
