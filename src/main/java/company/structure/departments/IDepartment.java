package company.structure.departments;

import company.structure.actors.IEmployee;

import java.util.List;

public interface IDepartment {
    void addEmployee(IEmployee employee);
    void releaseEmployee(IEmployee employee);
    List<IEmployee> getAllEmployees();
    String getName();
    IEmployee getHead();
    void appointAsHead(IEmployee employee);
    void removeHead();
}
