package reflection.p03_04_05_barracks.core;

import reflection.p03_04_05_barracks.contracts.CommandInterpreter;
import reflection.p03_04_05_barracks.contracts.Executable;
import reflection.p03_04_05_barracks.contracts.Runnable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Engine implements Runnable {

    private CommandInterpreter commandInterpreter;

    public Engine(CommandInterpreter commandInterpreter) {
        this.commandInterpreter = commandInterpreter;
    }

    @Override
    public void run() {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));
        while (true) {
            try {
                String input = reader.readLine();
                String[] data = input.split("\\s+");
                String commandName = data[0];

                Executable exe = this.commandInterpreter.interpretCommand(data, commandName);
                String result = exe.execute();
                if (result.equals("fight")) {
                    break;
                }

                System.out.println(result);
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            } catch (IOException | ReflectiveOperationException e) {
                e.printStackTrace();
            }
        }
    }
}
