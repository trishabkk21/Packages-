package edu.virginia.cs.nbateams;

import java.io.IOException;
import java.util.*;

public class Main {
    private static final String DEFAULT_XLSX_FILENAME = "NBA Teams.xlsx";

    private String filename;

    public static void main(String[] args) throws IOException {
        String filename = getFileName(args);
        List<NBATeam> teams = getNbaTeamsList();
        writeNBATeamsListToExcelFile(filename, teams);
    }

    private static void writeNBATeamsListToExcelFile(String filename, List<NBATeam> teams) throws IOException {
        NBATeamXSLXWriter writer = new NBATeamXSLXWriter(filename);
        writer.writeNBATeamsToFile(teams);
    }

    private static List<NBATeam> getNbaTeamsList() {
        NBATeamReader reader = new NBATeamReader();
        List<NBATeam> teams = reader.getNBATeams();
        return teams;
    }

    private static String getFileName(String[] args) {
        String filename = getFileNameString(args);
        if (!filename.toUpperCase().endsWith(".XLSX")) {
            throw new RuntimeException("Error: Invalid filename - " + filename);
        }
        return filename;
    }

    private static String getFileNameString(String[] args) {
        if (args.length > 0) {
            return args[0];
        } else {
            return DEFAULT_XLSX_FILENAME;
        }
    }
}
