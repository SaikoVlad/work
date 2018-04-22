package by.bntu.fitr.povt.prostrmk.model.loggers;

import by.bntu.fitr.povt.prostrmk.model.Event;

import java.util.ArrayList;
import java.util.Arrays;

public class CombinedEventLogger implements EventLogger {

    ArrayList<EventLogger> loggers = new ArrayList<EventLogger>();

    public CombinedEventLogger(EventLogger...eventLoggers){
        loggers.addAll(Arrays.asList(eventLoggers));
    }

    public void logEvent(Event event) {
        for (EventLogger logger : loggers){
            logger.logEvent(event);
        }
    }

}
