package company.factory.employee;

import company.structure.actors.IEmployee;
import company.structure.actors.Trainee;
import company.wages.Reward;

public class TraineeFactory extends EmployeeFactory {
    @Override
    public IEmployee createEmployee() {
        int nameIndex = random.nextInt(names.length);
        int surnameIndex = random.nextInt(surnames.length);
        return createEmployee(names[nameIndex] + " " + surnames[surnameIndex]);
    }

    @Override
    public IEmployee createEmployee(String name) {
        return new Trainee(name, new Reward(random.nextInt(60000) + 10000));
    }
}
