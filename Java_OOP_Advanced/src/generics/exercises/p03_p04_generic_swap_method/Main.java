package generics.exercises.p03_p04_generic_swap_method;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt(sc.readLine());
        List<Box> boxes = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            Box box = new Box(Integer.parseInt(sc.readLine()));
            boxes.add(box);
        }

        int[] indexes = Arrays.stream(sc.readLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

        swapElement(boxes, indexes[0], indexes[1]);

        boxes.forEach(box -> System.out.println(box));


    }

    private static <T> void swapElement(List<T> list, int firstIndex, int secondIndex){
        T firstEl = list.get(firstIndex);
        T secondEl = list.get(secondIndex);

        list.set(firstIndex, secondEl);
        list.set(secondIndex, firstEl);
    }
}
