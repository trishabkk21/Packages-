package edu.virginia.cs.nbateams;

public class NBATeam {
    private final int id;
    private final String name;
    private final String city;
    private final String abbreviation;
    private final Conference conference;
    private final Division division;

    public NBATeam(int id, String name, String city, String abbreviation,
                   Conference conference, Division division) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.abbreviation = abbreviation;
        this.conference = conference;
        this.division = division;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public Conference getConference() {
        return conference;
    }

    public Division getDivision() {
        return division;
    }
}
