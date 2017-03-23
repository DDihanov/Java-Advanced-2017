package interfaces_and_abstraction.p08_military_elite;

import interfaces_and_abstraction.p08_military_elite.interfaces.*;
import interfaces_and_abstraction.p08_military_elite.models.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Factory {
    private static Map<Integer, Private> privates;

    static {
        privates = new HashMap<>();
    }

    public Factory() {
    }

    public Soldier makeSoldier(String... args) {
        switch (args[0]) {
            case "Private":
                return makePrivate(args);
            case "LeutenantGeneral":
                return makeLeutenantGeneral(args);
            case "Engineer":
                return makeEngineer(args);
            case "Commando":
                return makeCommando(args);
            case "Spy":
                return makeSpy(args);
            default:
                return null;
        }
    }

    private Soldier makeSpy(String[] args) {
        int id = Integer.parseInt(args[1]);
        Spy spy = new Spy(id, args[2], args[3], Integer.parseInt(args[4]));

        return spy;
    }

    private Soldier makeCommando(String[] args) {
        List<IMission> missions = new ArrayList<>();
        try {
            Commando commando = new Commando(Integer.parseInt(args[1]), args[2], args[3], Double.parseDouble(args[4]), args[5]);
            int count = args.length;

            for (int i = 6; i < count; i += 2) {
                String missionName = args[i];
                String missionState = args[i + 1];

                Mission mission = new Mission(missionName, missionState);
                if (!(mission.getState() == null)) {
                    missions.add(mission);
                }
            }


            commando.addMissions(missions);

            return commando;
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

    private Soldier makeEngineer(String[] args) {
        try{
            Engineer engineer = new Engineer(Integer.parseInt(args[1]), args[2], args[3], Double.parseDouble(args[4]), args[5]);
            List<IRepair> repairs = new ArrayList<>();
            int count = args.length;
            for (int i = 6; i < count; i += 2) {
                String partName = args[i];
                int hoursWorked = Integer.parseInt(args[i + 1]);
                repairs.add(new Repair(hoursWorked, partName));
            }
            engineer.addRepairs(repairs);

            return engineer;
        }catch(IllegalArgumentException e){
            return null;
        }
    }

    private Soldier makeLeutenantGeneral(String[] args) {
        LeutenantGeneral general = new LeutenantGeneral(Integer.parseInt(args[1]), args[2], args[3], Double.parseDouble(args[4]));
        int count = args.length;
        for (int i = 5; i < count; i++) {
            int privateId = Integer.parseInt(args[i]);
            general.addPrivate(privateId, privates);
        }

        return general;
    }

    private Soldier makePrivate(String[] args) {
        int id = Integer.parseInt(args[1]);
        Private pr = new Private(id, args[2], args[3], Double.parseDouble(args[4]));
        this.privates.put(id, pr);
        return pr;
    }


}
