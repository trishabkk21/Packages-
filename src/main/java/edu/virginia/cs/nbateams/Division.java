package edu.virginia.cs.nbateams;

import java.util.Arrays;

public enum Division {
    ATLANTIC,
    CENTRAL,
    SOUTHEAST,
    NORTHWEST,
    PACIFIC,
    SOUTHWEST;

    public static Division getDivision(String divisionText) {
        String uppercaseDivision = divisionText.toUpperCase();
        return switch(uppercaseDivision) {
            case "ATLANTIC" -> ATLANTIC;
            case "CENTRAL" -> CENTRAL;
            case "SOUTHEAST" -> SOUTHEAST;
            case "NORTHWEST" -> NORTHWEST;
            case "PACIFIC" -> PACIFIC;
            case "SOUTHWEST" -> SOUTHWEST;
            default -> throw new IllegalArgumentException("Illegal edu.virginia.cs.nbateams.Division name: "
                    + divisionText + "\n"+
                    "\tAccepted Divisions: " + Arrays.toString(Conference.values()));
        };
    }
}
