package by.bntu.fitr.povt.cng.model.util.logging;

import by.bntu.fitr.povt.cng.model.util.logging.Decorator.TextDecorator;

import java.util.ArrayList;
import java.util.List;

public class CacheLogger extends AbstractLogger implements Logger {

    private Logger logger;
    private int sizeOfCache;
    List<String> logStrings;
    private TextDecorator decorator = null;

    public CacheLogger(){
        logger = new ConsoleLogger();
    }

    public CacheLogger(Logger logger, int sizeOfCache, TextDecorator decorator) {
        this.logger = logger;
        this.sizeOfCache = sizeOfCache;
        this.logStrings = new ArrayList<>();
        this.decorator = decorator;
    }

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
                if (decorator != null){
                    logger.logEvent(decorator.change(logString));
                }else{
                    logger.logEvent(logString);
                }
            }
            logStrings.clear();
        }
    }
}
