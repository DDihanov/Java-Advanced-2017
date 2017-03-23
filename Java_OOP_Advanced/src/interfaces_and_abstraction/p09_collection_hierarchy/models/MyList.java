package interfaces_and_abstraction.p09_collection_hierarchy.models;


import interfaces_and_abstraction.p09_collection_hierarchy.interfaces.IAdd;
import interfaces_and_abstraction.p09_collection_hierarchy.interfaces.IRemove;
import interfaces_and_abstraction.p09_collection_hierarchy.interfaces.IUsed;

import java.util.LinkedList;

public class MyList implements IAdd, IRemove, IUsed {

    private LinkedList<String> list;

    public MyList() {
        this.list = new LinkedList<>();
    }

    @Override
    public int add(String str) {
        this.list.addFirst(str);
        return 0;
    }


    @Override
    public int getSize() {
        return this.list.size();
    }

    @Override
    public String remove() {
        return this.list.removeFirst();
    }
}
