package SOLID_principles.p01_logger.models.loggers;

import SOLID_principles.p01_logger.models.appenders.Appender;

import java.util.List;

public class MessageLogger extends LoggerImpl {
    public MessageLogger(List<Appender> appenders) {
        super(appenders);
    }
}
