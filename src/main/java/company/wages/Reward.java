package company.wages;

public class Reward extends Salary implements IReward {
    public Reward(int sum) {
        super(sum);
    }

    @Override
    public void print() {
        System.out.println(String.format("Гонорар %s руб.", this.getSum()));
    }
}
