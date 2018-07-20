package company.factory.serviceCall;

import company.services.project.Project;

public interface IProjectFactory {
    Project createProject();
    Project createProject(String name);
}
