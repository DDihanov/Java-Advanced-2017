package iterators_and_comparators.p04_froggy;

import iterators_and_comparators.p04_froggy.models.Lake;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

        Lake<Integer> lake = new Lake();
        String input;

        while(!"END".equals(input = sc.readLine())){
            String[] info = input.split(" |, |,");

            lake.add(Stream.of(info).mapToInt(Integer::parseInt).boxed().toArray(Integer[]::new));
        }

        StringBuilder stringBuilder = new StringBuilder();

        for (Integer integer : lake) {
            stringBuilder.append(integer).append(", ");
        }
        stringBuilder.setLength(stringBuilder.length() - 2);

        System.out.println(stringBuilder);
    }
}
