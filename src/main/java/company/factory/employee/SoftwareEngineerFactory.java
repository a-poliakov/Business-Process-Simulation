package company.factory.employee;

import company.wages.Wage;
import company.structure.actors.IEmployee;
import company.structure.actors.SoftwareEngineer;

public class SoftwareEngineerFactory extends EmployeeFactory{

    @Override
    public IEmployee createEmployee() {
        int nameIndex = random.nextInt(names.length);
        int surnameIndex = random.nextInt(surnames.length);
        return createEmployee(names[nameIndex] + " " + surnames[surnameIndex]);
    }

    @Override
    public IEmployee createEmployee(String name) {
        return new SoftwareEngineer(name, new Wage(random.nextInt(60000) + 10000, 30));
    }
}
