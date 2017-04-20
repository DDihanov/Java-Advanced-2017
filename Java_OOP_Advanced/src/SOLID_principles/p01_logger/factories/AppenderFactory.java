package SOLID_principles.p01_logger.factories;

import SOLID_principles.p01_logger.models.appenders.Appender;

public interface AppenderFactory {
    Appender createAppender(String... args) throws ReflectiveOperationException;
}
