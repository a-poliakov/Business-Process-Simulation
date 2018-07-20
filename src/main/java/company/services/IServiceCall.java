package company.services;

import company.services.lifecircle.State;
import company.structure.actors.IEmployee;

public interface IServiceCall {
    String getName();

    String getDescription();

    IEmployee getResponsible();

    void makeTransition(State to);

    State getState();

    boolean setResponsible(IEmployee employee);
}
