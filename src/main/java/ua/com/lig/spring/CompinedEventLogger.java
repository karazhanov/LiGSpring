package ua.com.lig.spring;

import java.util.List;

/**
 * @author karazhanov on 04.01.17.
 */
public class CompinedEventLogger implements EventLogger{
    private List<EventLogger> loggers;

    public CompinedEventLogger(List<EventLogger> loggers) {
        this.loggers = loggers;
    }

    @Override
    public void logEvent(Event event) {
        loggers.stream().forEach(eventLogger -> eventLogger.logEvent(event));
    }
}
