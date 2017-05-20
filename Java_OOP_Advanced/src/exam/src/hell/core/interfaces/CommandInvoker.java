package hell.core.interfaces;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by Austin on 23/04/2017.
 */
public interface CommandInvoker {
    String invokeCommands(String... args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException;
    String getInfo();
}
