package edu.virginia.cs.nbateams;

import org.junit.jupiter.api.*;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class GoodAbbreviationsTest {
    @Test
    public void testGoodAbbreviations() {
        GoodAbbreviations abbreviations = new GoodAbbreviations();
        NBATeamReader reader = new StubNBATeamReader();
        List<NBATeam> goodAbbreviationsTeams = abbreviations.extractGoodAbbreviationTeams(reader);
        List<NBATeam> expected = List.of(StubNBATeamReader.CELTICS);
        assertEquals(expected, goodAbbreviationsTeams);
    }
}
