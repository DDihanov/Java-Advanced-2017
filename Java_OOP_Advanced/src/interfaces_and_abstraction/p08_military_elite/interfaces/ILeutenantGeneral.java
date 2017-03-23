package interfaces_and_abstraction.p08_military_elite.interfaces;

import interfaces_and_abstraction.p08_military_elite.models.Private;

import java.util.List;
import java.util.Map;

public interface ILeutenantGeneral extends IPrivate{
    List<IPrivate> getPrivates();

    void addPrivate(Integer id, Map<Integer, Private> privates);
}
