package company.services.project;

import com.sun.istack.internal.NotNull;
import company.services.IServiceCall;
import company.services.lifecircle.State;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Project {
    private String name;
    private List<IServiceCall> serviceCalls = new ArrayList<>();

    public Project(String name) {
        this.name = name;
    }

    public Project(String name, @NotNull List<IServiceCall> serviceCalls) {
        this.name = name;
        this.serviceCalls = serviceCalls;
    }

    public String getName() {
        return name;
    }

    public List<IServiceCall> getServiceCalls() {
        return serviceCalls;
    }

    public void addAllServiceCalls(IServiceCall... serviceCalls){
        this.serviceCalls.addAll(Arrays.asList(serviceCalls));
    }

    public void addServiceCall(IServiceCall serviceCall){
        if(!serviceCalls.contains(serviceCall)){
            serviceCalls.add(serviceCall);
        }
    }

    public void removeServiceCall(IServiceCall serviceCall){
        if(serviceCalls.contains(serviceCall)){
            serviceCalls.remove(serviceCall);
        }
    }

    public boolean isProjectReady(){
        for (IServiceCall serviceCall: serviceCalls) {
            if(serviceCall.getState() != State.DONE){
                return false;
            }
        }
        return true;
    }

    public IServiceCall findServiceCallsToDo(){
        for (IServiceCall serviceCall: serviceCalls) {
            if(serviceCall.getState() != State.DONE && serviceCall.getResponsible() == null){
                return serviceCall;
            }
        }
        return null;
    }
}
