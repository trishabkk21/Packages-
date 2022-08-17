package edu.virginia.cs.nbateams;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.*;

public class NBATeamReader {
    private List<NBATeam> memo = new ArrayList<>();

    public List<NBATeam> getNBATeams() {
        if (!memo.isEmpty()) {
            return memo;
        }
        getTeamsFromAPI();
        return memo;
    }

    private void getTeamsFromAPI() {
        BallDontLieReader apiReader = new BallDontLieReader();
        JSONObject apiOutput = apiReader.getAllNBATeams();
        JSONArray teamArray = apiOutput.getJSONArray("data");
        for (Object teamObject : teamArray) {
            JSONObject teamJSon = (JSONObject) teamObject;
            int id = teamJSon.getInt("id");
            String abbreviation = teamJSon.getString("abbreviation");
            String city = teamJSon.getString("city");
            String name = teamJSon.getString("name");

            String conferenceText = teamJSon.getString("conference");
            Conference conference = Conference.getConference(conferenceText);
            String divisionText = teamJSon.getString("division");
            Division division = Division.getDivision(divisionText);

            NBATeam newTeam = new NBATeam(id, name, city, abbreviation,
                    conference, division);
            memo.add(newTeam);
        }
    }

}
