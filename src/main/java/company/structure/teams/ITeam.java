package company.structure.teams;

import company.structure.actors.IEmployee;

import java.util.List;

public interface ITeam {
    void addEmployee(IEmployee employee);
    void releaseEmployee(IEmployee employee);
    List<IEmployee> getAllEmployees();
    IEmployee getHead();
    String getName();
    void appointAsHead(IEmployee employee);
    void removeHead();
}
