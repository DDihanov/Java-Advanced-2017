package SOLID_principles.p01_logger.core;

import SOLID_principles.p01_logger.core.interfaces.Controller;
import SOLID_principles.p01_logger.models.appenders.Appender;
import SOLID_principles.p01_logger.models.loggers.Logger;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ControllerImpl implements Controller {
    private Logger logger;
    private List<Appender> appenderList;

    public ControllerImpl(Logger logger) {
        this.logger = logger;
        this.appenderList = new ArrayList<>();
    }

    @Override
    public void log(String... args) throws InvocationTargetException, IllegalAccessException {
        String temp = args[0].toLowerCase().substring(1, args[0].length());
        Character firstLetter = args[0].charAt(0);
        String methodName = "log" + firstLetter + temp;

        String time = args[1];
        String message = args[2];
        Method[] loggerMethods = this.logger.getClass().getMethods();
        Method methodToInvoke = Arrays.stream(loggerMethods).filter(m -> m.getName().equals(methodName)).findFirst().get();
        methodToInvoke.invoke(this.logger,time, message);
    }

    @Override
    public String getLoggerInfo() {
        return this.logger.toString();
    }
}
