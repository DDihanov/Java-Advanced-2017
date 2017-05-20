package hell.core;

import hell.annotations.Inject;
import hell.commands.Executable;
import hell.core.interfaces.CommandInvoker;
import hell.data.HeroDatabase;
import hell.data.HeroDatabaseImpl;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by Austin on 23/04/2017.
 */
public class CommandInvokerImpl implements CommandInvoker {
    private static final String COMMAND_DIRECTORY = "hell.commands.";
    private static final String COMMAND_SUFFIX = "Command";

    private HeroDatabase heroDatabase;

    public CommandInvokerImpl() {
        this.heroDatabase = new HeroDatabaseImpl();
    }

    @Override
    public String invokeCommands(String... args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class commandClass = Class.forName(COMMAND_DIRECTORY + args[0] + COMMAND_SUFFIX);
        Executable commandToExec = (Executable) commandClass.getConstructor().newInstance();
        this.injectArgs(commandToExec, commandClass);

        return commandToExec.execute(args);
    }

    private void injectArgs(Executable commandToExec, Class commandClass) throws IllegalAccessException {
        Field[] fields = commandClass.getDeclaredFields();

        for (Field field : fields) {
            if (field.isAnnotationPresent(Inject.class)) {
                field.setAccessible(true);
                field.set(commandToExec, this.heroDatabase);
            }
        }
    }

    @Override
    public String getInfo() {
        return this.heroDatabase.toString();
    }
}
