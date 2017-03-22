package interfaces_and_abstraction.p05_border_control;

import interfaces_and_abstraction.p05_border_control.interfaces.CitizenInterface;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

        List<CitizenInterface> citizens = new ArrayList<>();
        Factory factory = new Factory();

        String input = "";

        while (!"End".equals(input = sc.readLine())) {
            String[] info = input.split("\\s+");
            citizens.add(factory.createCitizen(info));
        }

        input = sc.readLine();

        checkIds(citizens, input);
    }

    private static void checkIds(List<CitizenInterface> citizens, String input) {
        for (CitizenInterface citizen :
                citizens) {
            String id = citizen.getId();
            if(id.endsWith(input)) {
                System.out.println(id);
            }
        }
    }
}
