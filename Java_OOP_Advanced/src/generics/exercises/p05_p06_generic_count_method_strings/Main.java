package generics.exercises.p05_p06_generic_count_method_strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt(sc.readLine());
        List<Box> boxes = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            Box box = new Box(Double.parseDouble(sc.readLine()));
            boxes.add(box);
        }

        Box comparator = new Box<>(Double.parseDouble(sc.readLine()));

        System.out.println(compareWithElement(boxes, comparator));
    }

    private static <T> void swapElement(List<T> list, int firstIndex, int secondIndex){
        T firstEl = list.get(firstIndex);
        T secondEl = list.get(secondIndex);

        list.set(firstIndex, secondEl);
        list.set(secondIndex, firstEl);
    }

    private static <T extends Comparable<T>> int compareWithElement(List<T> list, T element){
        int count = 0;
        for (T t : list) {
            if(t.compareTo(element)>0){
                count++;
            }
        }

        return count;
    }
}
