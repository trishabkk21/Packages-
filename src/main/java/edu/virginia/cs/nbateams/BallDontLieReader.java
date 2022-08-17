package edu.virginia.cs.nbateams;

import org.json.JSONObject;

import java.io.*;
import java.net.*;
import java.nio.charset.*;
import java.util.stream.*;

public class BallDontLieReader {
    public static final String apiURL = "https://www.balldontlie.io/api/v1/teams";


    public JSONObject getAllNBATeams() {
        try {
            URL balldontlieAPI = new URL(apiURL);
            InputStream apiStream = balldontlieAPI.openStream();
            InputStreamReader apiReader = new InputStreamReader(apiStream, StandardCharsets.UTF_8);
            BufferedReader bufferedReader = new BufferedReader(apiReader);
            String jsonText = bufferedReader.lines().collect(Collectors.joining());
            return new JSONObject(jsonText);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
