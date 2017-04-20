package app.waste_disposal.models.strategies;

import app.waste_disposal.annotations.Burnable;
import app.waste_disposal.annotations.Recyclable;
import app.waste_disposal.annotations.Storable;
import app.waste_disposal.contracts.GarbageDisposalStrategy;
import app.waste_disposal.contracts.StrategyHolder;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class DefaultStrategyHolder implements StrategyHolder {

    private Map<Class,GarbageDisposalStrategy> strategies;

    public DefaultStrategyHolder(){
        this.initStrategies();
    }

    @Override
    public Map<Class, GarbageDisposalStrategy> getDisposalStrategies() {
        return Collections.unmodifiableMap(this.strategies);
    }

    @Override
    public boolean addStrategy(Class annotationClass, GarbageDisposalStrategy strategy) {
        this.strategies.put(annotationClass,strategy);
        return true;
    }

    @Override
    public boolean removeStrategy(Class annotationClass) {
        this.strategies.remove(annotationClass);
        return true;
    }

    private void initStrategies() {
        this.strategies = new LinkedHashMap<>();
        this.addStrategy(Burnable.class, new BurnableStrategy());
        this.addStrategy(Recyclable.class, new RecyclableStrategy());
        this.addStrategy(Storable.class, new StorableStrategy());
    }
}
