package app.waste_disposal.core;

import app.waste_disposal.core.interfaces.CommandInvoker;
import app.waste_disposal.io.interfaces.Reader;
import app.waste_disposal.io.interfaces.Writer;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class Engine implements Runnable {
    private Reader reader;
    private Writer writer;
    private CommandInvoker commandInvoker;

    public Engine(Reader reader, Writer writer, CommandInvoker commandInvoker) {
        this.reader = reader;
        this.writer = writer;
        this.commandInvoker = commandInvoker;
    }

    @Override
    public void run() {
        String input = "";
        try {
            while(!"TimeToRecycle".equals(input = this.reader.read())){
                String[] args = input.split("[ |]");
                String command = args[0];
                String[] params = Arrays.copyOfRange(args, 1, args.length);
                this.writer.write(this.commandInvoker.invokeArguments(command, params));
            }
        } catch (IOException |
                InstantiationException |
                NoSuchMethodException |
                InvocationTargetException |
                ClassNotFoundException |
                IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
