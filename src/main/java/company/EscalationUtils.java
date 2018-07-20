package company;

import company.structure.actors.IEmployee;
import company.services.IServiceCall;
import company.structure.Company;
import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;

public class EscalationUtils {
    public enum EscalationLevel {
        MAJOR,
        MINOR,
        CRITICAL
    }

    private static Map<IServiceCall, Integer> escalations = new HashMap<>();

    public static void escalate(IServiceCall serviceCall){
        if(!escalations.containsKey(serviceCall)){
            escalations.put(serviceCall, 0);
        }
        switch (calcEscalationLevel(escalations.get(serviceCall))){
            case CRITICAL:
            case MINOR:
            case MAJOR:
                Pair<String, IEmployee> pair = Company.getInstance().findEmployeesDepartmentHead(serviceCall.getResponsible());
                String departmentHead = pair.getValue().getName();
                String departmentTitle = pair.getKey();
                StringBuilder teamleads = new StringBuilder();
                teamleads.append("{\n");
                for (Map.Entry<String, IEmployee> entry: Company.getInstance().findEmployeesTeamleads(serviceCall.getResponsible()).entrySet()) {
                    teamleads.append('[').append(entry.getKey()).append(':').append(entry.getValue().getName()).append("]\n");
                }
                teamleads.append('}');
                System.out.println(
                        String.format("Внимание! Руководитель подразделения %s (%s), тимлиды (%s)! " +
                                        "Проследите за задачей %s. Проведите беседу с исполнителем задачи [%s]",
                                departmentTitle, departmentHead, teamleads, serviceCall.getName(), serviceCall.getResponsible().getName()
                                ));
        }
        escalations.put(serviceCall, escalations.get(serviceCall)+1);
    }

    private static EscalationLevel calcEscalationLevel(Integer count)
    {
        if(count < 3)
        {
            return EscalationLevel.MAJOR;
        }
        else if(count < 5)
        {
            return EscalationLevel.MINOR;
        }
        else
        {
            return EscalationLevel.CRITICAL;
        }
    }
}
