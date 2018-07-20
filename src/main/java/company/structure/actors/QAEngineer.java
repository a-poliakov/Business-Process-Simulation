package company.structure.actors;

import company.wages.ISalary;
import company.services.IServiceCall;
import company.services.Task;

public class QAEngineer<T extends ISalary> extends Employee<T> {
    public QAEngineer(String name, T salary) {
        super(name, salary);
    }

    public QAEngineer(String name) {
        super(name);
    }

    @Override
    public void doTask(IServiceCall serviceCall) {
        ((Task)serviceCall).writeOffLabor(this.generator.nextInt(99) + 1);
    }

    @Override
    public void introduce() {
        System.out.println(String.format("Инженер QA %s", this.getName()));
        if (this.getSalary() != null) {
            this.getSalary().print();
        }
    }
}
