package interfaces_and_abstraction.p07_food_shortage;

import interfaces_and_abstraction.p07_food_shortage.interfaces.Buyer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

        List<Buyer> citizens = new ArrayList<>();
        Factory factory = new Factory();

        String input = "";
        int count = Integer.parseInt(sc.readLine());

        for (int i = 0; i < count; i++) {
            String[] info = sc.readLine().split("\\s+");
            citizens.add(factory.createCitizen(info));
        }

        while(!"End".equals(input = sc.readLine())){
            for (Buyer citizen :
                    citizens) {
                if(citizen.getName().equals(input)){
                    citizen.buyFood();
                }
            }
        }

        int totalFood = citizens.stream().mapToInt(c->c.getFood()).sum();
        System.out.println(totalFood);
    }

}
