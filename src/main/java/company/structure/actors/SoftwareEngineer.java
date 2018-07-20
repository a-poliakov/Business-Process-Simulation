package company.structure.actors;

import company.services.Task;
import company.services.lifecircle.State;
import company.wages.ISalary;
import company.services.IServiceCall;

public class SoftwareEngineer<T extends ISalary> extends Employee<T> {
    public SoftwareEngineer(String name, T salary) {
        super(name, salary);
    }

    public SoftwareEngineer(String name) {
        super(name);
    }

    @Override
    public void doTask(IServiceCall serviceCall) {
        if(serviceCall.getState() == State.REGISTERED){
            serviceCall.makeTransition(State.IN_PROGRESS);
            return;
        }
        if(serviceCall.getState() == State.DONE){
            serviceCall.setResponsible(null);
            return;
        }
        int timeIntervalsCount = generator.nextInt(5);
        for(int i = 0; i < timeIntervalsCount; i++){
            if(((Task)serviceCall).isOkAfterTesting()){
                System.out.println(getName() + " интегрирует задачу " + serviceCall.getName() + " в нужные версии.");
            } else {
                System.out.println(getName() + " делает задачу " + serviceCall.getName() + " или исправляет замечания тестирования");
            }
            ((Task)serviceCall).writeOffLabor(this.generator.nextInt(8) + 4);
        }
        if(((Task)serviceCall).isOkAfterTesting()){
            serviceCall.makeTransition(State.SYSTEM_TESTING);
        } else {
            serviceCall.makeTransition(State.MANUAL_TESTING);
        }
    }

    @Override
    public void introduce() {
        System.out.println(String.format("Инженер-программист %s", this.getName()));
        if (this.getSalary() != null) {
            this.getSalary().print();
        }
    }


}
