package interfaces_and_abstraction.p08_military_elite.models;

import interfaces_and_abstraction.p08_military_elite.interfaces.ICommando;
import interfaces_and_abstraction.p08_military_elite.interfaces.IMission;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Commando extends SpecialisedSoldier implements ICommando {
    private List<IMission> missions;

    public Commando(int id, String firstName, String lastName, double salary, String corps) {
        super(id, firstName, lastName, salary, corps);
        this.missions = new ArrayList<>();
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("Missions:\n");
        this.getMissions().forEach(sb::append);

        return sb.toString();
    }

    @Override
    public List<IMission> getMissions() {
        return Collections.unmodifiableList(this.missions);
    }

    @Override
    public void addMissions(List<IMission> missions) {
        this.missions.addAll(missions);
    }
}
