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

    @Override
    public String toString() {
        return "NBATeam{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", abbreviation='" + abbreviation + '\'' +
                ", conference=" + conference +
                ", division=" + division +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NBATeam nbaTeam = (NBATeam) o;

        if (getId() != nbaTeam.getId()) return false;
        if (!getName().equals(nbaTeam.getName())) return false;
        if (!getCity().equals(nbaTeam.getCity())) return false;
        if (!getAbbreviation().equals(nbaTeam.getAbbreviation())) return false;
        if (getConference() != nbaTeam.getConference()) return false;
        return getDivision() == nbaTeam.getDivision();
    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + getName().hashCode();
        result = 31 * result + getCity().hashCode();
        return result;
    }
}
