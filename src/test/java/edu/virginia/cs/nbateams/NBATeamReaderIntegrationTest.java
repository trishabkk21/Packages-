package edu.virginia.cs.nbateams;

import org.junit.jupiter.api.*;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class NBATeamReaderIntegrationTest {
    @Test
    public void getsThirtyTeams() {
        NBATeamReader reader = new NBATeamReader();
        List<NBATeam> teams = reader.getNBATeams();
        assertEquals(30, teams.size());
    }
}