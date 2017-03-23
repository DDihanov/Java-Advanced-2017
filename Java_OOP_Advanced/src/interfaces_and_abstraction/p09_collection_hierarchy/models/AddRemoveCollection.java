package interfaces_and_abstraction.p09_collection_hierarchy.models;


import interfaces_and_abstraction.p09_collection_hierarchy.interfaces.IAdd;
import interfaces_and_abstraction.p09_collection_hierarchy.interfaces.IRemove;

import java.util.LinkedList;

public class AddRemoveCollection implements IAdd, IRemove {

    private LinkedList<String> list;

    public AddRemoveCollection() {
        this.list = new LinkedList<String>();
    }

    @Override
    public String remove() {
        return this.list.removeLast();
    }

    @Override
    public int add(String str) {
        this.list.addFirst(str);
        return 0;
    }

}
