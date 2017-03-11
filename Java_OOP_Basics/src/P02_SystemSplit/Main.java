package P02_SystemSplit;

import P02_SystemSplit.models.TheSystem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

        TheSystem theSystem = new TheSystem();

        String input = "";

        while (!"System Split".equals(input = sc.readLine())) {
            int index = input.indexOf('(');
            String command = input.substring(0, index);
            String[] tokens = input.substring(index + 1, input.length() - 1).split(", ");

            switch (command) {
                case "RegisterPowerHardware":
                    theSystem.registerPowerHardware(tokens[0], Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2]));
                    break;
                case "RegisterHeavyHardware":
                    theSystem.registerHeavyHardware(tokens[0], Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2]));
                    break;
                case "Analyze":
                    System.out.print(theSystem.analyze());
                    break;
                case "RegisterLightSoftware":
                    theSystem.registerLightSoftware(tokens[0], tokens[1], Integer.parseInt(tokens[2]), Integer.parseInt(tokens[3]));
                    break;
                case "RegisterExpressSoftware":
                    theSystem.registerExpressSoftware(tokens[0], tokens[1], Integer.parseInt(tokens[2]), Integer.parseInt(tokens[3]));
                    break;
                case "ReleaseSoftwareComponent":
                    theSystem.releaseSoftwareComponent(tokens[0], tokens[1]);
                    break;
            }
        }

        System.out.println(theSystem.split());
    }
}
