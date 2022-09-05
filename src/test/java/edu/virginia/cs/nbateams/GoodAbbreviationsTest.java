package edu.virginia.cs.nbateams;

import org.junit.jupiter.api.*;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class GoodAbbreviationsTest {
    private NBATeamReader reader;

    private static NBATeam LAKERS, CELTICS;

    @BeforeAll
    public static void init() {
        LAKERS = new NBATeam(1,"Lakers","Los Angelos","LAL",
                Conference.WESTERN, Division.PACIFIC);
        CELTICS = new NBATeam(2, "Celtics", "Boston", "BOS",
                Conference.EASTERN, Division.ATLANTIC);
    }

    @BeforeEach
    public void setup() {
        reader = mock(NBATeamReader.class);
    }

    @Test
    public void testGoodAbbreviations() {
        when(reader.getNBATeams()).thenReturn(List.of(LAKERS, CELTICS));

        GoodAbbreviations abbreviations = new GoodAbbreviations();

        List<NBATeam> expected = new ArrayList<>();
        expected.add(CELTICS);

        List<NBATeam> goodAbbreviationsTeams = abbreviations.extractGoodAbbreviationTeams(reader);
        assertEquals(expected, goodAbbreviationsTeams);
    }
}
