package company.structure.departments;

import company.structure.actors.IEmployee;

import java.util.ArrayList;
import java.util.List;

public class Department implements IDepartment {
    private List<IEmployee> employees;
    private String name = "";
    private IEmployee head;

    public Department(String name) {
        this.name = name;
        employees = new ArrayList<>();
    }

    public Department(String name, IEmployee head) {
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

    public String getName() {
        return name;
    }

    @Override
    public IEmployee getHead() {
        return head;
    }

    @Override
    public void appointAsHead(IEmployee employee) {
        if(!employees.contains(employee)){
            System.out.println("Ошибка! Работник не относится к данному отделу!");
        } else {
            head = employee;
        }
    }

    public void removeHead(){
        head = null;
    }

    @Override
    public String toString() {
        return "Department{" +
                "employees=" + employees +
                ", name='" + name + '\'' +
                '}';
    }
}
