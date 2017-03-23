package interfaces_and_abstraction.p08_military_elite.interfaces;

import java.util.List;

public interface ICommando {
    List<IMission> getMissions();

    void addMissions(List<IMission> missions);
}
