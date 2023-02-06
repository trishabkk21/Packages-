package edu.virginia.cs.nbateams;

import java.util.Arrays;

public enum Conference { 
    EASTERN,
    WESTERN;

    static Conference getConference(String conferenceText) {
        String uppercaseConference = conferenceText.toUpperCase();
        return switch (uppercaseConference) {
            case "EAST", "EASTERN" -> EASTERN;
            case "WEST", "WESTERN" -> WESTERN;
            default -> throw new IllegalArgumentException("Illegal edu.virginia.cs.nbateams.Conference name: " +
                    conferenceText + "\n"+
                    "\tAccepted conferences: " + Arrays.toString(Conference.values()));
        };
    }
}
