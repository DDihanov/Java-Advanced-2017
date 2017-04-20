package SOLID_principles.p01_logger.models.loggers;

import SOLID_principles.p01_logger.enums.ReportLevel;
import SOLID_principles.p01_logger.models.appenders.Appender;

import java.util.List;

public abstract class LoggerImpl implements Logger {
    List<Appender> appenders;

    protected LoggerImpl(List<Appender> appenders) {
        this.appenders = appenders;
    }

    @Override
    public void logError(String dateTime, String message) {
        this.invokeAppenders(dateTime,message);
    }

    @Override
    public void logInfo(String dateTime, String message) {
        this.invokeAppenders(dateTime,message);
    }

    @Override
    public void logCritical(String dateTime, String message) {
        this.invokeAppenders(dateTime,message);
    }

    @Override
    public void logFatal(String dateTime, String message) {
        this.invokeAppenders(dateTime,message);
    }

    @Override
    public void logWarning(String dateTime, String message) {
        this.invokeAppenders(dateTime,message);
    }

    private void invokeAppenders(String dateTime, String message){
        String currentMehtodName = Thread.currentThread()
                .getStackTrace()[2]
                .getMethodName();
        String currentLevel = currentMehtodName.substring(3, currentMehtodName.length()).toUpperCase();
        for (Appender appender : this.appenders) {
            appender.append(dateTime, message, Enum.valueOf(ReportLevel.class, currentLevel));
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Logger info\n");
        for (Appender appender : this.appenders) {
            sb.append(appender);
            sb.append(System.lineSeparator());
        }

        return sb.toString();
    }
}
