package reflection.p07_1984.factories.interfaces;

import reflection.p07_1984.models.interfaces.Entity;

public interface EntityFactory {

    Entity createEntity(String[] args) throws ReflectiveOperationException;
}
