package reflection.p07_1984.factories;

import reflection.p07_1984.factories.interfaces.ObserverFactory;
import reflection.p07_1984.models.Institution;
import reflection.p07_1984.models.interfaces.Observer;

public class ObserverFactoryImpl implements ObserverFactory {

    @Override
    public Observer createObserver(String id, String name) {
        return new Institution(id, name);
    }
}
