package reflection.p07_1984;


import reflection.p07_1984.core.Engine;
import reflection.p07_1984.core.ExecutorImpl;
import reflection.p07_1984.core.RepositoryImpl;
import reflection.p07_1984.core.interfaces.Executor;
import reflection.p07_1984.core.interfaces.Repository;
import reflection.p07_1984.core.interfaces.Runnable;
import reflection.p07_1984.factories.EntityFactoryImpl;
import reflection.p07_1984.factories.ObserverFactoryImpl;
import reflection.p07_1984.factories.interfaces.EntityFactory;
import reflection.p07_1984.factories.interfaces.ObserverFactory;
import reflection.p07_1984.io.ConsoleReader;
import reflection.p07_1984.io.ConsoleWriter;
import reflection.p07_1984.io.interfaces.Reader;
import reflection.p07_1984.io.interfaces.Writer;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        Writer writer = new ConsoleWriter();
        Reader reader = new ConsoleReader();

        Repository repository = new RepositoryImpl();
        ObserverFactory observerFactory = new ObserverFactoryImpl();
        EntityFactory entityFactory = new EntityFactoryImpl();

        Executor executor = new ExecutorImpl(observerFactory, entityFactory, repository);
        Runnable engine = new Engine(writer, reader, executor, repository);

        try {
            engine.run();
        } catch (IOException | ReflectiveOperationException e) {
            e.printStackTrace();
        }
    }
}
