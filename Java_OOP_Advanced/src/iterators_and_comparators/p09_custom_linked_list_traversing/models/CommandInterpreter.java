package iterators_and_comparators.p09_custom_linked_list_traversing.models;

import iterators_and_comparators.p09_custom_linked_list_traversing.interfaces.CustomLinkedList;

import java.util.ArrayList;
import java.util.List;

public class CommandInterpreter {
    private CustomLinkedList<Integer> customLinkedList;

    public CommandInterpreter() {
        this.customLinkedList = new CustomLinkedListImpl<>();
    }

    public void executeCommands(String... args){
        switch(args[0]){
            case"Add":
                this.customLinkedList.addLast(Integer.parseInt(args[1]));
                break;
            case"Remove":
                this.customLinkedList.remove(Integer.parseInt(args[1]));
                break;
        }
    }

    public void print(){
        List<String> output = new ArrayList<>();
        for (Integer integer : customLinkedList) {
            output.add(String.valueOf(integer));
        }
        System.out.print(String.join(" ", output));
    }

    public void printSize(){
        System.out.println(this.customLinkedList.getSize());
    }
}
