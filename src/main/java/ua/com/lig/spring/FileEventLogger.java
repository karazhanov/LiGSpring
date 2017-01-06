package ua.com.lig.spring;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;

/**
 * @author karazhanov on 04.01.17.
 */
@Component("fileEventLogger")
public class FileEventLogger implements EventLogger {

    private String fileName = "/home/karazhanov/fileName.txt";
    private File file;

//    public FileEventLogger(String fileName) {
//        this.fileName = fileName;
//    }

    @PostConstruct
    public void init() throws IOException {
        this.file = new File(fileName);
        if(!this.file.canWrite()) {
            throw new IOException();
        }
    }

    @Override
    public void logEvent(Event event) {
        try {
            FileUtils.writeStringToFile(file, event.toString(), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
