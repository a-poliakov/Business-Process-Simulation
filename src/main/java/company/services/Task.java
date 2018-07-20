package company.services;

import company.EscalationUtils;
import company.structure.actors.EngineerInTesting;
import company.structure.actors.IEmployee;

public abstract class Task extends ServiceCall {
    private int estimatedTime;
    private int elapsedTime;
    private boolean isEstimated;
    private boolean isOkAfterTesting;

    public Task(String name, String description) {
        super(name, description);
    }

    public void evaluateTask(int hours){
        if(hours <= 0){
            System.out.println("Ошибка!\nВремя работы над задачей должно быть больше 0!\n");
        }
        estimatedTime = hours;
    }

    public void writeOffLabor(int hours){
        if(hours <= 0){
            System.out.println("Ошибка!\nВремя работы над задачей должно быть больше 0!\n");
        }
        elapsedTime+=hours;
        System.out.println(String.format("На задачу '%s' было списано %d часов (-а). Осталось %d из %d", getName(), hours, getLeftTime(), estimatedTime));
        if(estimatedTime - elapsedTime < 0){
            System.out.println("Внимание! На задачу затрачено ТЗТ больше начальной оценки!");
            EscalationUtils.escalate(getInstance());
        }
    }

    public int getLeftTime()
    {
        return estimatedTime - elapsedTime < 0 ? 0 : estimatedTime - elapsedTime;
    }

    private IServiceCall getInstance(){
        return (IServiceCall)this;
    }


    public boolean isOkAfterTesting() {
        return isOkAfterTesting;
    }

    public void setOkAfterTesting(boolean okAfterTesting, IEmployee tester) {
        if(tester instanceof EngineerInTesting){
            isOkAfterTesting = okAfterTesting;
        } else {
            System.out.println("Ошибка! Нет прав на изменение статуса проверки тестирования задачи.");
        }
    }
}
