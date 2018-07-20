package company.structure.teams;

import company.structure.actors.IEmployee;

import java.util.ArrayList;
import java.util.List;

public class Team implements ITeam {
    private List<IEmployee> employees;
    private String name;
    private IEmployee head;

    public Team(String name) {
        this.name = name;
        employees = new ArrayList<>();
    }

    public Team(String name, IEmployee head) {
        this.name = name;
        this.head = head;
        employees = new ArrayList<>();
    }

    @Override
    public void addEmployee(IEmployee employee) {
        employees.add(employee);
    }

    @Override
    public void releaseEmployee(IEmployee employee) {
        employees.remove(employee);
    }

    @Override
    public List<IEmployee> getAllEmployees() {
        return employees;
    }

    @Override
    public IEmployee getHead() {
        return head;
    }

    @Override
    public void appointAsHead(IEmployee employee) {
        if(!employees.contains(employee)){
            System.out.println("Ошибка! Работник не относится к данной команде!");
        } else {
            head = employee;
        }
    }

    public void removeHead(){
        head = null;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Team{" +
                "employees=" + employees +
                ", name='" + name + '\'' +
                ", head=" + head +
                '}';
    }
}
