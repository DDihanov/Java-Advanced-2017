package app.waste_disposal.core;

import app.waste_disposal.annotations.Inject;
import app.waste_disposal.commands.Executable;
import app.waste_disposal.contracts.GarbageProcessor;
import app.waste_disposal.core.interfaces.CommandInvoker;
import app.waste_disposal.factory.WasteFactory;
import app.waste_disposal.models.data.RecyclingStation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class CommandInvokerImpl implements CommandInvoker {
    private static final String COMMAND_SUFFIX = "Command";
    private static final String COMMAND_DIRECTORY = "app.waste_disposal.commands.";

    private RecyclingStation recyclingStation;
    private WasteFactory wasteFactory;
    private GarbageProcessor garbageProcessor;

    public CommandInvokerImpl(RecyclingStation recyclingStation,
                              WasteFactory wasteFactory,
                              GarbageProcessor garbageProcessor) {
        this.recyclingStation = recyclingStation;
        this.wasteFactory = wasteFactory;
        this.garbageProcessor = garbageProcessor;
    }



    @Override
    public String invokeArguments(String command, String... params) throws ClassNotFoundException,
            NoSuchMethodException,
            IllegalAccessException,
            InvocationTargetException,
            InstantiationException {
        Class commandClass = Class.forName(COMMAND_DIRECTORY + command + COMMAND_SUFFIX);
        Constructor commandConstructor = commandClass.getDeclaredConstructor();
        Executable commandToExecute = (Executable) commandConstructor.newInstance();
        this.injectArgs(commandToExecute, commandClass);

        return commandToExecute.execute(params);
    }

    private void injectArgs(Executable executable, Class<Executable> executableClass) throws IllegalAccessException {
        Field[] fields = executableClass.getDeclaredFields();

        for (Field field : fields) {
            if(field.isAnnotationPresent(Inject.class)){
                field.setAccessible(true);
                if(field.getType().equals(WasteFactory.class)){
                    field.set(executable, this.wasteFactory);
                }
                if(field.getType().equals(GarbageProcessor.class)){
                    field.set(executable, this.garbageProcessor);
                }
                if(field.getType().equals(RecyclingStation.class)){
                    field.set(executable, this.recyclingStation);
                }
            }
        }
    }
}
