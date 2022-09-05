package edu.virginia.cs.nbateams;

import java.util.List;
import java.util.stream.Collectors;

public class GoodAbbreviations {
    public List<NBATeam> extractGoodAbbreviationTeams(NBATeamReader nbaTeamReader) {
        List<NBATeam> allTeams = nbaTeamReader.getNBATeams();
        return allTeams.stream()
                .filter(x -> x.getAbbreviation().equalsIgnoreCase(
                        x.getCity().substring(0, Math.min(x.getCity().length(), 3))))
                .collect(Collectors.toList());
    }
}
