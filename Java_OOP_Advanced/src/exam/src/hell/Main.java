package hell;

import hell.core.CommandInvokerImpl;
import hell.core.Engine;
import hell.core.interfaces.CommandInvoker;
import hell.interfaces.InputReader;
import hell.interfaces.OutputWriter;
import hell.io.InputReaderImpl;
import hell.io.OutputWriterImpl;

public class Main {
    public static void main(String[] args) {
        OutputWriter outputWriter = new OutputWriterImpl();
        InputReader inputReader = new InputReaderImpl();
        CommandInvoker commandInvoker = new CommandInvokerImpl();

        Engine engine = new Engine(inputReader, outputWriter, commandInvoker);
        engine.run();
    }
}