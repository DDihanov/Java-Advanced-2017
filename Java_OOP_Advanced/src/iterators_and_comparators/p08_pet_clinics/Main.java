package iterators_and_comparators.p08_pet_clinics;

import iterators_and_comparators.p08_pet_clinics.interfaces.Engine;
import iterators_and_comparators.p08_pet_clinics.models.CommandInterpreter;
import iterators_and_comparators.p08_pet_clinics.models.EngineImpl;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Engine engine = new EngineImpl(new CommandInterpreter());

        engine.run();
    }
}
