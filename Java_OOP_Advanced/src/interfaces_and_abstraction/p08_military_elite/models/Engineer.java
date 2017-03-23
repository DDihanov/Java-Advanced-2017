package interfaces_and_abstraction.p08_military_elite.models;

import interfaces_and_abstraction.p08_military_elite.interfaces.IEngineer;
import interfaces_and_abstraction.p08_military_elite.interfaces.IRepair;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Engineer extends SpecialisedSoldier implements IEngineer {
    private List<IRepair> repairs;

    public Engineer(int id, String firstName, String lastName, double salary, String corps) {
        super(id, firstName, lastName, salary, corps);
        this.repairs = new ArrayList();
    }

    @Override
    public List<IRepair> getRepairs() {
        return Collections.unmodifiableList(this.repairs);
    }

    @Override
    public void addRepairs(List<IRepair> repairs) {
        this.repairs.addAll(repairs);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(super.toString());
        sb.append("Repairs:\n");
        this.getRepairs().forEach(sb::append);

        return sb.toString();
    }
}
