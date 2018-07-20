package company.factory.department;

import company.structure.departments.IDepartment;

public interface IDepartmentFactory {
    IDepartment createDepartment();
    IDepartment createDepartment(String name);
}
