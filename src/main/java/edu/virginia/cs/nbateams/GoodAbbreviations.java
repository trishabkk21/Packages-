package edu.virginia.cs.nbateams;

import java.util.List;
import java.util.stream.Collectors;

public class GoodAbbreviations {
    public List<NBATeam> extractGoodAbbreviationTeams(NBATeamReader nbaTeamReader) {
        List<NBATeam> allTeams = nbaTeamReader.getNBATeams();
        return allTeams.stream()
                .filter(GoodAbbreviations::abbreviationMatchFirstThreeLettersOfCity)
                .collect(Collectors.toList());
    }

    private static boolean abbreviationMatchFirstThreeLettersOfCity(NBATeam x) {
        return x.getAbbreviation().equalsIgnoreCase(
                x.getCity().substring(0, Math.min(x.getCity().length(), 3)));
    }
}
