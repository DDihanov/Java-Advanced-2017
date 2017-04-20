package SOLID_principles.p01_logger.core.interfaces;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public interface Runnable {
    void run() throws IOException, InvocationTargetException, IllegalAccessException;
}
