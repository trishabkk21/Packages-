package edu.virginia.cs.nbateams;

public enum Division {
    ATLANTIC,
    CENTRAL,
    SOUTHEAST,
    NORTHWEST,
    PACIFIC,
    SOUTHWEST;

    public static Division getDivision(String divisionText) {
        return switch(divisionText) {
            case "Atlantic" -> ATLANTIC;
            case "Central" -> CENTRAL;
            case "Southeast" -> SOUTHEAST;
            case "Northwest" -> NORTHWEST;
            case "Pacific" -> PACIFIC;
            case "Southwest" -> SOUTHWEST;
            default -> throw new IllegalArgumentException("Illegal edu.virginia.cs.nbateams.Division name: " + divisionText);
        };
    }
}
