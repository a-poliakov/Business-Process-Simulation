package company.structure;

import company.structure.actors.IEmployee;
import company.structure.departments.IDepartment;
import company.structure.teams.ITeam;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Company {
    private List<IDepartment> departments = new ArrayList<>();
    private List<ITeam> teams = new ArrayList<>();
    private List<IEmployee> employees = new ArrayList<>();

    private static Company ourInstance = new Company();

    public static Company getInstance() {
        return ourInstance;
    }

    private Company() {
    }

    public void addEmployeeToDepartment(IEmployee employee, IDepartment destination)
    {
        IDepartment previous;
        if(null != (previous = findEmployeesDepartment(employee))){
            previous.releaseEmployee(employee);
        }
        if(null != destination){
            destination.addEmployee(employee);
        }
    }

    public void removeEmployeeFromDepartment(IEmployee employee, IDepartment from)
    {
        IDepartment employeesDepartment = findEmployeesDepartment(employee);
        if(null == from || null == employeesDepartment || !employeesDepartment.equals(from)){
            System.out.println("Ошибка! Отдел не существует или сотрудник не может быть из него удален.");
        } else {
            from.releaseEmployee(employee);

        }
    }

    public void hireEmployee(IEmployee employee){
        if(employees.contains(employee)){
            System.out.println("Работник уже в штате!");
            return;
        }
        employees.add(employee);
    }

    public void fireEmployee(IEmployee employee){
        if(!employees.contains(employee)){
            System.out.println("Работник не найден!");
            return;
        }
        findEmployeesTeams(employee).stream().forEach(team -> team.getAllEmployees().remove(employee));
        findEmployeesDepartment(employee).getAllEmployees().remove(employee);
        employees.remove(employee);
    }

    public void addEmployeeToTeam(IEmployee employee, ITeam destination)
    {
        if(null != destination && !findEmployeesTeams(employee).contains(destination)){
            destination.addEmployee(employee);
        }
    }

    public void removeEmployeeFromTeam(IEmployee employee, ITeam from)
    {
        if(null == from || !findEmployeesTeams(employee).contains(from)){
            System.out.println("Ошибка! Команда не существует или сотрудник не может быть из нее удален.");
        } else {
            from.releaseEmployee(employee);
        }
    }

    public void appointAsDepartmentHead(IEmployee employee, IDepartment department){
        if(null != department){
            department.appointAsHead(employee);
        }
    }

    public void appointAsTeamLead(IEmployee employee, ITeam team){
        if(null != team){
            team.appointAsHead(employee);
        }
    }

    private IDepartment findEmployeesDepartment(IEmployee employee)
    {
        for (IDepartment department : departments) {
            if(department.getAllEmployees().contains(employee)){
                return department;
            }
        }
        return null;
    }

    public String findEmployeesDepartmentName(IEmployee employee){
        return findEmployeesDepartment(employee).getName();
    }

    public Pair<String, IEmployee> findEmployeesDepartmentHead(IEmployee employee){
        IDepartment department = findEmployeesDepartment(employee);
        IEmployee head = null;
        String departmentName = "";
        if (department != null) {
            head = department.getHead();
            departmentName = department.getName();
        }
        return new Pair<String, IEmployee>(departmentName, head);
    }

    public Map<String, IEmployee> findEmployeesTeamleads(IEmployee employee){
        Map<String, IEmployee> result = new HashMap<>();
        for (ITeam team : findEmployeesTeams(employee)) {
            result.put(team.getName(), team.getHead());
        }
        return result;
    }

    private List<ITeam> findEmployeesTeams(IEmployee employee)
    {
        List<ITeam> result = new ArrayList<>();
        for (ITeam team : teams) {
            if(team.getAllEmployees().contains(employee)){
               result.add(team);
            }
        }
        return result;
    }

    public List<String> findEmployeesTeamsNames(IEmployee employee){
        return findEmployeesTeams(employee).stream().map(ITeam::getName).collect(Collectors.toList());
    }

    public void addDepartment(IDepartment department){
        if(!departments.contains(department)){
            departments.add(department);
        }
    }

    public void addTeam(ITeam team){
        if(!teams.contains(team)){
            teams.add(team);
        }
    }

    public void removeDepartment(IDepartment department){
        if(departments.contains(department)){
            departments.remove(department);
        }
    }

    public void removeTeam(ITeam team){
        if(teams.contains(team)){
            teams.remove(team);
        }
    }
}
