package generics.exercises.p05_p06_generic_count_method_strings;

public class Box<T extends Comparable<T>> implements Comparable<Box<T>>{
    private T value;

    public Box(T value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.format("%s: %s", value.getClass().getName(), this.value);
    }

    public T getValue() {
        return value;
    }

    @Override
    public int compareTo(Box<T> o) {
        return this.value.compareTo(o.getValue());
    }
}
