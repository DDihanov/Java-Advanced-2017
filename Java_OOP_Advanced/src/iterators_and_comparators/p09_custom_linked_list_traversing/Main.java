package iterators_and_comparators.p09_custom_linked_list_traversing;


import iterators_and_comparators.p09_custom_linked_list_traversing.interfaces.Engine;
import iterators_and_comparators.p09_custom_linked_list_traversing.models.CommandInterpreter;
import iterators_and_comparators.p09_custom_linked_list_traversing.models.EngineImpl;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        CommandInterpreter commandInterpreter = new CommandInterpreter();
        Engine engine = new EngineImpl(commandInterpreter);

        try {
            engine.run();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
