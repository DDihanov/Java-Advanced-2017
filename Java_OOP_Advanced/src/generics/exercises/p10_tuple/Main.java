package generics.exercises.p10_tuple;

import generics.exercises.p10_tuple.interfaces.Tuple;
import generics.exercises.p10_tuple.models.TupleImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

        List<Tuple> tuples = new ArrayList<>();

        tuples.add(getFirstTuple(sc));
        tuples.add(getSecondTuple(sc));
        tuples.add(getThirdTuple(sc));

        for (Tuple tuple : tuples) {
            System.out.println(tuple);
        }
    }

    private static Tuple getFirstTuple(BufferedReader sc) throws IOException {
        String[] info = sc.readLine().split("\\s+");

        return new TupleImpl<>(String.format("%s %s", info[0],info[1]), info[2]);
    }

    private static Tuple getSecondTuple(BufferedReader sc) throws IOException {
        String[] info = sc.readLine().split("\\s+");

        return new TupleImpl<>(info[0], Integer.parseInt(info[1]));
    }

    private static Tuple getThirdTuple(BufferedReader sc) throws IOException {
        String[] info = sc.readLine().split("\\s+");

        return new TupleImpl<>(Integer.parseInt(info[0]), Double.parseDouble(info[1]));
    }
}
