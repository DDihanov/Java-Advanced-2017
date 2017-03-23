package generics.lab.p06_generic_flat_method;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
        public static void main(String[] args) {
        List<Integer> integers = new ArrayList<>();
        Collections.addAll(integers, 1,2,3);

        List<Double> doubles = new ArrayList<>();
        Collections.addAll(doubles, 1.2, 3.2);

        List<Number> dest = new ArrayList<>();
        ListUtils.addAll(dest, doubles);
        ListUtils.addAll(dest, integers);

        for (Number number : dest) {
            System.out.println(number);
        }
    }
}
