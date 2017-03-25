package iterators_and_comparators.p08_pet_clinics.models;

import iterators_and_comparators.p08_pet_clinics.interfaces.Engine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EngineImpl implements Engine {
    private CommandInterpreter commandInterpreter;

    public EngineImpl(CommandInterpreter commandInterpreter) {
        this.commandInterpreter = commandInterpreter;
    }


    @Override
    public void run() throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt(sc.readLine());

        for (int i = 0; i < count; i++) {
            String[] args = sc.readLine().split("\\s+");

            this.commandInterpreter.execCommands(args);
        }
    }
}
