package company.factory.department;

import company.structure.departments.Department;
import company.structure.departments.IDepartment;

import java.util.Random;

public class DepartmentFactory implements IDepartmentFactory {
    protected static String[] names = {"Департамент ИТ и процессов обслуживания"};
    private Random random = new Random();

    @Override
    public IDepartment createDepartment() {
        int nameIndex = random.nextInt(names.length);
        return createDepartment(names[nameIndex]);
    }

    @Override
    public IDepartment createDepartment(String name) {
        return new Department(name);
    }
}
