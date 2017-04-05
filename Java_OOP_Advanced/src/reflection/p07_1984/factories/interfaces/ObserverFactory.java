package reflection.p07_1984.factories.interfaces;

import reflection.p07_1984.models.interfaces.Observer;

public interface ObserverFactory {

    Observer createObserver(String id, String name);
}
