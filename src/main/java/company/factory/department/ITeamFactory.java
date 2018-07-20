package company.factory.department;

import company.structure.teams.ITeam;

public interface ITeamFactory {
    ITeam createTeam();
    ITeam createTeam(String name);
}
