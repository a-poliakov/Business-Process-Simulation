package company.services;

import company.services.lifecircle.State;
import company.services.lifecircle.TransitionTable;
import company.structure.actors.EngineerInTesting;
import company.structure.actors.IEmployee;
import company.structure.actors.QAEngineer;
import company.structure.actors.SoftwareEngineer;

public abstract class ServiceCall implements IServiceCall{
    private String name;
    private String description;
    private IEmployee responsible;
    private State state;

    public ServiceCall(String name, String description) {
        this.name = name;
        this.description = description;
        state = State.REGISTERED;
    }

    public ServiceCall(String name, String description, IEmployee responsible) {
        this.name = name;
        this.description = description;
        this.responsible = responsible;
        state = State.REGISTERED;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public IEmployee getResponsible() {
        return responsible;
    }

    public State getState() {
        return state;
    }

    @Override
    public void makeTransition(State to) {
        if(TransitionTable.getInstance().isCorrectTransition(state, to)){
            state = to;
            responsible = null;
        }
    }

    public boolean setResponsible(IEmployee employee){
        if(state == State.IN_PROGRESS && (employee instanceof SoftwareEngineer || employee instanceof QAEngineer)){
            responsible = employee;
            return true;
        } else if((state == State.MANUAL_TESTING || state == State.SYSTEM_TESTING) && employee instanceof EngineerInTesting){
            responsible = employee;
            return true;
        } else if(state == State.REGISTERED){
            responsible = employee;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "ServiceCall{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
