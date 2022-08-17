package edu.virginia.cs.nbateams;

public enum Conference {
    EASTERN,
    WESTERN;

    static Conference getConference(String conferenceText) {
        return switch (conferenceText) {
            case "East" -> EASTERN;
            case "West" -> WESTERN;
            default -> throw new IllegalArgumentException("Illegal edu.virginia.cs.nbateams.Conference name: " + conferenceText);
        };
    }
}
