package interfaces_and_abstraction.p06_birthday_celebrations;

import interfaces_and_abstraction.p06_birthday_celebrations.interfaces.Birthdatable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

        List<Birthdatable> citizens = new ArrayList<>();
        Factory factory = new Factory();

        String input = "";

        while (!"End".equals(input = sc.readLine())) {
            String[] info = input.split("\\s+");
            Birthdatable unit = factory.createUnit(info);
            if(!(unit == null)){
                citizens.add(unit);
            }
        }

        input = sc.readLine();

        checkBirthdays(citizens, input);
    }

    private static void checkBirthdays(List<Birthdatable> citizens, String input) {
        StringBuilder sb = new StringBuilder();
        for (Birthdatable citizen :
                citizens) {
            String birthdate = citizen.getBirthday();
            if(birthdate.endsWith(input)) {
                sb.append(birthdate).append(System.lineSeparator());
            }
        }

        System.out.print(sb.toString());
    }
}
