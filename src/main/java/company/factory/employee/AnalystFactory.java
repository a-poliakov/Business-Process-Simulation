package company.factory.employee;

import company.structure.actors.Analyst;
import company.structure.actors.IEmployee;
import company.wages.Wage;

public class AnalystFactory extends EmployeeFactory {
    @Override
    public IEmployee createEmployee() {
        int nameIndex = random.nextInt(names.length);
        int surnameIndex = random.nextInt(surnames.length);
        return createEmployee(names[nameIndex] + " " + surnames[surnameIndex]);
    }

    @Override
    public IEmployee createEmployee(String name) {
        return new Analyst(name, new Wage(random.nextInt(30000) + 10000, 30));
    }
}
