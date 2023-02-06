package edu.virginia.cs.hw1;

import org.json.JSONArray;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class PopulationReader {
    public static final String populationreaderURL = "https://drive.google.com/file/d/1E7J0Q3AnhXK2mUd-gApXH-iz_S7TLfLG/view?usp=share_link";
    public static final int numRepresentatives = 435;
    public JSONArray test = new JSONArray();


    private InputStreamReader getAPIReader() throws IOException {
        URL dataURL = new URL(populationreaderURL);
        InputStream apiStream = dataURL.openStream();
        return new InputStreamReader(apiStream, StandardCharsets.UTF_8);
    }




}

