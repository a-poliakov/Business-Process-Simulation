package company.factory.department;

import company.structure.teams.ITeam;
import company.structure.teams.Team;

import java.util.Random;

public class TeamFactory implements ITeamFactory {
    private static String[] names = {"Группа мобильной разработки", "Группа проектной разработки ЧЛБ", "Релизная группа"};
    private Random random = new Random();

    @Override
    public ITeam createTeam() {
        int nameIndex = random.nextInt(names.length);
        return createTeam(names[nameIndex]);
    }

    @Override
    public ITeam createTeam(String name) {
        return new Team(name);
    }
}
