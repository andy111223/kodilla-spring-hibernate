package com.kodilla.filewritingmessagehandler;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.file.FileReadingMessageSource;
import org.springframework.integration.file.FileWritingMessageHandler;
import org.springframework.integration.scheduling.PollerMetadata;
import org.springframework.scheduling.support.PeriodicTrigger;

import java.io.File;

@Configuration
public class FileIntegrationConfiguration {

    private static final String INPUT_DIRECTORY = "data/input";
    private static final String OUTPUT_FILE = "data/output/log.txt";

    @Bean
    public FileReadingMessageSource fileReadingMessageSource() {
        FileReadingMessageSource source = new FileReadingMessageSource();
        source.setDirectory(new File(INPUT_DIRECTORY));
        return source;
    }

    @Bean
    public FileWritingMessageHandler fileWritingMessageHandler() {
        FileWritingMessageHandler handler = new FileWritingMessageHandler(new File(OUTPUT_FILE));
        handler.setAppendNewLine(true);
        handler.setExpectReply(false);
        return handler;
    }

    @Bean
    public IntegrationFlow fileIntegrationFlow(FileReadingMessageSource fileAdapter,
                                               FileWritingMessageHandler fileWriter) {
        return IntegrationFlow.from(fileAdapter, config -> config.poller(poller()))
                .transform(File.class, File::getName)
                .handle(fileWriter)
                .get();
    }

    @Bean(name = PollerMetadata.DEFAULT_POLLER)
    public PollerMetadata poller() {
        PollerMetadata pollerMetadata = new PollerMetadata();
        pollerMetadata.setTrigger(new PeriodicTrigger(1000));
        return pollerMetadata;
    }
}
