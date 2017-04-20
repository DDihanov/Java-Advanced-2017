package SOLID_principles.p01_logger.core.interfaces;

import java.lang.*;
import java.lang.reflect.InvocationTargetException;

public interface Controller{
    void log(String... message) throws InvocationTargetException, IllegalAccessException;

    String getLoggerInfo();
}
