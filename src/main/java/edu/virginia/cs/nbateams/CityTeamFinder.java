package edu.virginia.cs.nbateams;

import java.util.*;

public class CityTeamFinder {
    private NBATeamReader teamReader;

    protected CityTeamFinder(NBATeamReader teamReader) {
        this.teamReader = teamReader;
    }

    public CityTeamFinder() {
        this(new NBATeamReader());
    }

    public Set<NBATeam> getTeamsFromLocations(List<String> locations) {
        List<NBATeam> teams = teamReader.getNBATeams();
        Set<NBATeam> teamsFromLocations = new HashSet<>();
        for (NBATeam team : teams) {
            if (locations.contains(team.getCity())) {
                teamsFromLocations.add(team);
            }
        }
        return teamsFromLocations;
    }
}
