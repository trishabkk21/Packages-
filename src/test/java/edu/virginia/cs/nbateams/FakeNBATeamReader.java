package edu.virginia.cs.nbateams;

import java.util.*;

public class FakeNBATeamReader extends NBATeamReader {
    public List<NBATeam> getNBATeams() {
        return generateFakeNBATeamList();
    }

    private List<NBATeam> generateFakeNBATeamList() {
        NBATeam lakers = new NBATeam(1,"Lakers","Los Angelos","LAL",
                Conference.WESTERN, Division.PACIFIC);
        NBATeam celtics = new NBATeam(2, "Celtics", "Boston", "BOS",
                Conference.EASTERN, Division.ATLANTIC);
        return List.of(lakers, celtics);
    }
}
