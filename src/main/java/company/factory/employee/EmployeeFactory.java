package company.factory.employee;

import company.structure.actors.IEmployee;

import java.util.Random;

public abstract class EmployeeFactory {

    protected static String[] names = {"Иван", "Василий", "Андрей", "Владимир", "Максим", "Артем"};
    protected static String[] surnames = {"Петров", "Иванов", "Орлов", "Валунов", "Худяков", "Мурза", "Нерчанов", "Потапов"};
    protected Random random = new Random();

    public abstract IEmployee createEmployee();
    public abstract IEmployee createEmployee(String name);
}
