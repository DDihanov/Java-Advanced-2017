package interfaces_and_abstraction.p08_military_elite.models;

import interfaces_and_abstraction.p08_military_elite.interfaces.ILeutenantGeneral;
import interfaces_and_abstraction.p08_military_elite.interfaces.IPrivate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class LeutenantGeneral extends Private implements ILeutenantGeneral{
    private List<IPrivate> privates;

    public LeutenantGeneral(int id, String firstName, String lastName, double salary) {
        super(id, firstName, lastName, salary);
        this.privates = new ArrayList<>();
    }

    @Override
    public List<IPrivate> getPrivates() {
        return Collections.unmodifiableList(this.privates);
    }

    @Override
    public void addPrivate(Integer id, Map<Integer, Private> privates) {
        this.privates.add(privates.get(id));
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(super.toString());
        sb.append("Privates:\n");
        this.getPrivates().forEach(pr -> {
            sb.append("  ").append(pr);
        });

        return sb.toString();
    }
}
