package generics.exercises.p11_threeuple;

import generics.exercises.p11_threeuple.interfaces.Tuple;
import generics.exercises.p11_threeuple.models.TupleImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    @SuppressWarnings("Duplicates")
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

        return new TupleImpl<>(String.format("%s %s", info[0],info[1]), info[2], info[3]);
    }

    private static Tuple getSecondTuple(BufferedReader sc) throws IOException {
        String[] info = sc.readLine().split("\\s+");
        boolean isDrunk;
        if(info[2].equals("drunk")){
            isDrunk = true;
        }else{
            isDrunk = false;
        }
        return new TupleImpl<>(info[0], Integer.parseInt(info[1]), isDrunk);
    }

    private static Tuple getThirdTuple(BufferedReader sc) throws IOException {
        String[] info = sc.readLine().split("\\s+");

        return new TupleImpl<>(info[0], Double.parseDouble(info[1]), info[2]);
    }
}
