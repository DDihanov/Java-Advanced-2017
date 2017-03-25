package iterators_and_comparators.p03_stack_iterator;

import iterators_and_comparators.p03_stack_iterator.interfaces.CustomStack;
import iterators_and_comparators.p03_stack_iterator.models.CustomStackImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        CustomStack<Integer> stack = new CustomStackImpl<>();
        String input;

        while(!"END".equals(input = sc.readLine())){
            String[] info = input.split(" |, ");

            try{
                switch(info[0]){
                    case"Push":
                        stack.push(Stream.of(info).skip(1).mapToInt(Integer::parseInt).boxed().toArray(Integer[]::new));
                        break;
                    case"Pop":
                        stack.pop();
                }
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }


        for (Integer integer : stack) {
            System.out.println(integer);
        }
        for (Integer integer : stack) {
            System.out.println(integer);
        }
    }
}
