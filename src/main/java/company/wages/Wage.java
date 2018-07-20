package company.wages;

public class Wage extends Salary implements IWage {
    private int period;

    public Wage(int sum, int period) {
        super(sum);
        this.period = period;
    }

    @Override
    public int getPeriod() {
        return this.period;
    }

    @Override
    public void print() {
        System.out.println(String.format("Оклад: %d руб. в %d дней.", this.getSum(), this.getPeriod()));
    }
}
