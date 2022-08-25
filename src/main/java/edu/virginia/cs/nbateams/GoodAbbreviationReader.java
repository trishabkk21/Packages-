package edu.virginia.cs.nbateams;

// Hypothetical example where we get the number of teams whose abbreviations
// match their first three letters of their city

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

import java.io.*;
import java.util.*;
import java.util.stream.*;

public class GoodAbbreviationReader {
    private final String filename;
    private Workbook workbook;

    private Iterator<Row> rowIterator;

    public static void main(String[] args) {
        String xlsxFilename = "sampleTeams.xlsx";
        GoodAbbreviationReader reader = new GoodAbbreviationReader(xlsxFilename);
        List<NBATeam> teams = reader.getGoodAbbreviationTeams();
        teams.stream().map(team -> team.getAbbreviation() + " : " + team.getCity() + " " + team.getName())
                .forEach(System.out::println);
    }

    public GoodAbbreviationReader(String filename) {
        this.filename = filename;
    }

    public List<NBATeam> getGoodAbbreviationTeams() {
        openXLSXWorkbook();
        List<NBATeam> allTeams = getAllNBATeamsFromWorkbook();
        closeXLSXWorkbook();
        return extractGooAbbreviationTeams(allTeams);
    }



    private void openXLSXWorkbook() {
        try {
            FileInputStream inputStream = new FileInputStream(new File(filename));
            workbook = new XSSFWorkbook(inputStream);
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Error: File " + filename + " not found");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void closeXLSXWorkbook() {
        try {
            workbook.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private List<NBATeam> getAllNBATeamsFromWorkbook() {
        Sheet worksheet = workbook.getSheet("NBA Teams");
        rowIterator = worksheet.rowIterator();
        if (!hasMoreRows()) {
            throw new RuntimeException("Empty Spreadsheet!");
        }
        skipRow(); //skip header row
        return getAllNbaTeamsFromRows();
    }

    private List<NBATeam> getAllNbaTeamsFromRows() {
        List<NBATeam> teams = new ArrayList<>();
        while(hasMoreRows()) {
            Row currentRow = rowIterator.next();
            NBATeam team = getTeamFromRow(currentRow);
            teams.add(team);
        }
        return teams;
    }

    private void skipRow() {
        rowIterator.next();
    }

    private boolean hasMoreRows() {
        return rowIterator.hasNext();
    }

    private NBATeam getTeamFromRow(Row currentRow) {
        int id = (int) currentRow.getCell(0).getNumericCellValue();
        String abbreviation = currentRow.getCell(1).getStringCellValue();
        String city = currentRow.getCell(2).getStringCellValue();
        String name = currentRow.getCell(3).getStringCellValue();

        String conferenceText = currentRow.getCell(4).getStringCellValue();
        Conference conference = Conference.getConference(conferenceText);

        String divisionText = currentRow.getCell(5).getStringCellValue();
        Division division = Division.getDivision(divisionText);

        return new NBATeam(id, name, city, abbreviation, conference, division);
    }

    private List<NBATeam> extractGooAbbreviationTeams(List<NBATeam> allTeams) {
        List<NBATeam> filteredTeams = allTeams.stream()
                .filter(x -> x.getAbbreviation().equals(
                        x.getCity().substring(0,
                                Math.min(x.getCity().length(), 3))
                                .toUpperCase()))
                .collect(Collectors.toList());
        return filteredTeams;
    }
}
