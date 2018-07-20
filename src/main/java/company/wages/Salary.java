package company.wages;

public abstract class Salary implements ISalary {
    private int sum;

    Salary(int sum) {
        this.sum = sum;
    }

    @Override
    public int getSum() {
        return this.sum;
    }

    @Override
    public void setSum(int sum) {
        this.sum = sum;
    }

    @Override
    public abstract void print();
}
