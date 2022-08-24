package edu.virginia.cs.nbateams;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

public class NBATeamXSLXWriter {
    private final String excelFilename;
    private final String[] COLUMN_HEADERS =
            {"ID", "Abbrv", "City", "Name", "Conference", "Division"};
    private int rowCount;

    public NBATeamXSLXWriter(String excelFilename) {
        this.excelFilename = excelFilename;
        this.rowCount = 0;
    }

    public void writeNBATeamsToFile(List<NBATeam> nbaTeamList) throws IOException {
        Workbook workbook = new XSSFWorkbook();
        populateSaveAndCloseWorkbook(nbaTeamList, workbook);
    }

    private void populateSaveAndCloseWorkbook(List<NBATeam> nbaTeamList, Workbook workbook) throws IOException {
        Sheet worksheet = workbook.createSheet("NBA Teams");
        Row titleRow = getNextRow(worksheet);
        putHeaderStringArrayInFirstRow(titleRow, COLUMN_HEADERS);
        addTeamsToWorksheet(nbaTeamList, worksheet);
        resizeColumns(worksheet);
        saveAndCloseWorkbook(workbook);
    }

    private void addTeamsToWorksheet(List<NBATeam> nbaTeamList, Sheet worksheet) {
        for (NBATeam team : nbaTeamList) {
            String[] teamArray = getTeamStringArray(team);
            Row newRow = getNextRow(worksheet);
            putHeaderStringArrayInFirstRow(newRow, teamArray);
        }
    }

    private void saveAndCloseWorkbook(Workbook workbook) throws IOException {
        FileOutputStream fileOut = new FileOutputStream(excelFilename);
        workbook.write(fileOut);
        fileOut.close();
        workbook.close();
    }

    private void resizeColumns(Sheet worksheet) {
        for (int columnIndex = 0; columnIndex < COLUMN_HEADERS.length; columnIndex++) {
            worksheet.autoSizeColumn(columnIndex);
        }
    }

    private void putHeaderStringArrayInFirstRow(Row titleRow, String[] COLUMN_HEADERS) {
        for (int columnIndex = 0; columnIndex < COLUMN_HEADERS.length; columnIndex++) {
            Cell newCell = titleRow.createCell(columnIndex);
            newCell.setCellValue(COLUMN_HEADERS[columnIndex]);
        }
    }

    private void putNBATeamArrayInRow(Row row, String[] contents) {
        Cell idCell = row.createCell(0);
        idCell.setCellValue(Integer.parseInt(contents[0]));
        for (int columnIndex = 1; columnIndex < contents.length; columnIndex++) {
            Cell newCell = row.createCell(columnIndex);
            newCell.setCellValue(contents[columnIndex]);
        }
    }

    private Row getNextRow(Sheet worksheet) {
        Row newRow = worksheet.createRow(rowCount);
        rowCount++;
        return newRow;
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
