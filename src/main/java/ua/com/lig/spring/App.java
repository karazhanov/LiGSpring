package ua.com.lig.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author karazhanov on 04.01.17.
 */
@Service
public class App {

    @Autowired
//    @Qualifier("client")
//    @Resource(name = "client")
    private Client client;

    @Resource(name = "consoleEL")
    private EventLogger eventLogger;
    @Resource(name = "loggerMap")
    private Map<EventType, EventLogger> loggers;
//    private String greeting;

//    public App(Client client, EventLogger eventLogger, Map<EventType, EventLogger> loggers) {
//        this.client = client;
//        this.eventLogger = eventLogger;
//        this.loggers = loggers;
//    }

//    public void setGreeting(String greeting) {
//        this.greeting = greeting;
//    }

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
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(AppConfig.class, LoggerConfig.class, App.class);
        ctx.scan("ua.com.lig.spring");
        ctx.refresh();
        App app = ctx.getBean(App.class);

//        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
//        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
        Event e1 = (Event) ctx.getBean("event");
        app.logEvent(e1, "Hello from 1");
        Event e2 = (Event) ctx.getBean("event");
        app.logEvent(e2, EventType.INFO, "Hello from 2");
        Event e3 = (Event) ctx.getBean("event");
        app.logEvent(e3, EventType.ERROR, "Hello from 3");
    }
}
