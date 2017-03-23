package interfaces_and_abstraction.p08_military_elite.interfaces;

import java.util.List;

public interface IEngineer {
    List<IRepair> getRepairs();

    void addRepairs(List<IRepair> repairs);
}
