package reflection.p03_04_05_barracks.contracts;

import reflection.p03_04_05_barracks.core.CommandInterpreterImpl;

public interface Injector {

    void injectDependencies(Executable executable, Class to, CommandInterpreterImpl from)
            throws ReflectiveOperationException;
}
