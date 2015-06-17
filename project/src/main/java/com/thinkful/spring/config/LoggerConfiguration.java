package com.thinkful.spring.config;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.joran.JoranConfigurator;
import ch.qos.logback.core.joran.spi.JoranException;
import ch.qos.logback.core.util.StatusPrinter;
import com.google.common.base.Strings;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * Created by neville on 15/10/14.
 */
@Configuration
public class LoggerConfiguration {

    @Value("${logger.path}")
    String loggerPath;

    @PostConstruct
    public void initLogger() throws JoranException {
        configureLogger();
    }

    private void configureLogger() throws JoranException {
        final String logPath = getLoggerPath();
        if (logPath == null) {
            return;
        }

        LoggerContext context = (LoggerContext) LoggerFactory.getILoggerFactory();

        try {
            JoranConfigurator configurator = new JoranConfigurator();
            configurator.setContext(context);
            context.reset();

            if (logPath.startsWith("classpath:")) {
                String embeddedPath = logPath.substring(10);
                if (!embeddedPath.startsWith("/")) {
                    embeddedPath = "/" + embeddedPath;
                }
                configurator.doConfigure(this.getClass().getResourceAsStream(embeddedPath));
            } else {
                configurator.doConfigure(logPath);
            }

        } catch (JoranException je) {

            StatusPrinter.printInCaseOfErrorsOrWarnings(context);
            throw je;
        }
    }

    private String getLoggerPath() {
        return Strings.emptyToNull(loggerPath);
    }
}
