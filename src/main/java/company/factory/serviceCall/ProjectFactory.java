package company.factory.serviceCall;

import company.services.project.Project;

import java.util.Random;

public class ProjectFactory implements IProjectFactory {
    private static String[] names = {"SMP Release 2017"};
    private Random random = new Random();

    @Override
    public Project createProject() {
        int nameIndex = random.nextInt(names.length);
        return createProject(names[nameIndex]);
    }

    @Override
    public Project createProject(String name) {
        return new Project(name);
    }
}
