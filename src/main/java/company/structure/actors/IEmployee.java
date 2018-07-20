package company.structure.actors;

import company.wages.ISalary;
import company.services.IServiceCall;

public interface IEmployee <T extends ISalary> extends IPerson {
    T getSalary();
    void doTask(IServiceCall serviceCall);
}
