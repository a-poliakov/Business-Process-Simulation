package company.factory.employee;

import company.wages.Wage;
import company.structure.actors.EngineerInTesting;
import company.structure.actors.IEmployee;

public class EngineerInTestingFactory extends EmployeeFactory {

    @Override
    public IEmployee createEmployee() {
        int nameIndex = random.nextInt(names.length);
        int surnameIndex = random.nextInt(surnames.length);
        return createEmployee(names[nameIndex] + " " + surnames[surnameIndex]);
    }

    @Override
    public IEmployee createEmployee(String name) {
        return new EngineerInTesting(name, new Wage(random.nextInt(30000) + 10000, 30));
    }
}
