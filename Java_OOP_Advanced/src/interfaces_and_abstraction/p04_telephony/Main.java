package interfaces_and_abstraction.p04_telephony;

import interfaces_and_abstraction.p04_telephony.models.Smartphone;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

        String[] numbers = sc.readLine().split("\\s+");
        String[] sites = sc.readLine().split("\\s+");

        Smartphone smartphone = new Smartphone();


        callNumber(numbers, smartphone);
        browseSites(sites, smartphone);
    }

    private static void browseSites(String[] sites, Smartphone smartphone) {
        for (String site :
                sites) {
            try {
                System.out.println(smartphone.browseSite(site));
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void callNumber(String[] numbers, Smartphone smartphone) {
        for (String number :
                numbers) {
            try {
                System.out.println(smartphone.callPhone(number));
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
