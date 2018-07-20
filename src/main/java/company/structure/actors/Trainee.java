package company.structure.actors;

import company.services.IServiceCall;
import company.wages.ISalary;

import java.util.Random;

public class Trainee<T extends ISalary> extends Student implements IEmployee<T>  {
    private String name;
    private T salary;
    Random generator = new Random();

    public Trainee(String name, T reward) {
        this.name = name;
        this.salary = reward;
    }

    @Override
    public T getSalary() {
        return salary;
    }

    @Override
    public void doTask(IServiceCall serviceCall) {

    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void introduce() {
        System.out.println(String.format("Стажер %s", name));
        if (this.getSalary() != null) {
            this.getSalary().print();
        }
    }
}
