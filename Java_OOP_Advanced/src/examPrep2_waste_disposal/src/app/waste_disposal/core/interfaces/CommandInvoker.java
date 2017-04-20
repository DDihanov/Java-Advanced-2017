package app.waste_disposal.core.interfaces;

import java.lang.reflect.InvocationTargetException;

public interface CommandInvoker {
    String invokeArguments(String command, String... params) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException;
}
