package company;

import company.factory.serviceCall.DefectFactory;
import company.factory.serviceCall.DevelopmentFactory;
import company.factory.serviceCall.ProjectFactory;
import company.services.Defect;
import company.services.Development;
import company.services.IServiceCall;
import company.services.project.Project;
import company.structure.actors.IEmployee;
import company.structure.departments.IDepartment;
import company.factory.department.DepartmentFactory;
import company.factory.department.IDepartmentFactory;
import company.factory.department.ITeamFactory;
import company.factory.department.TeamFactory;
import company.factory.employee.EmployeeFactory;
import company.factory.employee.EngineerInTestingFactory;
import company.factory.employee.SoftwareEngineerFactory;
import company.structure.Company;
import company.structure.teams.ITeam;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // Создаем структуру компании
        Company company = Company.getInstance();
        IDepartmentFactory departmentFactory = new DepartmentFactory();
        IDepartment department = departmentFactory.createDepartment();
        company.addDepartment(department);
        ITeamFactory teamFactory = new TeamFactory();
        ITeam firstTeam = teamFactory.createTeam();
        ITeam secondTeam = teamFactory.createTeam();
        company.addTeam(firstTeam);
        company.addTeam(secondTeam);

        // Создаем сотрудников
        EmployeeFactory softwareEngineerFactory = new SoftwareEngineerFactory();
        EmployeeFactory engineerInTestingFactory = new EngineerInTestingFactory();
        IEmployee employeeSE = softwareEngineerFactory.createEmployee();
        IEmployee teamlead = softwareEngineerFactory.createEmployee();
        IEmployee engineerInTesting = engineerInTestingFactory.createEmployee();

        // Нанимаем сотрудников и добавляем в команды и отделы
        company.hireEmployee(employeeSE);
        company.hireEmployee(teamlead);
        company.hireEmployee(engineerInTesting);
        company.addEmployeeToDepartment(employeeSE, department);
        company.addEmployeeToDepartment(teamlead, department);
        company.addEmployeeToDepartment(engineerInTesting, department);
        company.appointAsDepartmentHead(teamlead, department);
        company.addEmployeeToTeam(employeeSE, firstTeam);
        company.addEmployeeToTeam(teamlead, firstTeam);
        company.addEmployeeToTeam(engineerInTesting, firstTeam);
        company.appointAsTeamLead(teamlead, firstTeam);

        // Создаем проект и задачи
        ProjectFactory projectFactory = new ProjectFactory();
        Project project = projectFactory.createProject();
        DefectFactory defectFactory = new DefectFactory();
        IServiceCall defect1 = defectFactory.createTask();
        ((Defect)defect1).evaluateTask(24);
        IServiceCall defect2 = defectFactory.createTask();
        ((Defect)defect2).evaluateTask(24);
        DevelopmentFactory developmentFactory = new DevelopmentFactory();
        IServiceCall development1 = developmentFactory.createTask();
        ((Development)development1).evaluateTask(80);
        IServiceCall development2 = developmentFactory.createTask();
        ((Development)development2).evaluateTask(80);
        project.addAllServiceCalls(defect1,defect2,development1,development2);

        // Назначаем ответственных на задачи
        // Выполняем задачи
        while (!project.isProjectReady()){
            IServiceCall task = null;
            if(null != (task=project.findServiceCallsToDo())){
                if(task.setResponsible(employeeSE)) {
                    employeeSE.doTask(task);
                }
            }
            if(null != (task=project.findServiceCallsToDo())){
                if(task.setResponsible(teamlead)) {
                    teamlead.doTask(task);
                }
            }
            if(null != (task=project.findServiceCallsToDo())){
                if(task.setResponsible(engineerInTesting)) {
                    engineerInTesting.doTask(task);
                }
            }
        }
    }
}
