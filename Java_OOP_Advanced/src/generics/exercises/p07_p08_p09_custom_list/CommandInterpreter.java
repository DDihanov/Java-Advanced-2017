package generics.exercises.p07_p08_p09_custom_list;

import generics.exercises.p07_p08_p09_custom_list.interfaces.ICustomList;
import generics.exercises.p07_p08_p09_custom_list.models.Sorter;

public class CommandInterpreter<T extends Comparable<T>> {
    private ICustomList<String> data;


    public CommandInterpreter(ICustomList<String> data) {
        this.data = data;
    }

    public void interpretCommands(String... args){
        switch(args[0]){
            case"Add":
                this.data.add(args[1]);
                break;
            case"Remove":
                this.data.remove(Integer.parseInt(args[1]));
                break;
            case"Contains":
                System.out.println(this.data.contains(args[1]));
                break;
            case"Swap":
                this.data.swap(Integer.parseInt(args[1]), Integer.parseInt(args[2]));
                break;
            case"Greater":
                System.out.println(this.data.countGreaterThan(args[1]));
                break;
            case"Max":
                System.out.println(this.data.getMax());
                break;
            case"Min":
                System.out.println(this.data.getMin());
                break;
            case"Print":
                this.data.print();
                break;
            case"Sort":
                Sorter.sort(this.data);
                break;
        }
    }
}
