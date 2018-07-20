package company.structure.actors;

import company.wages.ISalary;
import company.services.IServiceCall;

import java.util.Random;

public abstract class Employee<T extends ISalary> implements IEmployee<T> {
    private String name;
    private T salary;
    Random generator = new Random();

    Employee(String name, T salary) {
        this.name = name;
        this.salary = salary;
    }

    Employee(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public T getSalary() {
        return this.salary;
    }

    public abstract void doTask(IServiceCall serviceCall);

    public abstract void introduce();

    @Override
    public String toString() {
        return "Employee{" +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", generator=" + generator +
                '}';
    }
}
