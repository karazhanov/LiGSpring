package ua.com.lig.spring;

/**
 * @author karazhanov on 04.01.17.
 */
public class ConsoleEventLogger implements EventLogger{

    @Override
    public void logEvent(Event event) {
        System.out.println(event.toString());
    }
}
