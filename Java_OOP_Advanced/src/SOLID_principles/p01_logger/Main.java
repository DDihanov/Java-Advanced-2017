package SOLID_principles.p01_logger;

import SOLID_principles.p01_logger.core.Engine;
import SOLID_principles.p01_logger.factories.AppenderFactory;
import SOLID_principles.p01_logger.factories.AppenderFactoryImpl;
import SOLID_principles.p01_logger.io.console.ReaderImpl;
import SOLID_principles.p01_logger.io.console.WriterImpl;
import SOLID_principles.p01_logger.io.interfaces.Reader;
import SOLID_principles.p01_logger.io.interfaces.Writer;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws IllegalAccessException, IOException, InvocationTargetException {
        Writer writer = new WriterImpl();
        Reader reader = new ReaderImpl();
        AppenderFactory appenderFactory = new AppenderFactoryImpl();
        Engine engine = new Engine(reader, writer, appenderFactory);

        engine.run();
    }
}
