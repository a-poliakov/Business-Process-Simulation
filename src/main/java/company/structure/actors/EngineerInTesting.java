package company.structure.actors;

import company.services.IServiceCall;
import company.services.Task;
import company.services.lifecircle.State;
import company.wages.ISalary;

public class EngineerInTesting <T extends ISalary> extends Employee<T> {
    public EngineerInTesting(String name, T salary) {
        super(name, salary);
    }

    public EngineerInTesting(String name) {
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
        int timeIntervalsCount = generator.nextInt(3);
        for(int i = 0; i < timeIntervalsCount; i++){
            ((Task)serviceCall).writeOffLabor(this.generator.nextInt(4) + 2);
        }
        if(serviceCall.getState() == State.MANUAL_TESTING){
            boolean isEverythingOk = generator.nextBoolean();
            serviceCall.makeTransition(State.IN_PROGRESS);
            ((Task)serviceCall).setOkAfterTesting(isEverythingOk, this);
            if(isEverythingOk){
                System.out.println(getName() + " провел РТ задачи " + serviceCall.getName() + " и не нашел (-а) замечаний.");
            } else {
                System.out.println(getName() + " провел РТ задачи " + serviceCall.getName() + " и нашел (-а) замечание (-я).");
            }
            return;
        }
        if(serviceCall.getState() == State.SYSTEM_TESTING){
            boolean isEverythingOk = generator.nextBoolean();
            ((Task)serviceCall).setOkAfterTesting(isEverythingOk, this);
            if(isEverythingOk){
                System.out.println(getName() + " провел тест версии для задачи " + serviceCall.getName() + " и не нашел (-а) замечаний.");
            } else {
                System.out.println(getName() + " провел тест версии для задачи " + serviceCall.getName() + " и нашел (-а) замечание (-я).");
            }
            serviceCall.makeTransition(isEverythingOk ? State.DONE : State.IN_PROGRESS);
        }
    }

    @Override
    public void introduce() {

    }
}
