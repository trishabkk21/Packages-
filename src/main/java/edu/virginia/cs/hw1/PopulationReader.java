package edu.virginia.cs.hw1;

import org.json.JSONArray;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class PopulationReader {
    public static final String datacsvform = "TODO";
    public static final int numRepresentatives = 435;
    public JSONArray test = new JSONArray();

    private InputStreamReader getAPIReader() throws IOException {
        URL dataURL = new URL(datacsvform);
        InputStream apiStream = dataURL.openStream();
        return new InputStreamReader(apiStream, StandardCharsets.UTF_8);
    }

    private void populateArray() {

    }
}
