package edu.virginia.cs.hw1;

import org.json.JSONArray;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.FileInputStream;

public class PopulationReader {
   public static final String populationreaderpath =  "src/test/java/edu/virginia/cs/hw1/1990census.csv";
    public static final int numRepresentatives = 435;
    public JSONArray test = new JSONArray();


    public InputStreamReader getAPIReader() throws IOException {
        return new InputStreamReader(new FileInputStream(populationreaderpath));
    }




}

