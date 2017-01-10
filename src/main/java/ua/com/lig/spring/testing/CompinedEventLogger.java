package ua.com.lig.spring.testing;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author karazhanov on 04.01.17.
 */
@Component
public class CompinedEventLogger implements EventLogger{
    @Resource(name = "combinedLoggers")
    private List<EventLogger> loggers;

    @Override
    public void logEvent(Event event) {
//        .filter(eventLogger1 -> eventLogger1!=null)
        loggers.stream().forEach(eventLogger -> eventLogger.logEvent(event));
    }
}
