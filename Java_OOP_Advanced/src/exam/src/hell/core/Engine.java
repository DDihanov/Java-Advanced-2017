package hell.core;

import hell.core.interfaces.CommandInvoker;
import hell.core.interfaces.Runnable;
import hell.interfaces.InputReader;
import hell.interfaces.OutputWriter;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by Austin on 23/04/2017.
 */
public class Engine implements Runnable {
    private InputReader inputReader;
    private OutputWriter outputWriter;
    private CommandInvoker commandInvoker;

    public Engine(InputReader inputReader, OutputWriter outputWriter, CommandInvoker commandInvoker) {
        this.inputReader = inputReader;
        this.outputWriter = outputWriter;
        this.commandInvoker = commandInvoker;
    }

    @Override
    public void run() {
        String input = "";
        while(!"Quit".equals(input = inputReader.readLine())){
            String[] params = input.split("\\s+");
            try {
                outputWriter.writeLine(this.commandInvoker.invokeCommands(params).trim());
            } catch (ClassNotFoundException |
                    NoSuchMethodException |
                    InvocationTargetException |
                    IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            }
        }

        outputWriter.writeLine(this.commandInvoker.getInfo().trim());
    }
}
