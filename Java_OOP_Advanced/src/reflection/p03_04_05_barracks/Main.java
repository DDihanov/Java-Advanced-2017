package reflection.p03_04_05_barracks;

import reflection.p03_04_05_barracks.contracts.*;
import reflection.p03_04_05_barracks.contracts.Runnable;
import reflection.p03_04_05_barracks.core.CommandInterpreterImpl;
import reflection.p03_04_05_barracks.core.DependencyInjector;
import reflection.p03_04_05_barracks.core.Engine;
import reflection.p03_04_05_barracks.core.factories.UnitFactoryImpl;
import reflection.p03_04_05_barracks.data.UnitRepository;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class Main {

    public static void main(String[] args) throws IllegalAccessException, IOException, InvocationTargetException {
        Repository repository = new UnitRepository();
        UnitFactory unitFactory = new UnitFactoryImpl();
        Injector dependencyInjector = new DependencyInjector();
        CommandInterpreter commandInterpreter = new CommandInterpreterImpl(repository, unitFactory, dependencyInjector);
        Runnable engine = new Engine(commandInterpreter);
        engine.run();
    }
}
