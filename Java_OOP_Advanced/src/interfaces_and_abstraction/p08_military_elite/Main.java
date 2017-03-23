package interfaces_and_abstraction.p08_military_elite;

import interfaces_and_abstraction.p08_military_elite.models.Soldier;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

        List<Soldier> soldiers = new ArrayList();
        Factory factory = new Factory();

        String input = "";

        while(!"End".equals(input = sc.readLine())){
            String[] info = input.split("\\s+");
            Soldier soldier = factory.makeSoldier(info);

            if(!(soldier == null)){
                soldiers.add(soldier);
            }
        }

        for (Soldier soldier :
                soldiers) {
            System.out.print(soldier);
        }
    }
}
