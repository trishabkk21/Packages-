package edu.virginia.cs.nbateams;

import org.junit.jupiter.api.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TeamCityFinderIntegrationTest {
    private CityTeamFinder testTeamFinder;
    private NBATeamReader teamReader;
    private static NBATeam CELTICS = new NBATeam(2, "Celtics", "Boston", "BOS",
            Conference.EASTERN, Division.ATLANTIC);

    @BeforeEach
    public void setup() {
        teamReader = new NBATeamReader();
        testTeamFinder = new CityTeamFinder(teamReader);
    }

    @Test
    public void testSingleCity() {
        Set<NBATeam> teamsInBoston = testTeamFinder.getTeamsFromLocations(List.of("Boston"));

        HashSet<NBATeam> expected = new HashSet<>();
        expected.add(CELTICS);

        assertEquals(expected, teamsInBoston);
    }
}
