package reflection.p07_1984.models;

import reflection.p07_1984.annotations.Inject;
import reflection.p07_1984.annotations.Monitored;

public class Employee extends EntityImpl {

    @Inject
    private Integer income;

    public Employee() {
        super();
    }

    @Monitored("income")
    private void setIncome(Integer income) throws NoSuchFieldException {
        Integer oldIncome = this.income;
        this.income = income;
        super.fireEvent(new ChangeEventImpl<>(
                this,
                this.getClass().getDeclaredField("income"),
                oldIncome,
                this.income));
    }

}
