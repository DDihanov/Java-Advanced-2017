package reflection.p07_1984.models;

import reflection.p07_1984.annotations.Inject;
import reflection.p07_1984.annotations.Monitored;

public class Company extends EntityImpl {

    @Inject
    private Integer turnover;
    @Inject
    private Integer revenue;

    public Company() {
        super();
    }

    @Monitored("turnover")
    private void setTurnover(Integer turnover) throws NoSuchFieldException {
        Integer oldTurnover = this.turnover;
        this.turnover = turnover;
        super.fireEvent(new ChangeEventImpl<>(
                this,
                this.getClass().getDeclaredField("turnover"),
                oldTurnover,
                this.turnover));
    }

    @Monitored("revenue")
    private void setRevenue(int revenue) throws NoSuchFieldException {
        int oldRevenue = this.revenue;
        this.revenue = revenue;
        super.fireEvent(new ChangeEventImpl<>(
                this,
                this.getClass().getDeclaredField("revenue"),
                oldRevenue,
                this.revenue));
    }
}
