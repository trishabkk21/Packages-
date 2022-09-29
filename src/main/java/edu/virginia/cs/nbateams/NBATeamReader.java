package edu.virginia.cs.nbateams;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.*;

public class NBATeamReader {
    private final List<NBATeam> memo = new ArrayList<>();
    private final BallDontLieReader apiReader;

    protected NBATeamReader(BallDontLieReader apiReader) {
        this.apiReader = apiReader;
    }
    public NBATeamReader() {
        this(new BallDontLieReader());
    }



    public List<NBATeam> getNBATeams() {
        if (!memo.isEmpty()) {
            return memo;
        }
        getTeamsFromAPI();
        return memo;
    }

    private void getTeamsFromAPI() {
        JSONArray teamArray = getTeamsArrayFromAPI();
        for (Object teamObject : teamArray) {
            JSONObject teamJSon = (JSONObject) teamObject;
            NBATeam newTeam = getTeamFromJSONObject(teamJSon);
            memo.add(newTeam);
        }
    }

    private JSONArray getTeamsArrayFromAPI() {
        JSONObject apiOutput = apiReader.getAllNBATeams();
        return apiOutput.getJSONArray("data");
    }

    private NBATeam getTeamFromJSONObject(JSONObject teamJSon) {
        int id = teamJSon.getInt("id");
        String abbreviation = teamJSon.getString("abbreviation");
        String city = teamJSon.getString("city");
        String name = teamJSon.getString("name");

        Conference conference = getConference(teamJSon);
        Division division = getDivision(teamJSon);

        return new NBATeam(id, name, city, abbreviation,
                conference, division);
    }

    private Division getDivision(JSONObject teamJSon) {
        String divisionText = teamJSon.getString("division");
        return Division.getDivision(divisionText);
    }

    private Conference getConference(JSONObject teamJSon) {
        String conferenceText = teamJSon.getString("conference");
        return Conference.getConference(conferenceText);
    }

}
