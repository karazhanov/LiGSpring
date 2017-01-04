package ua.com.lig.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

/**
 * @author karazhanov on 04.01.17.
 */
public class App {

    private Client client;
    private EventLogger eventLogger;
    private Map<EventType, EventLogger> loggers;
    private String greeting;

    public App(Client client, EventLogger eventLogger, Map<EventType, EventLogger> loggers) {
        this.client = client;
        this.eventLogger = eventLogger;
        this.loggers = loggers;
    }

    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }

    private EventLogger getLogger(EventType type) {
        EventLogger logger = loggers.get(type);
        if(logger == null) {
            logger = eventLogger;
        }
        return logger;
    }

    private void logEvent(Event e, String msg) {
        logEvent(e, null, msg);
    }

    private void logEvent(Event e, EventType type, String msg) {
        String message = msg.replace(client.getId(), client.getFullName());
        e.setMsg(message);
        EventLogger logger = getLogger(type);
        logger.logEvent(e);
    }

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
        App app = (App) ctx.getBean("app");

        Event e1 = (Event) ctx.getBean("event");
        app.logEvent(e1, "Hello from 1");
        Event e2 = (Event) ctx.getBean("event");
        app.logEvent(e2, EventType.INFO, app.greeting);
        Event e3 = (Event) ctx.getBean("event");
        app.logEvent(e3, EventType.ERROR, app.greeting);
    }
}
