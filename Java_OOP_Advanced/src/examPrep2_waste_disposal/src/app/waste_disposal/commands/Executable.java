package app.waste_disposal.commands;

import java.lang.reflect.InvocationTargetException;

public interface Executable {
    String execute(String... params) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException;
}
