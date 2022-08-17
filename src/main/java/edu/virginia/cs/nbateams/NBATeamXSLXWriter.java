package edu.virginia.cs.nbateams;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

public class NBATeamXSLXWriter {
    private final String excelFilename;
    private int rowCount;
    private final String[] COLUMN_HEADERS =
            {"ID", "Abbrv", "City", "Name", "Conference", "Division"};

    public NBATeamXSLXWriter(String excelFilename) {
        this.excelFilename = excelFilename;
        this.rowCount = 0;
    }

    public void writeNBATeamsToFile(List<NBATeam> nbaTeamList) throws IOException {
        Workbook workbook = new XSSFWorkbook();
        Sheet worksheet = workbook.createSheet("NBA Teams");
        Row titleRow = worksheet.createRow(0);
        rowCount++;
        for (int columnIndex = 0; columnIndex < COLUMN_HEADERS.length; columnIndex++) {
            Cell newCell = titleRow.createCell(columnIndex);
            newCell.setCellValue(COLUMN_HEADERS[columnIndex]);
        }
        for (NBATeam team : nbaTeamList) {
            String[] teamArray = getTeamStringArray(team);
            Row newRow = worksheet.createRow(rowCount);
            rowCount++;
            for (int columnIndex = 0; columnIndex < COLUMN_HEADERS.length; columnIndex++) {
                Cell newCell = newRow.createCell(columnIndex);
                newCell.setCellValue(teamArray[columnIndex]);
            }
        }
        for (int columnIndex = 0; columnIndex < COLUMN_HEADERS.length; columnIndex++) {
            worksheet.autoSizeColumn(columnIndex);
        }

        FileOutputStream fileOut = new FileOutputStream(excelFilename);
        workbook.write(fileOut);
        fileOut.close();
        workbook.close();
    }

    private String[] getTeamStringArray(NBATeam team) {
        String[] teamArray = new String[6];
        teamArray[0] = Integer.toString(team.getId());
        teamArray[1] = team.getAbbreviation();
        teamArray[2] = team.getCity();
        teamArray[3] = team.getName();
        teamArray[4] = team.getConference().name();
        teamArray[5] = team.getDivision().name();
        return teamArray;
    }
}
