package generics.lab.p06_generic_flat_method;

import java.util.List;

public class ListUtils {

    public static <T> void flatten(List<? super T> destination, List<List<? extends T>> source){
        for (List<? extends T> inner : source) {
            for (T t : inner) {
                destination.add(t);
            }
        }
    }

    public static <T> void addAll(List<? super T> destination, List<? extends T> source){
        for (T t : source) {
            destination.add(t);
        }
    }
}
