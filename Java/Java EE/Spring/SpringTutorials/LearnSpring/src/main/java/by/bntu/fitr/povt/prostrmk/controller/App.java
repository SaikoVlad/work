package by.bntu.fitr.povt.prostrmk.controller;

import by.bntu.fitr.povt.prostrmk.model.*;
import by.bntu.fitr.povt.prostrmk.model.loggers.ConsoleEventLogger;
import by.bntu.fitr.povt.prostrmk.model.loggers.EventLogger;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

    private EventLogger eventLogger;
    private Client client;
    private Event event;

    public App(Client client, Event event){
        this.client = client;
        this.event = event;
        this.eventLogger = new ConsoleEventLogger();
    }

    public App(Client client, EventLogger eventLogger, Event event) {
        this.eventLogger = eventLogger;
        this.client = client;
        this.event = event;
    }

    public void setEventLogger(EventLogger eventLogger) {
        this.eventLogger = eventLogger;
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        App app = (App) context.getBean("app");
        app.eventLogger.logEvent(app.event);
        System.out.println(app.client);
        context.close();


    }



}
