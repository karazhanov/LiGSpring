package ua.com.lig.spring.testing;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @author karazhanov on 05.01.17.
 */
@Configuration
public class LoggerConfig {

//    @Autowired
//    @Qualifier("consoleEL")
    @Resource(name = "consoleEL")
    private EventLogger consoleEventLogger;

    @Resource(name = "fileEventLogger")
    private EventLogger fileEventLogger;

    @Resource(name = "compinedEventLogger")
    private EventLogger compinedEventLogger;

    @Bean
//    @DependsOn({"consoleEL", "fileEventLogger"})
    public Collection<EventLogger> combinedLoggers() {
        Collection<EventLogger> cl = new ArrayList<>();
        cl.add(consoleEventLogger);
        cl.add(fileEventLogger);
        return cl;
    }

    @Bean
    public Map<EventType, EventLogger> loggerMap() {
        Map<EventType, EventLogger> m = new HashMap<>();
        m.put(EventType.INFO, consoleEventLogger);
        m.put(EventType.ERROR, compinedEventLogger);
        return m;
    }

}
