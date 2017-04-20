package app;

import app.waste_disposal.core.CommandInvokerImpl;
import app.waste_disposal.core.Engine;
import app.waste_disposal.core.GarbageProcessorImpl;
import app.waste_disposal.core.interfaces.CommandInvoker;
import app.waste_disposal.factory.WasteFactoryImpl;
import app.waste_disposal.io.ReaderImpl;
import app.waste_disposal.io.WriterImpl;
import app.waste_disposal.io.interfaces.Reader;
import app.waste_disposal.io.interfaces.Writer;
import app.waste_disposal.models.data.RecyclingStationImpl;

public class Main {
    public static void main(String[] args) {
        Reader reader = new ReaderImpl();
        Writer writer = new WriterImpl();
        CommandInvoker commandInvoker = new CommandInvokerImpl(new RecyclingStationImpl(),
                new WasteFactoryImpl(),
                new GarbageProcessorImpl());
        Engine engine = new Engine(reader, writer, commandInvoker);
        engine.run();
    }
}
