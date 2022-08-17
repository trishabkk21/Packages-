package edu.virginia.cs.nbateams;

import org.json.JSONObject;

import java.io.*;
import java.net.*;
import java.nio.charset.*;
import java.util.stream.*;

public class BallDontLieReader {
    public static final String ballDontLieAPITeamsApiURL = "https://www.balldontlie.io/api/v1/teams";


    public JSONObject getAllNBATeams() {
        try {
            String jsonText = getJSONText();
            return new JSONObject(jsonText);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private String getJSONText() throws IOException {
        InputStreamReader apiReader = getAPIReader();
        return getTextFromAPIReader(apiReader);
    }

    private String getTextFromAPIReader(InputStreamReader apiReader) {
        BufferedReader bufferedReader = new BufferedReader(apiReader);
        return bufferedReader.lines().collect(Collectors.joining());
    }

    private InputStreamReader getAPIReader() throws IOException {
        URL ballDontLieAPI = new URL(ballDontLieAPITeamsApiURL);
        InputStream apiStream = ballDontLieAPI.openStream();
        return new InputStreamReader(apiStream, StandardCharsets.UTF_8);
    }
}
