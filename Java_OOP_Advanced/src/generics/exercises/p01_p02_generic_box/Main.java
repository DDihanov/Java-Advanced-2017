package generics.exercises.p01_p02_generic_box;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt(sc.readLine());

        for (int i = 0; i < count; i++) {
            Box box = new Box(Integer.parseInt(sc.readLine()));
            System.out.println(box);
        }
    }
}
