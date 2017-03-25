package iterators_and_comparators.p01_p02_listyIterator;

import iterators_and_comparators.p01_p02_listyIterator.interfaces.ListyIterator;
import iterators_and_comparators.p01_p02_listyIterator.models.ListyIteratorImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;

public class CommandInterpreter{
    private ListyIterator<String> listyIterator;
    private boolean isRunning;
    private BufferedReader bufferedReader;

    public CommandInterpreter(BufferedReader bufferedReader) {
        this.isRunning = true;
        this.bufferedReader = bufferedReader;
    }

    public void interpetCommand() throws IOException {

        while(this.isRunning){
            String[] args = this.bufferedReader.readLine().split("\\s+");
            switch(args[0]){
                case"Create":
                    String[] arr = Arrays.copyOfRange(args, 1, args.length);
                    this.createList(arr);
                    break;
                case"Move":
                    printResult(this.listyIterator.move());
                    break;
                case"Print":
                    this.listyIterator.print();
                    break;
                case"HasNext":
                    printResult(this.listyIterator.listyHasNext());
                    break;
                case"PrintAll":
                    printResult(this.listyIterator);
                    break;
                case"END":
                    this.endInput();
            }
        }
    }

    private static void printResult(Object o){
        System.out.println(o);
    }

    private static void printResult(ListyIterator<? extends CharSequence> list){
        System.out.println(String.join(" ", list));
    }

    private void endInput(){
        this.isRunning = false;
    }

    private void createList(String... args){
        this.listyIterator = new ListyIteratorImpl<>(args);
    }
}
