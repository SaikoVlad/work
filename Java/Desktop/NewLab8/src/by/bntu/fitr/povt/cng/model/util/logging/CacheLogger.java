package by.bntu.fitr.povt.cng.model.util.logging;

import java.util.ArrayList;
import java.util.List;

public class CacheLogger extends AbstractLogger implements Logger {

    private Logger logger;
    private int sizeOfCache;
    List<String> logStrings;

    public CacheLogger(Logger logger, int sizeOfCache) {
        this.logger = logger;
        this.sizeOfCache = sizeOfCache;
        this.logStrings = new ArrayList<>();
    }

    @Override
    public void logEvent(String string) {
        logStrings.add(string);
        if (sizeOfCache == logStrings.size()){
            for (String logString : logStrings) {
                logger.logEvent(logString);
            }
            logStrings.clear();
        }
    }
}
