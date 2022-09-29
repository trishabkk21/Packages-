package edu.virginia.cs.nbateams;


import org.junit.jupiter.api.*;
import org.json.*;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class GoodAbbreviationsIntegrationTest {
    private GoodAbbreviations goodAbbreviations;
    private NBATeamReader nbaTeamReader;
    private BallDontLieReader mockBDLReader;

    private static final NBATeam CELTICS = new NBATeam(2, "Celtics", "Boston", "BOS",
            Conference.EASTERN, Division.ATLANTIC);

    @BeforeEach
    public void setup() {
        goodAbbreviations = new GoodAbbreviations();

        mockBDLReader = mock(BallDontLieReader.class);
        nbaTeamReader = new NBATeamReader(mockBDLReader);
    }

    @Test
    public void testGoodAbbreviationsFromNBATeamReader() {
        JSONObject mockJSONObject = getMockJSONObject();
        when(mockBDLReader.getAllNBATeams()).thenReturn(mockJSONObject);

        List<NBATeam> goodAbbrvTeams = goodAbbreviations.extractGoodAbbreviationTeams(nbaTeamReader);
        assertIterableEquals(goodAbbrvTeams, List.of(CELTICS));

    }

    private JSONObject getMockJSONObject() {
        String mockJSONString = """
                {
                  "data":[
                     {"id":2,"abbreviation":"BOS","city":"Boston","conference":"East","division":"Atlantic",
                             "full_name":"Boston Celtics","name":"Celtics"},
                     {"id":14,"abbreviation":"LAL","city":"Los Angeles","conference":"West","division":"Pacific",
                             "full_name":"Los Angeles Lakers","name":"Lakers"}
                    ]
                }
                """;

        JSONObject teamsJSONObject = new JSONObject(mockJSONString);
        return teamsJSONObject;

    }
}
